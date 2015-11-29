/**
 * Created by elena on 22.11.15.
 */
public class Diod {
    private double Ry;
    private double C;
    private double Rr;
    private double It;
    private double mft;

    public double Ry() { return Ry;}
    public double C() { return C;}
    public double Rr() { return Rr;}
    public double It() { return It;}
    public double mft() {return mft;}

    public Diod(double dRy, double dC, double dRr, double dIt, double dmft){
        Ry = dRy;
        C = dC;
        Rr = dRr;
        It = dIt;
        mft = dmft;
    }

    public Double getMultiplier(Double deltaU){
        return It * Math.exp(deltaU / mft) / mft;
    }

    public Double getI(Double deltaU) { return It * (Math.exp(deltaU / mft) - 1);}


}


//package model
//
///**
// * Created by neikila on 02.11.15.
// */
//class Diod (val Ry: Double, val C: Double, val Rr: Double, val It: Double, val mft: Double){
//        def getMultiplier(deltaU:Double) =
//        It * math.exp(deltaU / mft) / mft
//
//        def getI(deltaU: Double) = It * (math.exp(deltaU / mft) - 1)
//        }