package classifier;

import classifier.Attributes.*;

public class DataSetTesting {

    public static void main(String[] args) {
        DataSet mySet = new DataSet();
        DataTuple newTuple = new DataTuple("New Song", Intro.Between10and21Secs, No_Songwriters.one, ColabWithStar.no, HitSongwriter.yes);
        System.out.println(mySet.printOutDataSet());
        Classifier classifier = new NaiveBayes(mySet);
        System.out.println("Your song is a HIT: " + classifier.songIsLikelyToBeAHit(newTuple));
    }
}
