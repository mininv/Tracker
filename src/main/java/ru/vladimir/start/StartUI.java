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
    one = tracker.redact(one);//редактируем первую заявку
    System.out.println("Ch one -" + one.name+ " ");
    System.out.println("Список после редактирования первой заявки: ");
    tracker.findBy(null, null, 0);// выводим на экран все заявки
    System.out.println();
    System.out.println("Список после удаления второй заявки: ");
    tracker.delete(two);
    tracker.findBy(null, null, 0);// выводим на экран все заявки
    tracker.findBy("Cthree task", null, 0);//ищем по имени
    //tracker.findBy(null, "aaa", 0);
    tracker.findBy(null, null, 10112014);//выводим с определенной даты
  }
}
