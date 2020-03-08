package portfolio;

import portfolio.investments.Investment;
import java.util.ArrayList;

public class Portfolio<T extends Investment> {
    ArrayList<T> investments = new ArrayList<>();

    // contains
    public boolean contains(T content) {
        return investments.contains(content);
    //    return investments.containsKey(content);
    }

    // buy
    public void buy(T content) {
        for (T i : investments) { // go through ArrayList
            if (i.equals(content)) { // compare titles
                i.setCount(i.getCount() + content.getCount()); // if an equal title is found, count should go up
                return;
            }
        }
        investments.add(content);
    }

    // sell
    public void sell(String titel, int amount) {
        T temp = null;
        for (T i : investments) { // go through ArrayList

            if (i.getTitel() == titel) { // compare titles
                i.setCount(i.getCount() - amount); // if an equal title is found, count should go down

                if (i.getCount() == 0) {
                    temp = i;
                }
            }
        }
        investments.remove(temp);
    }

    // getShare
    public T getShare(String titel){
        for (T i : investments) { // go through ArrayList
            if (i.getTitel() == titel) { // compare titles
                return i;
            }
        }
        return null;
    }

}
