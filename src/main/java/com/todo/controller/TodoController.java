package com.todo.controller;

import com.todo.model.Todo;
import com.todo.model.User;
import com.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return todoService.registerUser(user);
    }

    @PostMapping("/{email}/todo")
    public String addTodo(@PathVariable String email, @RequestBody Todo todo) {
        return todoService.addTodo(email, todo);
    }

    @GetMapping("/{email}/todos")
    public List<Todo> getTodos(@PathVariable String email) {
        return todoService.getTodos(email);
    }

    @PutMapping("/{email}/todo/{title}/complete")
    public String markTodoCompleted(@PathVariable String email, @PathVariable String title) {
        return todoService.markCompleted(email, title);
    }
}
