package CardGame;

public class Card {
    
public String cardName;
public int wins;
public int kos;
public int submissions;
public int reach;

/**
    * Constructor for card class
     * @param n
     * @param w
     * @param k
     * @param s
     * @param r  comment test
 */

public Card(String n, int w, int k, int s, int r) {
    cardName = n;
    wins = w;
    kos = k;
    submissions = s;
    reach = r;
}
public String getDetails() {
    return cardName+" "+wins+" "+kos+" "+submissions+" "+reach;
}

}
