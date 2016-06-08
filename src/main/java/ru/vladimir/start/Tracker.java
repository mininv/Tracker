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
  private int position = 0;// иницилизаяция поля
  private static final Random RN = new Random();//метод в пакете java.utils.*, static final - указывают на константу
  int rage=9999;
  
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
    return String.valueOf(1000+RN.nextInt(rage-1000));//String.valueof преобразует Integer в строку
  }
  
  public Item[] getAll(){
    Item[] result = new Item[this.position];//массив объектов, для тех элементов которые мы вставили
    for (int index = 0; index != this.position; index++){
      result[index] = this.items[index];
    }    
    return result;
  }
  
  public void redact(String id, String newName, String newDesc, long newCrea){// метод для редактирования заявки по ее id
    for (Item item : items){
      if (item != null && id.equals(item.getId())){
        item.name = newName;
        item.description = newDesc;
        item.create = newCrea;
        break;
      }
    }   
  }

  public void addDesc(String id, String newDesc){//Добавление комментария к заявке
    for (Item item : items){
      if (item != null && id.equals(item.getId())){
        item.description = newDesc;
        break;
      }
    }   
  }
  
  public void delete(String id){//метод, удаляющий заявку
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
  
   
  public void edit(Item fresh){
    for (Item item: items){
      if (item!=null && item.getId().equals(fresh.getId())){
        item = fresh;
        break;
      }
    }
  }

  public Item[] alfait(){//метод для вывода на эклан всех заявок в алфавитном порядке
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

  public Item[] crea(){//метод примененея к массиву фильтра по пронципу с самой ранней даты
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

 
