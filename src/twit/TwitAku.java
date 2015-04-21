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
  private static ArrayList<Category> categories = new ArrayList<Category>();
  private static final int tweetCount = 5;
  
  private static void init(String keyword1, String keyword2, String keyword3) {
    /* Parsing */
    String[] key1 = keyword1.split(delimiter);
    String[] key2 = keyword2.split(delimiter);
    String[] key3 = keyword3.split(delimiter);
    
    /* TOPIK SPORT */
    
    categories.add(new Category("bola"));
    categories.add(new Category("motogp"));
    categories.add(new Category("table tennis"));
    categories.add(new Category("unknown"));
    
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
    
    
    String keyword1 = "your";
    String keyword2 = "name";
    String keyword3 = "world";
    
    init(keyword1, keyword2, keyword3);
    
    
    /*String text = "abacaabaccabacabaa";
    String pattern = "abacab";
    Algorithm solver = new Algorithm();
    System.out.println("KMP Algo");
    int kmp = solver.matchKmp(pattern, text);
    System.out.println(kmp);
    
    System.out.println("\nBoyer Moore Algo");
    int x = solver.matchBoyerMoore(pattern, text);
    
    System.out.println(x);*/
    
    TwitterConnector twit = new TwitterConnector();
    List<Status> tweets = twit.searchKeyword(tweetCount, "Hello");
    for (int j = 0; j < tweetCount; j++) {
        System.out.println("@" + tweets.get(j).getUser().getScreenName() + " - " + tweets.get(j).getText());
        String url = "https://twitter.com/" + tweets.get(j).getUser().getScreenName() + "/status/" + tweets.get(j).getId();
        System.out.println(url);
    }
    System.out.println();
    Algorithm solver = new Algorithm();
    
    ArrayList<Integer> tweetCategory = new ArrayList<Integer>();
    ArrayList<Integer> index = new ArrayList<Integer>();
    for (int k = 0; k < tweetCount; k++) {
      boolean found = false;
      for (int i = 0; i < categories.size()-1; i++) {
        for (int j = 0; j < categories.get(i).getKeysSize(); j++) {
          int ind = solver.matchKmp(categories.get(i).getKey(j), tweets.get(k).getText());
          
          if (ind != -1) {
            if (tweetCategory.isEmpty()) {
              tweetCategory.add(i+1);
              index.add(ind);
            } else {
                if ((tweetCategory.size() - 1) < k) {
                  tweetCategory.add(i+1);
                  index.add(ind);
                }
                else {
                  if (ind < index.get(index.size()-1)) {
                    tweetCategory.remove(tweetCategory.size()-1);
                    index.remove(index.size()-1);
                    index.add(ind);
                    tweetCategory.add(i+1);
                  } 
                }
            }
            found = true;
            break;
          }
        }
      }
      if (!found) {
        tweetCategory.add(-1);
        index.add(-1);
      }
    }
    
    System.out.println(tweetCategory.toString());
    System.out.println(index.toString());
    
    for (int i = 0; i < tweetCount; i++) {
      switch (tweetCategory.get(i)) {
        case 1 : categories.get(0).addTweets(tweets.get(i));
                  break;
        case 2 : categories.get(1).addTweets(tweets.get(i));
                  break;
        case 3 : categories.get(2).addTweets(tweets.get(i));
                  break;
        case -1 : categories.get(3).addTweets(tweets.get(i));
                  break;
      }
    }
    
    for (int i = 0; i < categories.size(); i++) {
      System.out.println("***** " + categories.get(i).getCategory() + " *****");
      ArrayList<Status> l = categories.get(i).getTweets();
      for (int j = 0; j < l.size(); j++) {
        System.out.println("@" + l.get(j).getUser().getScreenName() + " - " + l.get(j).getText());
        String url = "https://twitter.com/" + l.get(j).getUser().getScreenName() + "/status/" + l.get(j).getId();
        System.out.println(url);
      }
    }
  }
  
}
