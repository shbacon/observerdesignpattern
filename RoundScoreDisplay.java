package observerdesignpattern;
/**
 * RoundScoreDisplay implements Observer
 */
public class RoundScoreDisplay implements Observer{
    private Subject golfer;
    private int strokesTotal;
    private int parTotal;

    @Override
    /**
     * update takes strokes and par and adds it to the total
     * @param strokes
     * @param par
     */
    public void update(int strokes, int par) {
        this.strokesTotal += strokes;
        this.parTotal += par;
        displayRoundScore();
    }
    /**
     * RoundScore display takes in golfer and sets it
     * @param golfer
     */
    public RoundScoreDisplay(Subject golfer){
        this.golfer = golfer;
        golfer.registerObserver(this);
    }
    /**
     * This displays the updated scores for the round
     */
    private void displayRoundScore(){
        System.out.println("Current round stats");
        System.out.println("par: " +parTotal);
        System.out.println("strokes: " +strokesTotal);
        if(parTotal==strokesTotal){
            System.out.println("Made par");
        }
        else if(strokesTotal < parTotal){
            System.out.println(parTotal-strokesTotal+ " under par");
        }
        else {
            System.out.println(strokesTotal-parTotal+ " over par");
        }
    }
}
