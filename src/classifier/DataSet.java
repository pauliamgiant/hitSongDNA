package classifier;

import classifier.Attributes.*;

import java.util.ArrayList;
import java.util.List;

public class DataSet {

    /**
     *  Tuples stored in List - index can serve as ID. DataTuple object consists of a 'name' String value and a Map of Enum values.
     */

    private List<DataTuple> tuples;

    public DataSet() {
        tuples = new ArrayList<DataTuple>();
        createDummyDataSet();
    }

    public List<DataTuple> getTuples() {
        return tuples;
    }

    public void addTuple(DataTuple tuple) {
        tuples.add(tuple);
    }

    public double dataSetSize(){
        return tuples.size();
    }

    public String printOutDataSet(){
        String dataSet = "DATASET:\n";
        for (int i = 0; i <tuples.size() ; i++) {
            DataTuple dt = tuples.get(i);
            dataSet += dt.getName() + ": " + dt.printTuple() + " \n";
        }
        return dataSet;
    }

    /**
     * YES 9
     * NO 5
     */
    public void createDummyDataSet(){
        addTuple(new DataTuple("Song1", Outlook.sunny, Temp.hot, Humidity.high, Windy.no, Hit_targetClass.no));
        addTuple(new DataTuple("Song2", Outlook.sunny, Temp.hot, Humidity.high, Windy.yes, Hit_targetClass.no));
        addTuple(new DataTuple("Song3", Outlook.overcast, Temp.hot, Humidity.high, Windy.no, Hit_targetClass.yes));
        addTuple(new DataTuple("Song4", Outlook.rainy, Temp.mild, Humidity.high, Windy.no, Hit_targetClass.yes));
        addTuple(new DataTuple("Song5", Outlook.rainy, Temp.cool, Humidity.normal, Windy.no, Hit_targetClass.yes));
        addTuple(new DataTuple("Song6", Outlook.rainy, Temp.cool, Humidity.normal, Windy.yes, Hit_targetClass.no));
        addTuple(new DataTuple("Song7", Outlook.overcast, Temp.cool, Humidity.normal, Windy.yes, Hit_targetClass.yes));
        addTuple(new DataTuple("Song8", Outlook.sunny, Temp.mild, Humidity.high, Windy.no, Hit_targetClass.no));
        addTuple(new DataTuple("Song9", Outlook.sunny, Temp.cool, Humidity.normal, Windy.no, Hit_targetClass.yes));
        addTuple(new DataTuple("Song10", Outlook.rainy, Temp.mild, Humidity.normal, Windy.no, Hit_targetClass.yes));
        addTuple(new DataTuple("Song11", Outlook.sunny, Temp.mild, Humidity.normal, Windy.yes, Hit_targetClass.yes));
        addTuple(new DataTuple("Song12", Outlook.overcast, Temp.mild, Humidity.high, Windy.yes, Hit_targetClass.yes));
        addTuple(new DataTuple("Song13", Outlook.overcast, Temp.hot, Humidity.normal, Windy.no, Hit_targetClass.yes));
        addTuple(new DataTuple("Song14", Outlook.rainy, Temp.mild, Humidity.high, Windy.yes, Hit_targetClass.no));
    }


}
