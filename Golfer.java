package observerdesignpattern;
import java.util.ArrayList;

public class Golfer implements Subject{
    String name = "";
    ArrayList<Observer> observers;
    /**
     * sets up observer
     */
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    /**
     * calls updates 
     */
    public void notifyObservers(int strokes, int par){
        for(Observer observer : observers){
            observer.update(strokes, par);
        }  
    }
    @Override
    /**
     * gets rid of observs
     */
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    /**
     * takes in the name and sets up the golfer
     * @param name
     */
    public Golfer(String name) {
        this.name = name;
        this.observers = new ArrayList<Observer>();
    }
    /**
     * takes in the score and sends it to the observes
     * @param strokes
     * @param par
     */
    public void enterScore(int strokes, int par){
        notifyObservers(strokes, par);
    }
    /**
     * returns the name
     * @return
     */
	public String getName() {
		return name;
	}
   
  
}
