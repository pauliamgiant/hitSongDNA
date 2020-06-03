package classifier;

import java.util.ArrayList;

public class DataSet {

    private ArrayList<DataTuple> tuples;

    public DataSet(ArrayList<DataTuple> tuples) {
        this.tuples = tuples;
    }

    public ArrayList<DataTuple> getTuples() {
        return tuples;
    }

    public void addTuple(DataTuple tuple) {
        tuples.add(tuple);
    }

    public void createDummyDataSet(){



    }


}
