package ru.vladimir.start;
import ru.vladimir.models.*; 
import ru.vladimir.templates.*;

class EditItem extends BaseAction{//внешний класс
   public EditItem(String name) {
            super(name);
        }
  public int key(){
      return 2;
  }
 
  public void execute(Input input, Tracker tracker){
     String id = input.ask("Please, Enter id: ");
     String newName = input.ask("Please, Enter new name: ");
     String newDesc = input.ask("Please, Enter new description: ");
     String create = input.ask("Please, Enter new create: ");
     Long newCrea = Long.valueOf(create);
     Item fresh = new Item(newName, newDesc, newCrea);
     fresh.setId(id);
     tracker.edit(fresh);
  }


  
}

class DeleteItem extends BaseAction{//внешний класс
  public DeleteItem(String name) {
            super(name);
        }
  public int key(){
      return 3;
  }
 
  public void execute(Input input, Tracker tracker){
     String id = input.ask("Please, Enter id: ");
     tracker.delete(id);
  }

}

class FiltItem extends BaseAction{//внешний класс
 
  public FiltItem(String name) {
    super(name);
  }  
  public int key(){
      return 4;
  }
 
  public void execute(Input input, Tracker tracker){
     String ent = input.ask("Please, select the type of sorting: 1. Alphabetical 2. be The lowest date: ");
       if(ent.equals("1"))tracker.alfait();
       else tracker.crea();
       for (Item item : tracker.getAll()){
        System.out.println(String.format("id- %s, name- %s, desc- %s.", item.getId(), item.getName() , item.getDescription()));
      }    
  }

}

class DescIt extends BaseAction{//внешний класс
  public DescIt(String name) {
    super(name);
  }  
  public int key(){
      return 5;
  }
 
  public void execute(Input input, Tracker tracker){
    String id = input.ask("Please, Enter id: ");
    String comment = input.ask("Please, Enter the comment: ");
    tracker.addComment(id, comment);
  }

}
class Filter extends BaseAction{//внешний класс
  public Filter(String name) {
    super(name);
  }  
  public int key(){
      return 6;
  }
 
  public void execute(Input input, Tracker tracker){
    String word = input.ask("Please, Enter name: ");
    tracker.filterByName(word);
  }

}

public class MenuTracker{

  private Input input;//Объекты из вне, кторые используются
  private Tracker tracker;//в нашей программе - Ввод, выывод и Хранилище
  private UserAction[] actions = new UserAction[7];//действия которые описанны в системе
  private int position = 0;  
 
  public MenuTracker(Input input, Tracker tracker){
    this.input = input;
    this.tracker = tracker;
  }  
  public void fillActions(){
//вложенный не стат класс через объект класса
    this.actions[position++] = this.new AddItem("Add the new item. ");
//вложенный стат классу через класс  
    this.actions[position++] = new MenuTracker.ShowItem("Show all items. ");
//не вложенный обращение к внешний класс
    this.actions[position++] = new EditItem("Add the change items fields. ");
    this.actions[position++] = new DeleteItem("Delete item by id. ");
    this.actions[position++] = new FiltItem("Sorting for applications. ");
    this.actions[position++] = new DescIt("Add the comment for item. ");
    this.actions[position++] = new Filter("Filter for items. ");
  }  
  

  public void select(int key){
    this.actions[key].execute(this.input, this.tracker);
  }

  public void show(){
    for (UserAction action : this.actions){
      if(action != null){
        System.out.println(action.info());
      }    
    }
  }  

  private class AddItem extends BaseAction{// внутрений класс 
    public AddItem(String name) {
      super(name);
    }  
    public int key(){
      return 0;
    }
    
    public void execute(Input input, Tracker tracker){
      String name = input.ask("Please, enter the task's name: ");
      String desc = input.ask("Please, enter the task's desc: ");
      tracker.add(new Task(name, desc));
    }

  }

  private static class ShowItem extends BaseAction{// внутрений статический класс 
    public ShowItem(String name) {
      super(name);
    }   
    public int key(){
      return 1;
    }
    
    public void execute(Input input, Tracker tracker){
      for (Item item : tracker.getAll()){
        System.out.println(String.format("id- %s, name- %s, desc- %s.", item.getId(), item.getName() , item.getDescription()));
      }
    }

  }

}
