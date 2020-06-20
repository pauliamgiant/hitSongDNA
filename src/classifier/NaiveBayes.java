package classifier;

public class NaiveBayes implements Classifier {

    /**
     * @return A NaiveBayes classifier object
     */

    DataSet dataSet;

    public NaiveBayes(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    public String testing() {

        return "This class is integrating fine with UI";
    }

    public double calculateProbabilityOfHit() {
        return 0;
    }

    public double calculateProbabilityOfNot() {
        return 0;

    }

    public double calculateLikelihood() {
        return 0;
    }



    public boolean songIsLikelyToBeAHit() {
        return true;
    }
}
