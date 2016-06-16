package ru.vladimir.start;

public interface Input{

  public String ask(String question);
  
  int ask(String question, int[] range);// перезагрузка метода, для этого изменяем кол-во параметров

}
