
/**
 * Created by elena on 28.11.15.
 */

public class Settings {
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

    public double e() {return E;}
    public double r1() {return R1;}
    public double c1() {return C1;}
    public double r2() {return R2;}
    public double c2() {return C2;}
    public double r4() {return R4;}
    public double l() {return L;}
    public Diod diod() {return diod;}
    public Eds eds() {return eds;}
    public double deadLine() { return deadLine;}
    public double startDt() { return startDt;}
    public double higtLevel() { return higtLevel;}
    public double lowLewel() { return lowLewel;}

    public Settings(){
        E = 5.0;
        R1 = 1000.0;
        C1 = Math.pow(10,-6);
        R2 = 1000.0;
        C2 = Math.pow(10,-6);
        R4 = 1000.0;
        L = Math.pow(10,-5);
        diod = new Diod(Math.pow(10 ,6), 2 * Math.pow(10, -12), 20.0, Math.pow(10, -12), 0.026);
        eds = new Eds(2 * Math.PI * 10000, 10.0);
        deadLine = Math.pow(10, -3);
        startDt = Math.pow(10, -8) * 5;
        higtLevel = 0.01;
        lowLewel = 0.001;
    }
}

