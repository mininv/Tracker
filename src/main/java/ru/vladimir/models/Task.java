package ru.vladimir.models;
import java.util.*;

public class Task extends Item{
  public Task(String name, String desc, long crea){
    this.name = name;
    this.description = desc;
    this.create = crea;
  }
  public String calculatePrice(){
    return "100%";
  }
}
	

