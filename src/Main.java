/**
 * Created by elena on 28.11.15.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Solver solver = new Solver();
        solver.solve();

        new GnuPlot(solver).printAll();
    }
}