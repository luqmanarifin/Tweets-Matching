/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twit.aku;
import java.util.Arrays;

/**
 *
 * @author Luqman A. Siswanto
 */
public class Algorithm {
  /**
   * Menghitung fungsi border dari sebuah string
   * @param s string yang akan di-compute fungsi bordernya
   */
  public int[] computeKMP(String s) {
    int n = s.length();
    int[] a = new int[n];
    Arrays.fill(a, 0);
    for(int i = 1; i < n; i++) {
      int j = a[i - 1];
      while(j > 0 && s.charAt(i) != s.charAt(j)) j = a[j - 1];
      if(s.charAt(i) == s.charAt(j)) a[i] = j + 1;
    }
    System.out.print("Func : ");
    for(int i = 0; i < n; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
    return a;
  }
  /**
   * Mencocokkan sebuah pattern terhadap text
   * @param pattern Pattern yang akan dicocokkan
   * @param text Teks mentah tempat pattern akan dicocokkan
   */
  public void matchKMP(String pattern, String text) {
    pattern = pattern.toLowerCase();
    text = text.toLowerCase();
    int[] b = computeKMP(pattern);
    int j = 0;
    for(int i = 0; i < text.length();) {
      if(pattern.charAt(j) == text.charAt(i)) {
        i++; j++;
      } else if(j > 0) {
        j = b[j - 1];
      } else {
        i++;
      }
      if(j == pattern.length()) {
        System.out.println("Found at index " + (i - pattern.length()));
        return;
      }
    }
    System.out.println("Not found");
  }
}
