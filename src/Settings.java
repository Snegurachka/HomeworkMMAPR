
/**
 * Created by elena on 28.11.15.
 */
public class Settings {
    private Double E9;
    private Double R10;
    private Double C6;
    private Double R12;
    private Double L6;
    private Double C7;
    private Double R9;
    private Diod diod;
    private Eds eds;

    public void settings(){
        E9 = 5.0;
        R10 = 1000.0;
        C6 = 1.0;
        R12 = 1000.0;
        L6 = 0.00001;
        C7 = 1.0;
        R9 = 1000.0;
        diod.diod(Math.pow(10 ,6), 2 * Math.pow(10, -12), 20.0, Math.pow(10, -12), 0.026);

        eds.eds();

    }

}
