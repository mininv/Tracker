package ru.vladimir.start;

public interface UserAction{
// запрашиваем действие ключ действия пользователя   
  int key();
//запрашивать действие  
  void execute(Input input, Tracker tracker);

  String info();
}
