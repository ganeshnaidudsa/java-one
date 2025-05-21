package com.todo.model;

public class Todo {
    private String title;
    private String description;
    private boolean isCompleted;

    public Todo() {}

    public Todo(String title, String description, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isCompleted() { return isCompleted; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCompleted(boolean completed) { isCompleted = completed; }
}
