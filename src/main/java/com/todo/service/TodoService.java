package com.todo.service;

import com.todo.model.Todo;
import com.todo.repository.TodoRepository;
import com.todo.exception.TodoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo todoDetails) {
        Todo todo = getTodoById(id);

        todo.setTitle(todoDetails.getTitle());
        todo.setDescription(todoDetails.getDescription());
        todo.setCompleted(todoDetails.isCompleted());
        todo.setPriority(todoDetails.getPriority());
        todo.setDueDate(todoDetails.getDueDate());
        todo.setCategory(todoDetails.getCategory());

        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        Todo todo = getTodoById(id);
        todoRepository.delete(todo);
    }

    public List<Todo> findByCompleted(boolean completed) {
        return todoRepository.findByCompleted(completed);
    }

    public List<Todo> findByPriority(String priority) {
        return todoRepository.findByPriority(priority);
    }

    public List<Todo> findByCategory(String category) {
        return todoRepository.findByCategory(category);
    }
}