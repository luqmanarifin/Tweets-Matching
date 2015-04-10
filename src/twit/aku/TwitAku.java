/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twit.aku;

/**
 *
 * @author Luqman A. Siswanto
 */
public class TwitAku {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    String text = "abacaabaccabacabaa";
    String pattern = "abacab";
    Algorithm solver = new Algorithm();
    System.out.println("KMP Algo");
    solver.matchKmp(pattern, text);
    System.out.println("\nBoyer Moore Algo");
    solver.matchBoyerMoore(pattern, text);
  }
  
}
