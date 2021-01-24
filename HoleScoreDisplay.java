package observerdesignpattern;
/**
 *  implements Observer
 */
public class HoleScoreDisplay implements Observer {

    private Subject golfer;
    private int strokes;
    private int par;

    @Override
    /**
     * update takes strokes and par and adds it to the total
     * @param strokes
     * @param par
     */
    public void update(int strokes, int par) {
    
        this.strokes = strokes;
        this.par = par;
        displayCurrentScore();
    }
    /**
     * sets the golfer
     * @param golfer
     */
    public HoleScoreDisplay(Subject golfer){
        this.golfer = golfer;
        golfer.registerObserver(this);
    }
    /**
     * displays the current score 
     */
    private void displayCurrentScore(){
        System.out.println("Current hole stats");
        System.out.println("par: " +par);
        System.out.println("strokes: " +strokes);
        if(par==strokes){
            System.out.println("Made par");
        }
        else if(strokes < par){
            System.out.println(par-strokes+ " under par");
        }
        else {
            System.out.println(strokes-par+ " over par");
        }
    }
    
}
