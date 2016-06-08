package ru.vladimir.start;
import ru.vladimir.models.*; 

class EditItem implements UserAction{//внешний класс
  public int key(){
      return 2;
  }
 
  public void execute(Input input, Tracker tracker){
     String id = input.ask("Please, Enter id: ");
     String newName = input.ask("Please, Enter new name: ");
     String newDesc = input.ask("Please, Enter new description: ");
     String create = input.ask("Please, Enter new create: ");
     Long newCrea = Long.valueOf(create);
     tracker.redact(id, newName, newDesc, newCrea);
  }

  public String info(){
    return String.format("%s. %s", this.key(), "Add the change items fields. ");
  }
}

class DeleteItem implements UserAction{//внешний класс
  public int key(){
      return 3;
  }
 
  public void execute(Input input, Tracker tracker){
     String id = input.ask("Please, Enter id: ");
        tracker.delete(id);
  }

  public String info(){
    return String.format("%s. %s", this.key(), "Delete item by id. ");
  }
}

class FiltItem implements UserAction{//внешний класс
  public int key(){
      return 4;
  }
 
  public void execute(Input input, Tracker tracker){
     String ent = input.ask("Please, select the type of filter list: 1. Alphabetical 2. The lowest date: ");
       if(ent.equals("1"))tracker.alfait();
       else tracker.crea();     
  }

  public String info(){
    return String.format("%s. %s", this.key(), "Filters for applications. ");
  }
}

class DescIt implements UserAction{//внешний класс
  public int key(){
      return 5;
  }
 
  public void execute(Input input, Tracker tracker){
    String id = input.ask("Please, Enter id: ");
    String newDesc = input.ask("Please, Enter new desc: ");
    tracker.addDesc(id, newDesc);
  }

  public String info(){
    return String.format("%s. %s", this.key(), "Add the new decription for item. ");
  }
}

public class MenuTracker{

  private Input input;//Объекты из вне, кторые используются
  private Tracker tracker;//в нашей программе - Ввод, выывод и Хранилище
  private UserAction[] actions = new UserAction[6];//действия которые описанны в системе

  public MenuTracker(Input input, Tracker tracker){
    this.input = input;
    this.tracker = tracker;
  }  
  public void fillActions(){
    this.actions[0] = this.new AddItem();//вложенный не стат класс через объект класса
    this.actions[1] = new MenuTracker.ShowItem();//вложенный стат классу через класс 
    this.actions[2] = new EditItem();//не вложенный обращение к внешний класс
    this.actions[3] = new DeleteItem();
    this.actions[4] = new FiltItem();
    this.actions[5] = new DescIt();
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

  private class AddItem implements UserAction{// внутрений класс 
    public int key(){
      return 0;
    }
    
    public void execute(Input input, Tracker tracker){
      String name = input.ask("Please, enter the task's name: ");
      String desc = input.ask("Please, enter the task's desc: ");
      tracker.add(new Task(name, desc));
    }

    public String info(){
      return String.format("%s. %s", this.key(), "Add the new item. ");
    }
  }

  private static class ShowItem implements UserAction{// внутрений статический класс 
    public int key(){
      return 1;
    }
    
    public void execute(Input input, Tracker tracker){
      for (Item item : tracker.getAll()){
        System.out.println(String.format("id- %s, name- %s, desc- %s.", item.getId(), item.getName() , item.getDescription()));
      }
    }

    public String info(){
      return String.format("%s. %s ", this.key(), "Show all items. ");
    }
  }

}
