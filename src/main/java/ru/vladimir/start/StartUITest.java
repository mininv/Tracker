package ru.vladimir.start;

public class StartUITest{

  public static void main(String[] args){
    Input input = new StubInput(new String[]{"0", "btest", "btest", "n" , "0", "atest1", "atest1", "n" ,"0", "test2", "test2", "n" , "1", "n", "4", "1", "n", "1", "y"});
    new StartUI(input).init();
  }
}
