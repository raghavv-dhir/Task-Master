package com.todo.controller;

import com.todo.model.Todo;
import com.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@Valid @RequestBody Todo todo) {
        Todo savedTodo = todoService.createTodo(todo);
        return ResponseEntity.ok(savedTodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @Valid @RequestBody Todo todoDetails) {
        Todo updatedTodo = todoService.updateTodo(id, todoDetails);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/completed/{status}")
    public List<Todo> getTodosByStatus(@PathVariable boolean status) {
        return todoService.findByCompleted(status);
    }

    @GetMapping("/priority/{priority}")
    public List<Todo> getTodosByPriority(@PathVariable String priority) {
        return todoService.findByPriority(priority);
    }

    @GetMapping("/category/{category}")
    public List<Todo> getTodosByCategory(@PathVariable String category) {
        return todoService.findByCategory(category);
    }
}