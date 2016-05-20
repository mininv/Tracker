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
  private Item[] items = new Item[2];
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
  public Item redact(Item item){// метод для редактирования заявки
    System.out.println("Введите новое значение поля name: ");
    try{BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String s = reader.readLine();
      if (s.length()!= 0){//проверка, что был получен вводный файл, если строка равна нулю, то поле остается неизменным.
        item.name = s;
      } else item.name = item.name;
      String b= reader.readLine();
      if (b.length()!= 0){
        item.description = b;
      } else  item.description = item.description;
    } catch (IOException e){
        System.out.println("упс");
      }
    return item;
  }
  public Item delete(Item item){//метод, удаляющий заявку
    item.name = "";
    item.description = "";
    item.create= 0;
    return item;
  }
  public void listing(){//метод для вывода на клан всех заявок
    int x =1;
    for (Item item: items){
      if (item == null){
        break;
      }
      System.out.print("Заявка номер: " + x++ +".");System.out.println(" Name - " + item.getName()+ ", Desc: " + item.getDescription() + ", Id: " + item.getId() + ", data: " + item.getCreate());
    }
  }
  public void filter(){//метод для вывода фильтра на экран
    System.out.println("Список всех заявок: ");    
    listing();
    System.out.println("Для формотирования спаска заявок выберите один из вариантов фильтра. "); 
    System.out.println("1. Вывести заявки в алфавитном порядке имен.");
    System.out.println("2. Вывести заявку с определенным именем.");
    System.out.println("3. Вывести заявки с определенной даты.");
    System.out.println("Для выбора фильтра введите число(1-3) соответствующее необходимому фильтру:");
    try{
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      int i= Integer.parseInt(reader.readLine());
        if (i == 1){alfavit();}
        if (i == 2){searchByName();}
        if (i == 3){searchBycreate();}
    }catch (IOException e){
       System.out.println("упс");
     }

  } 
  public void alfavit(){//метод реализующий расстановку по алфавитному принципу
    for (int a = 1; a < items.length; a++){
      for (int b = items.length - 1; b >= a; b--){
        if (items[b]== null ){break;}
        if (items[b - 1].name.charAt(0) > items[b].name.charAt(0)){
          t = items[b - 1];
          items[b - 1] = items[b];
          items[b] = t;
        }
      }
      System.out.print("Отсортированный массив: ");
      listing();
    }
  }
  public void searchByName(){//метод для поиска заявки по имени
    System.out.println("Введите имя интересующей вас заявки: ");
    try{
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String s = reader.readLine();
      for (int a = 0; a < items.length; a++){
        if (items[a]== null ){break;}
        if(s.equals(items[a].name)){
          System.out.println(" Name - " + items[a].getName()+ ", Desc: " + items[a].getDescription() + ", Id: " + items[a].getId() + ", data: " +         items[a].getCreate());
        }
      }
    } catch (IOException e){
        System.out.println("упс");
      }
  }
  public void searchBycreate(){//выводит на экран все завки с опр даты
    System.out.println("Введите дату с которой пойдет ввывод всех заявок: ");
    try{
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      long i= Long.parseLong(reader.readLine());
      for (int a = 0; a < items.length; a++){
        if (items[a] == null ){break;}
        if(i < items[a].create){
          System.out.println(" Name - " + items[a].getName()+ ", Desc: " + items[a].getDescription() + ", Id: " + items[a].getId() + ", data: " +         items[a].getCreate());
        }
      }
    } catch (IOException e){
        System.out.println("упс");
      }
  }
}

