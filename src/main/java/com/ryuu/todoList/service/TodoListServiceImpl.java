package com.ryuu.todoList.service;
import com.ryuu.todoList.exception.TaskNotFoundException;
import com.ryuu.todoList.model.Todo;
import com.ryuu.todoList.repository.TodoListRepo;
import com.ryuu.todoList.request.TodoRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService{
    TodoListRepo todoListRepo;
    ModelMapper modelMapper;
    @Autowired
    TodoListServiceImpl(TodoListRepo todoListRepo,ModelMapper modelMapper){
        this.todoListRepo = todoListRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Todo> getAll() {
        return todoListRepo.findAll();
    }

    @Override
    public Todo createTask(TodoRequest todoRequest) {
        return todoListRepo.save(modelMapper.map(todoRequest,Todo.class));
    }

    @Override
    public Todo findBYId(Long id) {
        return todoListRepo.findById(id)
                .orElseThrow(()->new TaskNotFoundException("there is no task found with id "+ id));
    }

    @Override
    public void deleteTask(Long id) {
        Todo task = todoListRepo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("There is no task found with that ID: " + id));
        todoListRepo.delete(task);
    }

    @Override
    public Todo toggle(Long id) {
        Todo task = todoListRepo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("There is no task found with that ID: " + id));
        task.setCompleted(!task.getCompleted());
        return todoListRepo.save(task);
    }

    @Override
    public Todo updateTask(Long id,TodoRequest todoRequest) {
        Todo task = todoListRepo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("There is no task found with that ID: " + id));
        if(todoRequest.getTitle()!=null && !todoRequest.getTitle().trim().isEmpty()){
            task.setTitle(todoRequest.getTitle().trim());
        }
        if(todoRequest.getCompleted()!=null){
            task.setCompleted(todoRequest.getCompleted());
        }
        return todoListRepo.save(task);
    }

    public List<Todo> search(String keyWord){
        return todoListRepo.searchByKeyWord(keyWord);
    }
}
