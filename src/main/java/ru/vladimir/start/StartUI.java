package ru.vladimir.start;
import ru.vladimir.models.*;

public class StartUI{
  private Input input;
  private Menu menu = new Menu();
  private Tracker tracker = new Tracker();
  public StartUI(Input input){
    this.input = input;
  }
  
  public void init() {
    boolean bo = true;    
    do{
      String answer = input.ask("Please, Enter the number of the selected category: ");
      if (answer.equals("1")){
        String name = input.ask("Please, Enter the name: ");
        Item one = tracker.add(new Task(name));
        for (Item item : tracker.getAll()){
          System.out.println(item.getName()+ " ");
        }
      }
      else if (answer.equals("2")){
        tracker.findBy(null, null, 0);// выводим на экран все заявки
        String id = input.ask("Please, Enter id: ");
        String newName = input.ask("Please, Enter new name: ");
        tracker.redact(id, newName);
      }
      else if (answer.equals("3")){
        tracker.findBy(null, null, 0);// выводим на экран все заявки
        String id = input.ask("Please, Enter id: ");
        tracker.delete(id);
      }
      else if (answer.equals("4"))tracker.findBy(null, null, 0);
      else if (answer.equals("5")){
        tracker.findBy(null, null, 0);
        String name = input.ask("Please, Enter the name: ");
        tracker.findBy(name, null, 0);
      }
      else if (answer.equals("6")){
        tracker.findBy(null, null, 0);// выводим на экран все заявки
        String id = input.ask("Please, Enter id: ");
        String newDesc = input.ask("Please, Enter new desc: ");
        tracker.addDesc(id, newDesc);
    }
      else if (answer.equals("7")) bo=false;
      else System.out.println("Введите пжлста только цифры 1-7 без знаков.");
    }while(bo==true);
  }  

  public static void main(String[] args){
    Input input = new ConsoleInput();
    new StartUI(input).init();
//new StartUI(new StubInput(new String[] {"create input stub"}) ).init();
    /*Item two = tracker.add(new Task("ASecond task", "Second desc", 20122014));
    Item thr = tracker.add(new Task("Cthree task", "three desc", 22122014));

Tracker tracker = new Tracker();
    Item one = tracker.add(new Task(name));
    for (Item item : tracker.getAll()){
      System.out.print(item.getName()+ " ");
    }

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
    tracker.findBy(null, null, 10112014);//выводим с определенной даты*/
  }
}
