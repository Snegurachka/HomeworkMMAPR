import java.util.ArrayList;
import java.util.List;

/**
 * Created by elena on 01.11.15.
 */
import java.util.ArrayList;
import java.util.List;

public class MathModel {
    private double E;
    private double R1;
    private double C1;
    private double R2;
    private double C2;
    private double R4;
    private double L;
    private double deadLine;
    private double startDt;
    private double higtLevel;
    private double lowLewel;
    private Diod diod;
    private Eds eds;

    public MathModel(Settings settings) {
        E = settings.e();
        R1 = settings.r1();
        C1 = settings.c1();
        R2 = settings.r2();
        C2 = settings.c2();
        R4 = settings.r4();
        L = settings.l();
        R4 = settings.r4();
        diod = settings.diod();
        eds = settings.eds();
    }

    public List<List<Double>> getAMatrix(double dt, double deltaU) {
        int size = 8;
        List<List<Double>> result = new ArrayList<>(size);
        List<Double> zero = initZero(size);

        double a = C1 / dt + 1.0 / R1;
        double b = -C1 / dt - 1.0 / R1;
        double c = C1 / dt + 1.0 / R1 + 1.0 / R2 + 1.0 / diod.Rr();
        double d = -1.0 / diod.Rr();
        double e = -1.0 / R2;
        double f = -1.0 / diod.Rr() + diod.getMultiplier(deltaU);
        double g = 1.0 / diod.Rr() + 1.0 / diod.Ry() + diod.C() / dt;
        double h = -diod.getMultiplier(deltaU) - 1.0 / diod.Ry() - diod.C() / dt;
        double i = -diod.getMultiplier(deltaU);
        double j = -1.0 / diod.Ry() - diod.C() / dt;
        double k = -(h);
        double l = 1.0 / R2 + dt / L;
        double m = -dt / L;
        double n = C2 / dt + 1.0 / R4 + dt / L;


        List<Double> Fi1 = new ArrayList<>(zero);
        Fi1.set(0, C1 / dt + 1.0 / R1);
        Fi1.set(1, -C1 / dt - 1.0 / R1);
        Fi1.set(6, 1.0);
        result.add(Fi1);

        List<Double> Fi2 = new ArrayList<>(zero);
        Fi2.set(0, -C1 / dt - 1.0 / R1);
        Fi2.set(1, C1 / dt + 1.0 / R1 + 1.0 / R2 + 1.0 / diod.Rr());
        Fi2.set(2, -1.0 / diod.Rr());
        Fi2.set(4, -1.0 / R2);
        result.add(Fi2);

        List<Double> Fi3 = new ArrayList<>(zero);
        Fi3.set(1, -1.0 / diod.Rr() + diod.getMultiplier(deltaU));
        Fi3.set(2, 1.0 / diod.Rr() + 1.0 / diod.Ry() + diod.C() / dt);
        Fi3.set(3, -diod.getMultiplier(deltaU) - 1.0 / diod.Ry() - diod.C() / dt);
        result.add(Fi3);

        List<Double> Fi4 = new ArrayList<>(zero);
        Fi4.set(1, -diod.getMultiplier(deltaU));
        Fi4.set(2, -1.0 / diod.Ry() - diod.C() / dt);
        Fi4.set(3, -(-diod.getMultiplier(deltaU) - 1.0 / diod.Ry() - diod.C() / dt));
        Fi4.set(7, 1.0);
        result.add(Fi4);

        List<Double> Fi5 = new ArrayList<>(zero);
        Fi5.set(1, -1.0 / R2);
        Fi5.set(4, 1.0 / R2 + dt / L);
        Fi5.set(5, -dt / L);
        result.add(Fi5);

        List<Double> Fi6 = new ArrayList<>(zero);
        Fi6.set(4, -dt / L);
        Fi6.set(5, C2 / dt + 1.0 / R4 + dt / L);
        result.add(Fi6);

        List<Double> IE1 = new ArrayList<>(zero);
        IE1.set(0, 1.0);
        result.add(IE1);

        List<Double> IE2 = new ArrayList<>(zero);
        IE2.set(3, 1.0);
        result.add(IE2);

        return result;
    }

    private List<Double> initZero(int size) {
        List<Double> initList = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            initList.add(0.0);
        }
        return initList;
    }

    public List<Double> getBMatrix(XVector approximate, XVector previous, double time, double dt, double IL) {
        List<Double> result = new ArrayList<>();

        result.add(approximate.IE1() + (C1 / dt) * (approximate.Fi1() - approximate.Fi2() -
                (previous.Fi1() - previous.Fi2())) + (approximate.Fi1() - approximate.Fi2()) / R1);

        result.add(-(C1 / dt) * (approximate.Fi1() - approximate.Fi2() - (previous.Fi1() - previous.Fi2())) -
                (approximate.Fi1() - approximate.Fi2()) / R1 +
                (approximate.Fi2() - approximate.Fi5()) / R2 +
                (approximate.Fi2() - approximate.Fi3()) / diod.Rr());

        result.add(-(approximate.Fi2() - approximate.Fi3()) / diod.Rr() +
                diod.getI(approximate.getDeltaU()) +
                (approximate.Fi3() - approximate.Fi4()) / diod.Ry() +
                (diod.C() / dt) * (approximate.Fi3() - approximate.Fi4() - (previous.Fi3() - previous.Fi4())));

        result.add(-diod.getI(approximate.getDeltaU()) -
                (approximate.Fi3() - approximate.Fi4()) / diod.Ry() -
                (diod.C() / dt) * (approximate.Fi3() - approximate.Fi4() - (previous.Fi3() - previous.Fi4())) +
                approximate.IE2());

        result.add(-(approximate.Fi2() - approximate.Fi5()) / R2 +
                IL + (dt / L) * (approximate.Fi5() - approximate.Fi6()));

        result.add(-IL - (dt / L) * (approximate.Fi5() - approximate.Fi6()) +
                (C2 / dt) * (approximate.Fi6() - previous.Fi6()) +
                approximate.Fi6() / R4);


        result.add(approximate.Fi1() - eds.E(time + dt));
        result.add(approximate.Fi4() - E);


        for (int i = 0; i < result.size(); ++i) {
            result.set(i, -1 * result.get(i));
        }

        return result;
    }
}