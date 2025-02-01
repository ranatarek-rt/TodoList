package com.ryuu.todoList.controller;

import com.ryuu.todoList.model.Todo;
import com.ryuu.todoList.request.TodoRequest;
import com.ryuu.todoList.service.TodoListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    TodoListService todoListService;

    @Autowired
    TestController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @Operation(summary = "get All ", description = "Get all tasks from Database ")
    @GetMapping
    public List<Todo> getAll(){
        return todoListService.getAll();
    }

    @Operation(summary = "Update a task", description = "Updates an existing task with new details.")
    @PatchMapping("/update/{taskId}")
    public Todo taskUpdate(
            @Parameter(description = "ID of the task to be updated") @PathVariable Long taskId,
            @RequestBody TodoRequest todoRequest) {
        return todoListService.updateTask(taskId, todoRequest);
    }

    @Operation(summary = "Create a new task", description = "Creates a new todo task.")
    @PostMapping
    public Todo createTask(@RequestBody TodoRequest todoRequest) {
        return todoListService.createTask(todoRequest);
    }

    @Operation(summary = "Get a task by ID", description = "Fetches a todo task by its ID.")
    @GetMapping("/{taskId}")
    public Todo getById(
            @Parameter(description = "ID of the task to retrieve") @PathVariable Long taskId) {
        return todoListService.findBYId(taskId);
    }

    @Operation(summary = "Delete a task", description = "Deletes a todo task by ID.")
    @DeleteMapping("/{taskId}")
    public String deleteTask(
            @Parameter(description = "ID of the task to delete") @PathVariable Long taskId) {
        todoListService.deleteTask(taskId);
        return "The task is deleted successfully with ID " + taskId;
    }

    @Operation(summary = "Toggle task status", description = "Marks a task as completed or not.")
    @PutMapping("/toggle/{taskId}")
    public Todo toggleTaskStatus(
            @Parameter(description = "ID of the task to toggle status") @PathVariable Long taskId) {
        return todoListService.toggle(taskId);
    }
}
