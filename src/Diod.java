/**
 * Created by elena on 22.11.15.
 */
public class Diod {
    private Double Ry;
    private Double C;
    private Double Rr;
    private Double It;
    private Double mft;

    public Double getRy() { return Ry;}
    public Double getC() { return C;}
    public Double getRr() { return Rr;}
    public Double getIt() { return It;}
    public Double getMft() {return mft;}

    public void diod(Double dRy, Double dC, Double dRr, Double dIt, Double dmft){
        Ry = dRy;
        C = dC;
        Rr = dRr;
        It = dIt;
        mft = dmft;
    }


}
