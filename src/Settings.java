
/**
 * Created by elena on 28.11.15.
 */

public class Settings {
    private double c4;
    private double l3;
    private double r4;
    private double deadLine;
    private double startDt;
    private double higtLevel;
    private double lowLewel;
    private Diod diod;
    private Eds eds;



    public double c4() {return c4;}
    public double l3() {return l3;}
    public double r4() {return r4;}
    public Diod diod() {return diod;}
    public Eds eds() {return eds;}
    public double deadLine() { return deadLine;}
    public double startDt() { return startDt;}
    public double higtLevel() { return higtLevel;}
    public double lowLewel() { return lowLewel;}

    public Settings(){
        c4 = Math.pow(10,-6);
        l3 = 0.003;
        r4 = 1000.0;
        diod = new Diod(Math.pow(10 ,6), 2 * Math.pow(10, -12), 20.0, Math.pow(10, -12), 0.026);
        eds = new Eds(2 * Math.PI * 10000, 10.0);
        deadLine = Math.pow(10, -3);
        startDt = Math.pow(10, -8) * 5;
        higtLevel = 0.01;
        lowLewel = 0.001;
    }

}

//public class Settings {
//    private double E;
//    private double R1;
//    private double C1;
//    private double R2;
//    private double C2;
//    private double R4;
//    private double L;
//    private double deadLine;
//    private double startDt;
//    private double higtLevel;
//    private double lowLewel;
//    private Diod diod;
//    private Eds eds;
//
//    public double e() {return E;}
//    public double r1() {return R1;}
//    public double c1() {return C1;}
//    public double r2() {return R2;}
//    public double c2() {return C2;}
//    public double r4() {return R4;}
//    public double l() {return L;}
//    public Diod diod() {return diod;}
//    public Eds eds() {return eds;}
//    public double deadLine() { return deadLine;}
//    public double startDt() { return startDt;}
//    public double higtLevel() { return higtLevel;}
//    public double lowLewel() { return lowLewel;}
//
//    public Settings(){
//        E = 5.0;
//        R1 = 1000.0;
//        C1 = 1.0;
//        R2 = 1000.0;
//        C2 = 1.0;
//        R4 = 1000.0;
//        L = 0.00001;
//        diod = new Diod(Math.pow(10 ,6), 2 * Math.pow(10, -12), 20.0, Math.pow(10, -12), 0.026);
//        eds = new Eds(2 * Math.PI * 10000, 10.0);
//        deadLine = Math.pow(10, -3);
//        startDt = Math.pow(10, -8) * 5;
//        higtLevel = 0.01;
//        lowLewel = 0.001;
//    }
//
//}




//package model
//
//import model.{Eds, Diod}
//
///**
// * Created by neikila on 02.11.15.
// */
//class Settings {
//    val c4: Double = math.pow(10, -6)
//    val l3: Double = 0.001
//    val r4: Double = 1000.0
//    val diod: Diod = new Diod(math.pow(10, 6), 2 * math.pow(10, -12), 20, math.pow(10, -12), 0.026)
//    val eds: Eds = new Eds(2 * math.Pi * 10000, 10)
//
//    val deadline = math.pow(10, -3)
//
//    val startDt = math.pow(10, -8) * 5
//
//    val highLevel = 0.01
//    val lowLevel = 0.001
//}



//public class Settings {
//    private double E9;
//    private double R10;
//    private double C6;
//    private double R12;
//    private double L6;
//    private double C7;
//    private double R9;
//    private double deadLine;
//    private double startDt;
//    private double higtLevel;
//    private double lowLewel;
//    private Diod diod;
//    private Eds eds;
//
//    public double E9() { return E9;}
//    public double R10() { return R10;}
//    public double C6() { return C6;}
//    public double R12() { return R12;}
//    public double L6() { return L6;}
//    public double C7() { return C7;}
//    public double R9() { return R9;}
//    public Diod diod() {return diod;}
//    public Eds eds() {return eds;}
//    public double deadLine() { return deadLine;}
//    public double startDt() { return startDt;}
//    public double higtLevel() { return higtLevel;}
//    public double lowLewel() { return lowLewel;}
//
//    public Settings(){
//        E9 = 5.0;
//        R10 = 1000.0;
//        C6 = 1.0;
//        R12 = 1000.0;
//        L6 = 0.00001;
//        C7 = 1.0;
//        R9 = 1000.0;
//        diod = new Diod(Math.pow(10 ,6), 2 * Math.pow(10, -12), 20.0, Math.pow(10, -12), 0.026);
//        eds = new Eds(2 * Math.PI * 10000, 10.0);
//        deadLine = Math.pow(10, -3);
//        startDt = Math.pow(10, -8) * 5;
//        higtLevel = 0.01;
//        lowLewel = 0.001;
//    }
//
//}
