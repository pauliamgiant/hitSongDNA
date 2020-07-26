package classifier;

public interface Classifier {

    public boolean songIsLikelyToBeAHit(DataTuple toClassify);

    public Integer percentage();
}
