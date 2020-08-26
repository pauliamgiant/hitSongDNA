package datasetMetrics;

import classifier.DataSet;
import classifier.DataTuple;
import classifier.SongAttribute;

import java.util.ArrayList;
import java.util.List;

public class GetSongMetrics {

    public static List<String> listOfSongInfo(int indexOfSong, DataSet ds) {
        List<String> values = new ArrayList<>();
        DataTuple chosenSong = ds.getTuples().get(mapIndexToDataset(indexOfSong));
        List fromDS = chosenSong.getAllTupleAttributeValues();
        for (int i = 0; i < fromDS.size(); i++) {
            SongAttribute sa = (SongAttribute) fromDS.get(i);
            values.add(sa.getValue());
        }
        return values;
    }

    public static String mapIndexToArtist(int index){
        switch (index) {
            case 0:
                return "Billy Ray Cyrus";
            case 1:
                return "Davinyls";
            case 2:
                return "Sinead O'Connor";
            case 3:
                return "Eagle Eye Cherry";
            case 4:
                return "A Great Big World";
            case 5:
                return "Gotye";
            case 6:
                return "A ha";
            default:
                return "unknown";
        }

    }


    public static int mapIndexToDataset(int index) {
        switch (index) {
            case 0:
                return 12;
            case 1:
                return 28;
            case 2:
                return 102;
            case 3:
                return 42;
            case 4:
                return 0;
            case 5:
                return 52;
            case 6:
                return 2;
            default:
                return 0;
        }

    }
}
