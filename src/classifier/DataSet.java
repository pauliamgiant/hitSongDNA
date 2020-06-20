package classifier;

import classifier.Attributes.*;

import java.util.ArrayList;

public class DataSet {

    private ArrayList<DataTuple> tuples;

    public DataSet(int numberOfAttributes) {
        addTuple(new DataTuple("Song1", Outlook.sunny, Temp.hot, Humidity.high, Windy.no, Play_targetClass.no));
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
