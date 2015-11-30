/**
 * Created by elena on 28.11.15.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Solver solver = new Solver();
        solver.solve();
    }
}
//package main
//
//        import java.{lang, util}
//
//        import model._
//        import collection.JavaConversions._
//        import scala.collection.mutable.ArrayBuffer
//
///**
// * Created by neikila on 02.11.15.
// */
//        object Main {
//        def main(args: Array[String]): Unit = {
//        scalaStyle
//        }
//
//        def scalaStyle: Unit = {
//        println("Scala style")
//        val solver = new Solver
//        solver.solve()
//        val gnuplot = new GnuplotScala(solver.result.toArray, solver.settings)
//        gnuplot.printAll()
//        }
//        }