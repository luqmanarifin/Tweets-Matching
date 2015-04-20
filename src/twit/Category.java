/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twit;
import java.util.ArrayList;

/**
 *
 * @author Luqman A. Siswanto
 */
public class Category {
  private ArrayList<String> keys;
  private String category;
  
  public Category() {
    keys = new ArrayList<String>();
    category = "lala";
  }
  public Category(String cat) {
    keys = new ArrayList<String>();
    category = cat;
  }
  public Category(String cat, ArrayList<String> keywords) {
    category = cat;
    keys = keywords;
  }
  
  public String getCategory() {
    return category;
  }
  
  public void addKey(String key) {
    keys.add(key);
  }
  public String getKey(int index) {
    return keys.get(index);
  }
  public void removeKey(int index) {
    keys.remove(index);
  }
  public int getKeysSize() {
    return keys.size();
  }
}
