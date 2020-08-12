package classifier;

import java.util.List;

public class NaiveBayes implements Classifier {

    /**
     * @return A NaiveBayes classifier object
     */

    private DataSet dataSet;
    private double hitCount;
    private double missCount;
    private double percentOfHit;

    public NaiveBayes(DataSet trainingSet) {
        this.dataSet = trainingSet;

        for (DataTuple dt : dataSet.getTuples()
        ) {
            if (dt.getTargetClass().getValue().equals("HIT")) {
                hitCount++;
            } else {
                missCount++;
            }
        }
    }

    public String testing() {

        return "This class is integrating fine with UI";
    }

    /**
     * Calculate prior probability
     *
     * @return probability value for a hit
     */
    public double calculateProbabilityOfHit() {
        System.out.println("Prob of hit: " + hitCount / dataSet.dataSetSize());
        return hitCount / dataSet.dataSetSize();
    }

    public double calculateProbabilityOfMiss() {
        System.out.println("Prob of Miss: " + missCount / dataSet.dataSetSize());
        return missCount / dataSet.dataSetSize();
    }


    public double calculateConditionalProbOfAttribute(SongAttribute attribute, String hitValue) {
        System.out.println("Probability of "+ attribute.getName() + " on "+hitValue +" target attribute");
        int count = 0;
        double probability = 0;
        for (DataTuple dt : dataSet.getTuples()
        ) {
            if (dt.getAttribute(attribute.getName()).getValue().equals(attribute.getValue())
                    && dt.getTargetClass().getValue().equals(hitValue)) {
                count++;
            }
        }
        if (hitValue.equals("HIT")) {
            probability = count / hitCount;
        } else {
            probability = count / missCount;
        }
        System.out.println(probability);
        return probability;
    }

    public double calculatePosteriorProbability(double[] attrCondProbs) {
        double posteriorProb = 1;
        for (double d : attrCondProbs
        ) {
            posteriorProb *= d;
        }
        System.out.println("Posterior Prob: " + posteriorProb);
        return posteriorProb;
    }


    public double calculateLikelihood() {
        return 0;
    }

    public Integer percentage(){
        int convert = (int) percentOfHit;
        return convert;
    }


    public boolean songIsLikelyToBeAHit(DataTuple toClassify) {
        double probOfHit = calculateProbabilityOfHit();
        double probOfMiss = calculateProbabilityOfMiss();
        double[] condProbHit = new double[toClassify.numberOfAttributes()];
        double[] condProbMiss = new double[toClassify.numberOfAttributes()];

        List<SongAttribute> allAttributes = toClassify.getAllTupleAttributeValues();
        System.out.println("condProb_HIT");
        for (int i = 0; i < allAttributes.size(); i++) {
            condProbHit[i] = calculateConditionalProbOfAttribute(allAttributes.get(i), "HIT");
            // version of Laplacian correction
            // offsetting an attribute based on a 0 value which disrupts the conditional
            //probability algorithm
            if(condProbHit[i]==0){
                condProbHit[i] = 2;
                System.out.println("Zero value adjustment made on HIT target");
            }
        }
        System.out.println("condProb_MISS");
        for (int i = 0; i < allAttributes.size(); i++) {
            condProbMiss[i] = calculateConditionalProbOfAttribute(allAttributes.get(i), "miss");


            // Laplacian correction
            if(condProbHit[i]==2){
                condProbHit[i] = 1;
                condProbMiss[i] = 1;
                System.out.println("Zero value adjustment made for HIT target.");
            }

            if(condProbMiss[i]==0){
                condProbHit[i] = 1;
                condProbMiss[i] = 1;
                System.out.println("Zero value adjustment made for Miss target.");
            }

        }
        double postProbHit = calculatePosteriorProbability(condProbHit);
        double postProbMiss = calculatePosteriorProbability(condProbMiss);

        double hitResult = postProbHit * probOfHit;
        double missResult = postProbMiss * probOfMiss;
        System.out.println(hitResult);
        System.out.println(missResult);

        percentOfHit = (100/(hitResult+missResult))*hitResult;

        if (hitResult > missResult) {
            System.out.println("Hit Probability > Miss Probability");
            return true;
        } else {
            System.out.println("Miss Probability > Hit Probability");
            return false;
        }
    }
}
