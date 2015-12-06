import java.util.ArrayList;
import java.util.List;


public class XVector {
    private List <Double> vector;

    public XVector(){
        vector = new ArrayList<>();
        for (int i = 0; i < 8; ++i){
            vector.add(0.0);
        }
    }

    public XVector(List<Double> xvector){
        vector = new ArrayList<>(xvector);
    }

    public Double Fi1 () {return vector.get(0);}
    public Double Fi2 () {return vector.get(1);}
    public Double Fi3 () {return vector.get(2);}
    public Double Fi4 () {return vector.get(3);}
    public Double Fi5 () {return vector.get(4);}
    public Double Fi6 () {return vector.get(5);}
    public Double IE1 () {return vector.get(6);}
    public Double IE2 () {return vector.get(7);}

    public Double getDeltaU() {return Fi2() - Fi4();}
    public Double Ue() {return  Fi1();}

    public Double get(int i){
        return vector.get(i);
    }

    public List<Double> getVector() {
        return vector;
    }

    public XVector sum(XVector vector){
        List<Double> addList = vector.vector;
        List<Double> temp = new ArrayList<Double>();
        for (int i = 0; i < addList.size(); ++i) {
            temp.add(vector.get(i) + addList.get(i));
        }
        return new XVector(temp);
    }

    public void addXVector(List<Double> list) {
        for (int i = 0; i < list.size(); ++i) {
            vector.set(i, list.get(i) + vector.get(i));
        }
    }

    public void addXVector(XVector xVector) {
        addXVector(xVector.vector);
    }
}

