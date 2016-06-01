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
    return String.valueOf(System.currentTimeMillis() + RN.nextInt());//String.valueof преобразует Integer в строку
  }
  
  public Item[] getAll(){
    Item[] result = new Item[this.position];//массив объектов, для тех элементов которые мы вставили
    for (int index = 0; index != this.position; index++){
      result[index] = this.items[index];
    }    
    return result;
  }
  
  public void redact(String id, String newName){// метод для редактирования заявки по ее id
    for (Item item : items){
      if (item != null && id.equals(item.getId())){
        item.name = newName;
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
  
  public void findBy(String name, String alf, long create){//метод для вывода на эклан всех заявок
    if(name == null & alf == null & create == 0){//просто вывод всех заявок на экран
      int x =1;
      for (Item item: items){
        if (item == null){
          break;
        }
        if (item.getId()!= null) System.out.print("Заявка номер: " + x++ +".");System.out.println(" Name - " + item.getName()+ ", Desc: " +
        item.getDescription() + ", Id: " + item.getId() + ", data: " + item.getCreate());
      }
    }
    else if(name != null & alf == null & create == 0){//вывод заявки по имени
      System.out.println("По имени -");
      for (Item item : items){
        if (item != null && item.getName().equals(name)){
          System.out.println(" Name - " + item.getName()+ ", Desc: " +
          item.getDescription() + ", Id: " + item.getId() + ", data: " + item.getCreate());
          break;
        }
      }
    }
    
    else if(name == null & alf == null & create != 0){//вывод заявки с опр даты
      System.out.println("С такой то даты -");
      for (Item item : items){
        if (item != null && item.getCreate()> create){
          System.out.println(" Name - " + item.getName()+ ", Desc: " +
          item.getDescription() + ", Id: " + item.getId() + ", data: " + item.getCreate());
        }
      }
    }
  }
}

 
