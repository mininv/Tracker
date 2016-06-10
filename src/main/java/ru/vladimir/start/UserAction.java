package ru.vladimir.start;

public interface UserAction{
  int key();// запрашиваем действие ключ действия пользователя 
  
  void execute(Input input, Tracker tracker);//запрашивать действие

  String info();
}
