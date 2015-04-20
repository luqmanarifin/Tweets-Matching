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
public class Topic {
  private ArrayList<Category> categories;
  private String topic;
  
  public Topic() {
    categories = new ArrayList<Category>();
    topic = "kya";
  }
  public Topic(String name) {
    categories = new ArrayList<Category>();
    topic = name;
  }
  public Topic(String name, ArrayList<Category> cats) {
    topic = name;
    categories = cats;
  }
  
  public String getTopic() {
    return topic;
  }
  
  public void addCategory(Category cat) {
    categories.add(cat);
  }
  public Category getCategory(int index) {
    return categories.get(index);
  }
  public void removeCategory(int index) {
    categories.remove(index);
  }
  public int getCategoriesSize() {
    return categories.size();
  }
}
