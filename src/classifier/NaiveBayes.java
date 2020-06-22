package classifier;

import classifier.Attributes.Hit_targetClass;

import java.util.List;

public class NaiveBayes implements Classifier {

    /**
     * @return A NaiveBayes classifier object
     */

    private DataSet dataSet;
    private double hitCount;
    private double missCount;

    public NaiveBayes(DataSet trainingSet) {
        this.dataSet = trainingSet;

        for (DataTuple dt : dataSet.getTuples()
        ) {
            if (dt.getTargetClass().getValue().equals(Hit_targetClass.yes)) {
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


    public double calculateConditionalProbOfAttribute(SongAttribute attribute, Hit_targetClass hitValue) {
        int count = 0;
        double probability = 0;
        for (DataTuple dt : dataSet.getTuples()
        ) {
            if (dt.getAttribute(attribute.getName()).getValue().equals(attribute.getValue())
                    && dt.getTargetClass().getValue().equals(hitValue)) {
                count++;
            }
        }
        if (hitValue.equals(Hit_targetClass.yes)) {
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


    public boolean songIsLikelyToBeAHit(DataTuple toClassify) {
        double probOfHit = calculateProbabilityOfHit();
        double probOfMiss = calculateProbabilityOfMiss();
        double[] condProbHit = new double[toClassify.numberOfAttributes()];
        double[] condProbMiss = new double[toClassify.numberOfAttributes()];

        List<SongAttribute> allAttributes = toClassify.getAllAttributes();
        System.out.println("condProb_HIT");
        for (int i = 0; i < allAttributes.size(); i++) {
            condProbHit[i] = calculateConditionalProbOfAttribute(allAttributes.get(i), Hit_targetClass.yes);
        }
        System.out.println("condProb_MISS");
        for (int i = 0; i < allAttributes.size(); i++) {
            condProbMiss[i] = calculateConditionalProbOfAttribute(allAttributes.get(i), Hit_targetClass.no);
        }
        double postProbHit = calculatePosteriorProbability(condProbHit);
        double postProbMiss = calculatePosteriorProbability(condProbMiss);

        double hitResult = postProbHit * probOfHit;
        double missResult = postProbMiss * probOfMiss;
        System.out.println(hitResult);
        System.out.println(missResult);

        if (hitResult > missResult) {
            return true;
        } else {
            return false;

        }
    }
}
