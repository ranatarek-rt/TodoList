package com.ryuu.todoList.repository;

import com.ryuu.todoList.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepo extends JpaRepository<Todo,Long> {
}
