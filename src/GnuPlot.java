import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

/**
 * Created by elena on 28.11.15.
 */
public class GnuPlot {
    private String directory = "out/";
    private HashMap<String, Double> maxValues = new HashMap<String, Double>();
    private HashMap<String, Double> minValues = new HashMap<String, Double>();
    private String Il3 = "Il3";
    private String Ie = "Ie";
    private String Ue = "Ue";
    private String Ur4 = "Ur4";
    private String Uc4 = "Uc4";

    private List<XVector> resultsXVector;
    private List<Double> resultsTime;
    private Settings settings;

    public void printTiFile(String fileName, Function<XVector, Double> f) throws Exception {
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
        val (a, b) = maxMinValues.filterKeys((a: String) => graph.contains(a)).values.unzip
        val max = a.max
        val min = b.min;

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