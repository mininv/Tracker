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
  Item t;// переменная необходимая для работы метода сортировфки по Алфавитному принципу
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
  public void redact(Item itema){// метод для редактирования заявки по ее id
    for (Item item : items){
      if (item != null && itema.getId().equals(item.getId())){
        itema.name = "New new";
        itema.description = "Wot tak";
        itema.create = 11102014;
        break;
      }
    }
  }
  public Item[] delete(Item itema){//метод, удаляющий заявку
    int index= 0;
    int t;
    Item[] news = new Item[position];
      for (Item item : items){
        if ((item != null) && itema.getId().equals(item.getId())) {
          for(index=index;index<3; index++ ){
            items[index] = items[index+1];
            news[index]= items[index];
          }
          break;	
        }
        else {
          news[index]= items[index];
          index++;
        }
      }
    return news;
  }
  public void listing(){//метод для вывода на эклан всех заявок
    int x =1;
    for (Item item: items){
      if (item == null){
        break;
      }
      if (item.getId()!= null) System.out.print("Заявка номер: " + x++ +".");System.out.println(" Name - " + item.getName()+ ", Desc: " +
       item.getDescription() + ", Id: " + item.getId() + ", data: " + item.getCreate());
    }
  }
 /* public void alfavit(){//метод реализующий расстановку по алфавитному принципу
    for (int a = 1; a < this.position; a++){
      for (int b = this.position - 1; b >= a; b--){
        if (items[b - 1].name==null & items[b].name != null){ 
          t = items[b - 1];
          items[b - 1] = items[b];
          items[b] = t;
        }
        else if (items[b - 1].name!=null & items[b].name != null){
          if (items[b - 1].name.charAt(0) > items[b].name.charAt(0)){
            t = items[b - 1];
            items[b - 1] = items[b];
            items[b] = t;
          } 
        }
        else if (items[b - 1].name!=null & items[b].name == null){
          items[b - 1] = items[b-1];
          items[b] = items[b];
        }
      }
    }
    System.out.print("Отсортированный массив: ");
    listing();
  }
  public void searchByName(String name){//метод для поиска заявки по имени
    for (Item item : items){
      if (item != null && item.getName().equals(name)){
        System.out.println(" Name - " + item.getName()+ ", Desc: " +
        item.getDescription() + ", Id: " + item.getId() + ", data: " + item.getCreate());
        break;
      }
    }
  }
  public void searchBycreate(long create){//выводит на экран все завки с опр даты
    for (Item item : items){
      if (item != null && item.getCreate()> create){
        System.out.println(" Name - " + item.getName()+ ", Desc: " +
        item.getDescription() + ", Id: " + item.getId() + ", data: " + item.getCreate());
      }
    }
  }  */  
}

 
