package ru.vladimir.models;
import java.util.*;

public class Task extends Item{
  public Task(String name, String desc, long crea){
    super(name, desc, crea);
  }
  public String calculatePrice(){
    return "100%";
  }
}
	
