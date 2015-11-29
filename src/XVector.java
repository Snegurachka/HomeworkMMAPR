import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class XVector {
    private List <Double> vector;

    public XVector(){
        vector = new ArrayList<>();
        for ( int i = 0; i < 19; ++i){
        vector.add(0.0);
        }
    }

    public XVector(Vector<Double> xvector){
        vector = new ArrayList<>();
        for ( int i = 0; i < xvector.size(); ++i){
            vector.add(xvector.get(i));
        }
    }

    public Double dUc4dt() {return vector.get(0);}
    public Double dIl3dt() {return vector.get(1);}
    public Double dUcddt() {return vector.get(2);}
    public Double Ul3() {return vector.get(3);}
    public Double Ury() {return vector.get(4);}
    public Double Uid() {return vector.get(5);}
    public Double Urd() {return vector.get(6);}
    public Double Ie() {return vector.get(7);}
    public Double Ic4() {return vector.get(8);}
    public Double Icd() {return vector.get(9);}
    public Double Ir4() {return vector.get(10);}
    public Double Il3() {return vector.get(11);}
    public Double Iry() {return vector.get(12);}
    public Double Iid() {return vector.get(13);}
    public Double Ird() {return vector.get(14);}
    public Double Ue() {return vector.get(15);}
    public Double Uc4() {return vector.get(16);}
    public Double Ucd() {return vector.get(17);}
    public Double Ur4() {return vector.get(18);}

    public Double getDeltaU() {return Ury();}

    public get(int i){ return
    }

    public XVector AddXVector(XVector vector){
        Double addList = vector.

    }


}


//public class XVector {
//    private List <Double> vector;
//
//    public XVector(){
//        vector = new ArrayList<>();
//        for ( int i = 0; i < 19; ++i){
//            vector.add(0.0);
//        }
//    }
//
//    public XVector(Vector<Double> xvector){
//        vector = new ArrayList<>();
//        for ( int i = 0; i < xvector.size(); ++i){
//            vector.add(xvector.get(i));
//        }
//    }
//
//    public Double Fi1 () {return vector.get(0);}
//    public Double Fi2 () {return vector.get(1);}
//    public Double Fi3 () {return vector.get(2);}
//    public Double Fi4 () {return vector.get(3);}
//    public Double Fi5 () {return vector.get(4);}
//    public Double Fi6 () {return vector.get(5);}
//    public Double IE1 () {return vector.get(6);}
//    public Double IE2 () {return vector.get(7);}
//
//    public Double getDeltaU() {return Fi2() - Fi4();}
//
//}


/**
 * Created by neikila on 02.11.15.
 */
//class XVector (var list: java.util.List[java.lang.Double]){
//
//        def this() = {
//        this({
//        var temp1 = new util.ArrayList[java.lang.Double]()
//        for (i <- 0 until 19) temp1.add(0.0)
//        temp1
//        })
//        }
//
//        def dUc4dt()  =  list.get(0)
//        def dIl3dt()  =  list.get(1)
//        def dUcddt()  =  list.get(2)
//        def Ul3()     =  list.get(3)
//        def Ury()     =  list.get(4)
//        def Uid()     =  list.get(5)
//        def Urd()     =  list.get(6)
//        def Ie()      =  list.get(7)
//        def Ic4()     =  list.get(8)
//        def Icd()     =  list.get(9)
//        def Ir4()     =  list.get(10)
//        def Il3()     =  list.get(11)
//        def Iry()     =  list.get(12)
//        def Iid()     =  list.get(13)
//        def Ird()     =  list.get(14)
//        def Ue()      =  list.get(15)
//        def Uc4()     =  list.get(16)
//        def Ucd()     =  list.get(17)
//        def Ur4()     =  list.get(18)
//
//        def getDeltaU = Ury
//
//        def get(i: Int) = {
//        list.get(i)
//        }
//
//        def + (vector: XVector) = {
//        val addList = vector.list
//        new XVector({
//        var temp = new util.ArrayList[java.lang.Double]()
//        for (i <- 0 until list.size())
//        temp.add(list.get(i) + addList.get(i))
//        temp
//        })
//        }
//
//        def += (vector: java.util.List[java.lang.Double]) {
//        for (i <- 0 until list.size())
//        list.set(i ,list.get(i) + vector.get(i))
//        }
//
//        def += (vector: XVector) {
//        this += vector.list
//        }
//        }