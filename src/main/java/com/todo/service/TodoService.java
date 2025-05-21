package com.todo.service;

import com.todo.model.Todo;
import com.todo.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {
    private final Map<String, User> userMap = new HashMap<>();

    public String registerUser(User user) {
        if (userMap.containsKey(user.getEmail())) {
            return "User already exists.";
        }
        userMap.put(user.getEmail(), user);
        return "User registered successfully.";
    }

    public String addTodo(String email, Todo todo) {
        User user = userMap.get(email);
        if (user == null) return "User not found.";
        user.getTodos().add(todo);
        return "Todo added.";
    }

    public List<Todo> getTodos(String email) {
        User user = userMap.get(email);
        if (user == null) return Collections.emptyList();
        return user.getTodos();
    }

    public String markCompleted(String email, String title) {
        User user = userMap.get(email);
        if (user == null) return "User not found.";
        for (Todo todo : user.getTodos()) {
            if (todo.getTitle().equalsIgnoreCase(title)) {
                todo.setCompleted(true);
                return "Marked as completed.";
            }
        }
        return "Todo not found.";
    }
}
