import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

/**
 * Created by elena on 28.11.15.
 */
public class GnuPlot {
    private String directory = "out/";
    private HashMap<String, Double> maxValues = new HashMap<String, Double>();
    private HashMap<String, Double> minValues = new HashMap<String, Double>();
    private String Fi2 = "Fi2";
    private String Fi6 = "Fi6";
    private String IL = "IL";

    private List<XVector> resultsXVector;
    private List<Double> resultIL;
    private List<Double> resultsTime;
    private Settings settings;

    public GnuPlot(Solver solver) {
        this.resultsXVector = solver.getResultXVector();
        this.resultsTime = solver.getResultsTime();
        this.settings = solver.getSettings();
        this.resultIL = solver.getResultIl();
    }

    public void printAll() {
        try {
            printToFile(Fi2, (XVector x) -> x.Fi2());
            printToFile(Fi6, (XVector x) -> x.Fi6());
            List<String> Fi = new ArrayList<>();
            Fi.add(Fi2);
            Fi.add(Fi6);
            createGnuplotScript("Fi_result.script", Fi, "U, V", "Time, s");
            printToFile2(IL, resultIL);
            List<String> I = new ArrayList<>();
            I.add(IL);
            createGnuplotScript("I_result.script", I, "I, A", "Time, s");

        } catch (Exception e) {
            System.out.println("Error While printing to files");
        }
    }

    public void printToFile2(String fileName, List<Double> f) throws Exception {
        PrintWriter out = new PrintWriter(directory + fileName);
        Double max = resultIL.get(0);
        Double min = resultIL.get(0);
        for (int i = 0; i < resultIL.size(); ++i) {
            double time = resultsTime.get(i);
            Double vector = resultIL.get(i);
            out.println(time + " " + vector);
            if (vector > max) {
                max = vector;
            }
            if (vector < min) {
                min = vector;
            }
        }
        maxValues.put(fileName, max);
        minValues.put(fileName, min);
        out.close();
    }

    public void printToFile (String fileName, Function<XVector, Double> f) throws Exception {
        PrintWriter out = new PrintWriter(directory + fileName);
        Double max = f.apply(resultsXVector.get(0));
        Double min = f.apply(resultsXVector.get(0));
        for (int i = 0; i < resultsXVector.size(); ++i) {
            double time = resultsTime.get(i);
            XVector vector = resultsXVector.get(i);
            out.println(time + " " + f.apply(vector));
            if (f.apply(vector) > max) {
                max = f.apply(vector);
            }
            if (f.apply(vector) < min) {
                min = f.apply(vector);
            }
        }
        maxValues.put(fileName, max);
        minValues.put(fileName, min);
        out.close();
    }

    public void createGnuplotScript(String fileName, List<String> graph, String YTitle, String XTitle) throws Exception{
        double max = maxValues.get(graph.get(0));
        double min = minValues.get(graph.get(0));
        for (int i = 1; i < graph.size(); ++i) {

            double maxTemp = maxValues.get(graph.get(i));
            double minTemp = minValues.get(graph.get(i));
            if (maxTemp > max)
                max = maxTemp;
            if (minTemp < min)
                min = minTemp;
        }

        PrintWriter out = new PrintWriter(directory + fileName);
        String scriptCode = "set terminal x11 size 1360, 700\n" +
                "set xlabel '" + XTitle + "'\n" +
                "set ylabel '" + YTitle + "'\n" +
                "set xrange [" + 0 + ":" + settings.deadLine() + "]\n" +
                "set yrange [" + min + ":" + max + "]\n" +
                "set grid\n" +
                "plot ";
        for (int i = 0; i < (graph.size() - 1); ++i) {
            scriptCode += "'" + graph.get(i) + "' using 1:2 w l lw 2 title '" +
                    graph.get(i) + "',\\\n";
        }
        String temp = graph.get(graph.size() - 1);
        scriptCode += "'" + temp + "' using 1:2 w l lw 2 title '" + temp + "'\n" +
                "pause -1";
        out.print(scriptCode);
        out.close();
    }
}