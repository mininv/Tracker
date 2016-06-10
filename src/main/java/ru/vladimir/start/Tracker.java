package ru.vladimir.start;
import ru.vladimir.models.*;// пакет в котором лежат классы,
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.ref.Reference;
// * - указывает на все классы
//  - этот класс хранилище заявок

public class Tracker {
  private Item[] items = new Item[10];
  // иницилизаяция поля
  private int position = 0;
  //метод в пакете java.utils.*, static final - указывают на константу
  private static final Random RN = new Random();
  int rage=9999;//для 4х значного id
  private Comment[] comments = new Comment[10];
  private int pos = 0;
  
  public Item add(Item item){
    item.setId(this.generateId());
    this.items[position++] = item;// первое поле 0, и так далее
    return item;
  }
  
  protected Item findById(String id){
    Item result = null;
    for (Item item : items){
      if (item != null && item.getId().equals(id)){
        result = item;
        break;
      }
    }
    return result;
  }
  
  String generateId(){
    //String.valueof преобразует Integer в строку
    return String.valueOf(1000+RN.nextInt(rage-1000));
  }
  
  public Item[] getAll(){
    //массив объектов, для тех элементов которые мы вставили 
    Item[] result = new Item[this.position];
    for (int index = 0; index != this.position; index++){
      result[index] = this.items[index];
    }    
    return result;
  }
  

//Добавление комментария к заявке
  public void addComment(String id, String comment){
    for (Item item : items){
      if (item != null && id.equals(item.getId())){
        this.comments[pos++] = new Comment(comment);
        break;
      }
    }   
  }
//метод, удаляющий заявку  
  public void delete(String id){
    int t = 0;  
    for (Item item : items){
      if ((item != null) && id.equals(item.getId())) {
        for(int i=t; i<this.position; i++ ){
          if(i!=this.position - 1)items[i] = items[i+1];
          else{ 
            items[i]= null;
            this.position--;
          }
        }
        break;	
      }
      t++;
    }  
  }
  
// метод для редактирования заявки по ее id
  public void edit(Item fresh){
    for (Item item: items){
      if (item!=null && item.getId().equals(fresh.getId())){
        item.name = fresh.name;
        item.description = fresh.description;
        item.create = fresh.create;
        break;
      }
    }
  }
//метод для вывода на эклан всех заявок в алфавитном порядке
  public Item[] alfait(){
    for (int a = this.position - 1; a > 0;a--){
      for ( int b = 0; b < a; b++){
        if (items[b]!= null & items[b + 1].name.charAt(0) < items[b].name.charAt(0)){
          Item t = items[b];
          items[b] = items[b+1];
          items[b+1] = t;
        }
      }  
    }
    return items;
  }
//метод примененея к массиву фильтра по пронципу с самой ранней даты
  public Item[] crea(){
    for (int a = this.position - 1; a > 0;a--){
      for ( int b = 0; b < a; b++){
        if (items[b]!= null & items[b + 1].create < items[b].create){
          Item t = items[b];
          items[b] = items[b+1];
          items[b+1] = t;
        }
      }  
    } 
    return items;
  }
}

 
