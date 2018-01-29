package CardGame;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class createCards {
//Card[] deck = new Card[20];
ArrayList<Card> deck = new ArrayList<>(20);
    public static void main(String args[]) {
        createCards cc = new createCards();
        cc.createCards();
        
    }
    
    public void createCards() {
        deck.add(new Card("Jon Jones", 21, 9, 6, 215));
        deck.add(new Card("Frank Mir", 18, 5, 9, 200));
         deck.add(new Card("Georges St. Pierre", 26,  8, 6 , 180));
         deck.add(new Card("Anderson da Silva", 34, 22 , 4 , 197));
         deck.add(new Card("Demetrious Johnson",  27, 5, 11 , 168));
         deck.add(new Card("José Aldo", 26, 14 , 2 , 178));
         deck.add(new Card("Chuck Liddell", 21, 13 , 1 , 200));
         deck.add(new Card("Dan Henderson", 32, 16 , 2 , 188));
        deck.add(new Card("BJ Penn", 16, 7 , 6 , 178));
        deck.add(new Card("Randy Couture", 19, 7 , 4 , 191));
        deck.add(new Card("Conor McGregor", 21, 18, 1, 188));
        deck.add(new Card("Cain Velasquez", 14, 12, 0, 196));
       deck.add(new Card("Daniel Cormier", 20, 9, 4, 184));
        deck.add(new Card("Vitor Belfort", 26, 18, 3, 188));
        deck.add(new Card("Lyoto Machida", 22, 9, 2, 188));
        deck.add(new Card("Quinton Jackson", 37, 19, 5, 185));
       deck.add(new Card("Robbie Lawler", 28, 20 , 1, 188));
       deck.add(new Card("Nick Diaz", 26, 13 , 8 , 193));
       deck.add(new Card("T.J. Dillashaw", 15, 7, 3, 173));
       deck.add(new Card("Junior dos Santos", 18, 12 , 2 , 196));
       Collections.shuffle(deck);      
   
        
      //  Print();
        drawcardP1();
         drawcardP2();
    }

    public void Print() {
        
         for(Card card:deck){
                    System.out.println(card.getDetails());
                    
         }
    }
    public void drawcardP1(){
       
         for(Card card:deck){
                    System.out.println(card.getDetails());
                    
         }
        deck.get(0);
        deck.get(1);
        deck.get(2);       
        
        System.out.println("\n"+deck.get(0).getDetails());
        System.out.println("\n"+deck.get(1).getDetails());
        System.out.println("\n"+deck.get(2).getDetails());
        
        deck.remove(0);
        deck.remove(1);
        deck.remove(2);
        Collections.shuffle(deck);      
        
    }     
    
        public void drawcardP2(){
        
        deck.get(0);
        deck.get(1);
        deck.get(2);       
        System.out.println("**********************");
        
        
         for(Card card:deck){
                    System.out.println(card.getDetails());
                    
         }
        System.out.println("\n"+deck.get(0).getDetails());
        System.out.println("\n"+deck.get(1).getDetails());
        System.out.println("\n"+deck.get(2).getDetails());
        
        Collections.shuffle(deck);      
    
    }            
                    
//        for (int i = (int) random(); i < deck.length; i++) {
//        String name = deck[i].cardName;
//        int kos = deck[i].kos;
//        int reach = deck[i].reach;
//        int subs = deck[i].submissions;
//        int wins = deck[i].reach;
//        String newLine = System.getProperty("line.separator");
//        System.out.println(name + newLine + kos + newLine + reach + newLine + subs+ newLine + wins + newLine + "************" );
      
        
        }
        
        
    
    


    


