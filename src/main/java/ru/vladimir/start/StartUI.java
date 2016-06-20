package ru.vladimir.start;
import ru.vladimir.models.*;

public class StartUI{
  private Input input;
// range для бесперебойной работы приложения через ValidateInput
  private int[] range = {0,1,2,3,4,5,6};
 
  public StartUI(Input input){
    this.input = input;
  }
  
  public void init() {
    Tracker tracker =new Tracker();
    MenuTracker menu = new MenuTracker(this.input, tracker);
    menu.fillActions();
//анонимный класс, далее создан объкт анонимного класса
 
    do{
      menu.show();
//ask переопределен с добавлением аргумента range
      int key = input.ask("Select: ",range);
      menu.select(key);
    } while(!"y".equals(this.input.ask("Exit?(y): ")));
  }
  
  public static void main(String[] args){
    Input input = new ValidateInput();
    new StartUI(input).init();
  }
}
