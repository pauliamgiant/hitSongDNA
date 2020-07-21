package classifier;

import classifier.Attributes.ColabWithStar;
import classifier.Attributes.HitSongwriter;
import classifier.Attributes.Intro;
import classifier.Attributes.No_Songwriters;

import java.io.FileNotFoundException;
import java.util.List;


public class DataSetTesting {



    public static void main(String[] args) throws FileNotFoundException {
        DataSet mySet = new DataSet();
        DataTuple newTuple = new DataTuple("New Song", Intro.Between10and21Secs, No_Songwriters.one, ColabWithStar.no, HitSongwriter.yes);
        //System.out.println(mySet.printOutDataSet());
        Classifier classifier = new NaiveBayes(mySet);
        System.out.println("Your song is a HIT: " + classifier.songIsLikelyToBeAHit(newTuple));

        ImportARFFDataset iad = new ImportARFFDataset();
        List<String> importedDataset = iad.getTuples();
        for (int i = 0; i < importedDataset.size(); i++) {
            System.out.println(importedDataset.get(i));
        }

    }
}
