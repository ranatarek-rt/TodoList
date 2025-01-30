package com.ryuu.todoList.controller;

import com.ryuu.todoList.model.Todo;
import com.ryuu.todoList.request.TodoRequest;
import com.ryuu.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class testController {

    TodoListService todoListService;

    @Autowired
    testController (TodoListService todoListService){
        this.todoListService = todoListService;

    }

//    @PatchMapping("/update/{taskId}")
//    public Todo taskUpdate(@PathVariable Long taskId,@RequestBody TodoRequest todoRequest){
//        return todoListService.updateTask(taskId,todoRequest);
//
//    }
//    @PostMapping()
//    public Todo createTask(@RequestBody TodoRequest todoRequest) {
//        return todoListService.createTask(todoRequest);
//
//    }
//    @GetMapping("/{taskId}")
//    public Todo getById(@PathVariable Long taskId) {
//        return todoListService.findBYId(taskId);
//    }
//
//    @DeleteMapping("/{taskId}")
//    public String deleteTask(@PathVariable Long taskId) {
//         todoListService.deleteTask(taskId);
//         return "the task is deleted successfully with id "+ taskId;
//    }
//
//    @PutMapping("/toggle/{taskId}")
//    public Todo toggleTaskStatus(@PathVariable Long taskId ){
//        return todoListService.toggle(taskId);
//    }


}
