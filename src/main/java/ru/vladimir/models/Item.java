package ru.vladimir.models;

public class Item{
  private String id;// уникальный номер для каждого item
  public String name;
  public String description;//описание
  public long create;// дата заявки
  public Item(){

  }
  public Item(String name, String description, long create){
    this.name = name;
    this.description=description;
    this.create = create;
  }
  public String getName(){
    return this.name;
  }
  public String getDescription(){
    return this.description;
  }
  public long getCreate(){
    return this.create;
  }
  public String getId(){
    return this.id;
  }
  public void setId(String id){
  this.id = id;
  }
}
