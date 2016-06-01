package ru.vladimir.start;
import java.util.*;

public class ConsoleInput implements Input {

  private Scanner scaner = new Scanner (System.in);  
  public String ask(String question){
    System.out.print(question);
    return scaner.nextLine();
  }
}
