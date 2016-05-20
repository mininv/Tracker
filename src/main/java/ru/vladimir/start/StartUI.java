package ru.vladimir.start;
import ru.vladimir.models.*;

public class StartUI{
  public static void main(String[] args){
    Tracker tracker = new Tracker();
    Item one = tracker.add(new Task("BFirst task", "First desc", 10));
    Item two = tracker.add(new Task("ASecond task", "Second desc", 20));
    for (Item item : tracker.getAll()){//10
      System.out.print(item.getName()+ " ");
      System.out.println(item.getDescription());
      System.out.println(item.getId());
    }
    System.out.println();   
    tracker.redact(one);
    System.out.println("Список после редактирования первой заявки:");
    for (Item item : tracker.getAll()){
      System.out.print(item.getName()+ " ");
      System.out.println(item.getDescription());//20
      System.out.println(item.getId());
    }
    System.out.println();
    System.out.println("Список после удаления второй заявки:");
    //tracker.delete(two);
    System.out.println(two.getName()+ " ");
    tracker.listing();
    tracker.filter();
  }
}
