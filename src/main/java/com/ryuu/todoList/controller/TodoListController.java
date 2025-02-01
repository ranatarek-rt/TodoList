package com.ryuu.todoList.controller;

import com.ryuu.todoList.model.Todo;
import com.ryuu.todoList.request.TodoRequest;
import com.ryuu.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("todo")
public class TodoListController {

    TodoListService todoListService;

    @Autowired
    TodoListController (TodoListService todoListService){
        this.todoListService = todoListService;

    }

    @GetMapping("/taskForm")
    public String showTaskForm(){
        return "taskForm";
    }
    @GetMapping
    public String getAll(Model model){
        List<Todo> tasks = todoListService.getAll();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping("/tasks")
    public String createTask(@ModelAttribute TodoRequest todoRequest) {
        todoListService.createTask(todoRequest);
        return "redirect:/todo";
    }

    @GetMapping("/{taskId}")
    public String getById(@PathVariable Long taskId, Model model) {
        Todo task = todoListService.findBYId(taskId);
        model.addAttribute("task", task);
        return "taskDetails";
    }

    @PostMapping("/{taskId}")
    public String deleteTask(@PathVariable Long taskId) {
        todoListService.deleteTask(taskId);
        return "redirect:/todo"; // Redirect to the main task list page
    }

    @PostMapping("/toggle/{taskId}")
    public String toggleTaskStatus(@PathVariable Long taskId) {
        todoListService.toggle(taskId);
        return "redirect:/todo"; // Redirect to the main task list page
    }

    @PostMapping("/update/{taskId}")
    public String taskUpdate(@PathVariable Long taskId,@ModelAttribute TodoRequest todoRequest){
        todoListService.updateTask(taskId,todoRequest);
        return "redirect:/todo";

    }
    @GetMapping("/updateForm/{taskId}")
    public String showUpdateForm(@PathVariable Long taskId, Model model) {
        Todo task = todoListService.findBYId(taskId);
        model.addAttribute("task", task);
        return "updateForm";
    }

    @GetMapping("/search")
    public String searchTasks(@RequestParam String key, Model model) {
        List<Todo> results = todoListService.search(key);
        model.addAttribute("tasks", results);
        return "tasks";
    }

}
