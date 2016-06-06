package ru.vladimir.start;

public class StartUITest{

  public static void main(String[] args){
    Input input = new StubInput(new String[]{"1", "Bbbbb",  "1" , "AAaaa","4", "5", "1", "4","7"});
    new StartUI(input).init();
  }
}
