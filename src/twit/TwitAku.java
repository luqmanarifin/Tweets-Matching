/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twit;

import twitter4j.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Luqman A. Siswanto
 */
public class TwitAku {
  
  private static String delimiter = "[,]+"; 
  
  private static void init(String keyword1, String keyword2, String keyword3) {
    /* Parsing */
    String[] key1 = keyword1.split(delimiter);
    String[] key2 = keyword2.split(delimiter);
    String[] key3 = keyword3.split(delimiter);
    
    /* TOPIK SPORT */
    ArrayList<Category> categories = new ArrayList<Category>();
    categories.add(new Category("bola"));
    categories.add(new Category("motogp"));
    categories.add(new Category("table tennis"));
    
    /* Menambah keyword untuk kategori 1 */
    for (int j = 0; j < key1.length; j++) {
      categories.get(0).addKey(key1[j]);
    }

    /* Menambah keyword untuk kategori 2 */
    for (int j = 0; j < key1.length; j++) {
      categories.get(1).addKey(key2[j]);
    }

    /* Menambah keyword untuk kategori 3 */
    for (int j = 0; j < key1.length; j++) {
      categories.get(2).addKey(key3[j]);
    }
     
    
    
  }
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    
    
    String keyword1 = "a ha,b,c";
    String keyword2 = "d,e,f";
    String keyword3 = "g,h,i";
    
    init(keyword1, keyword2, keyword3);
    
    
    String text = "abacaabaccabacabaa";
    String pattern = "abacab";
    Algorithm solver = new Algorithm();
    System.out.println("KMP Algo");
    int kmp = solver.matchKmp(pattern, text);
    System.out.println(kmp);
    
    System.out.println("\nBoyer Moore Algo");
    int x = solver.matchBoyerMoore(pattern, text);
    
    System.out.println(x);
    
    TwitterConnector twit = new TwitterConnector();
    List<Status> tweets = twit.searchKeyword(5, "Hello");
    for (Status tweet : tweets) {
      System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
      String url = "https://twitter.com/" + tweet.getUser().getScreenName() + "/status/" + tweet.getId();
      System.out.println(url);
    }
    
    /*for (Status tweet : tweets) {
      
    }*/
  }
  
}
