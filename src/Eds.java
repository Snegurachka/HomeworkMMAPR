/**
 * Created by elena on 28.11.15.
 */
public class Eds {
    private double omega;
    private double Emax;


    public Eds(Double domega, Double dEmax){
        omega = domega;
        Emax = dEmax;

    }

    public Double E(Double t) {return Emax * Math.sin(omega * t);}
}

