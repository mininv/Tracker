package ru.vladimir.start;
import ru.vladimir.models.*;

public class StartUI{
  public static void main(String[] args){
    Tracker tracker = new Tracker();
    Item one = tracker.add(new Task("BFirst task", "First desc", 10112014));
    Item two = tracker.add(new Task("ASecond task", "Second desc", 20122014));
    Item thr = tracker.add(new Task("Cthree task", "three desc", 22122014));

    for (Item item : tracker.getAll()){
      System.out.print(item.getName()+ " ");
      System.out.println(item.getDescription());
      System.out.println(item.getId());
    }
    System.out.println();   
    tracker.redact(one);//редактируем первую заявку
    System.out.println("Список после редактирования первой заявки: ");
    tracker.listing();// выводим на экран все заявки
    System.out.println();
    System.out.println("Список после удаления второй заявки: ");
    tracker.delete(two);
 tracker.listing();
  /* System.out.println("Список в алфавитном порядке: ");
    tracker.alfavit(); // выводим в алфавитном порядке
    System.out.println();
    System.out.println("поиск заявки по имени: ");
    tracker.searchByName(one.getName());//ищем по имени
    System.out.println();
    System.out.println("Список c определенной даты: "); 
    tracker.searchBycreate(one.getCreate());//выводим с определенной даты*/
  }
}
