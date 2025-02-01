package com.ryuu.todoList.repository;

import com.ryuu.todoList.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepo extends JpaRepository<Todo,Long> {
    @Query("SELECT t FROM Todo t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :key, '%'))")
    List<Todo> searchByKeyWord(@Param("key") String key);
}
