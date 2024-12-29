package com.todo.model;

import jakarta.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean completed = false; // Set default value to false
    private String priority;
    private String dueDate;
    private String category;

    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isCompleted() { return completed; }
    public String getPriority() { return priority; }
    public String getDueDate() { return dueDate; }
    public String getCategory() { return category; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
    public void setCategory(String category) { this.category = category; }

    // Default constructor
    public Todo() {}

    // All args constructor
    public Todo(Long id, String title, String description, boolean completed,
                String priority, String dueDate, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.priority = priority;
        this.dueDate = dueDate;
        this.category = category;
    }
}
