import java.util.ArrayList;
import java.util.List;

/**
 * Created by elena on 28.11.15.
 */
public class Solver {

    private Settings settings = new Settings();
    private MathModel model = new MathModel(settings);

    private Double time = 0.0;
    private Double dt = settings.startDt();
    private Double lastdt = dt;

    private List<XVector> resultXVector = new ArrayList<>();
    private List<Double> resultsTime = new ArrayList<>();

    public Solver() {
        resultXVector.add(new XVector());
        resultsTime.add(0.0);
    }

    public void solve(){
        int i = 0;
        while (time < settings.deadLine()){
            resultXVector.add(new Step(resultXVector.get(resultXVector.size() - 1)).calculate());
            resultsTime.add(time);
            time += dt;
            lastdt = dt;
            i += 1;
            if (i % 100000 == 0){
                System.out.println("i = " + i);
                System.out.println("Time = " + time);
            }
        }
    }

    private class Step {

        private XVector previousStep;
        private Integer iterationNum = 0;
        private XVector iterationApproximation;

        public Step(XVector vector) {
            previousStep = vector;
            iterationApproximation = new XVector(vector.getVector());
        }

        public XVector calculate() {
            List<Double> B;
            do {
                List <List<Double>> A = model.getAMatrix(dt, iterationApproximation.getDeltaU());
                B = model.getBMatrix(iterationApproximation, previousStep, time, dt);
                Gaus.solve(A, B);
                iterationApproximation.addXVector(B);
            } while (!chekIfEnd(B));
            return iterationApproximation;
        }

        private Boolean chekIfEnd(List<Double> delta) {
            Boolean result = true;
            for (int i = 0; i < delta.size() && result; ++i) {
                if (Math.abs(delta.get(i)) >= 0.001) {
                    result = false;
                }
            }
            if (!result) {
                if (iterationNum > 6) {
                    dt /= 2;
                    System.out.println(dt);
                    iterationApproximation = new XVector(previousStep.getVector());
                    iterationNum = 0;
                } else {
                    iterationNum += 1;
                }
            } else {
                if (resultXVector.size() > 2) {
                    result = analyzeDeviation(new XVector(delta));
                }
            }
            return result;
        }

        private Boolean analyzeDeviation(XVector xVector) {
            double fprev = resultXVector.get(resultXVector.size() - 2).Ue();
            double flast = resultXVector.get(resultXVector.size() - 1).Ue();
            double fcur = settings.eds().E(time + dt);
            double epsilon = Math.abs((dt / (dt + lastdt)) * (fcur - flast - (dt / lastdt) * (flast - fprev)));
            if (epsilon > settings.higtLevel()) {
                dt /= 2;
                return false;
            } else {
                if (epsilon < settings.lowLewel() && dt < 0.0000001) {
                    dt *= 2;
                }
                return true;
            }
        }
    }

    public Settings getSettings() {
        return settings;
    }

    public List<XVector> getResultXVector() {
        return resultXVector;
    }

    public List<Double> getResultsTime() {
        return resultsTime;
    }
}
