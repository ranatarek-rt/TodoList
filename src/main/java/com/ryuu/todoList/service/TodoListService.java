package com.ryuu.todoList.service;


import com.ryuu.todoList.model.Todo;
import com.ryuu.todoList.request.TodoRequest;


import java.util.List;

public interface TodoListService {
    List<Todo> getAll();
    Todo createTask(TodoRequest todoRequest);
    Todo findBYId(Long id);
    void deleteTask(Long id);
    Todo toggle(Long id);
}
