package ru.vladimir.templates;
import ru.vladimir.start.*;

public abstract class BaseAction implements UserAction{
  private String name;
  public BaseAction(String name){
    this.name = name;
  }
  public String info(){
    return String.format("%s. %s", this.key(),
    this.name );
  }
  
  // запрашиваем действие ключ действия пользователя   
  public abstract int key();
//запрашивать действие  
  public abstract void execute(Input input, Tracker tracker);

}
