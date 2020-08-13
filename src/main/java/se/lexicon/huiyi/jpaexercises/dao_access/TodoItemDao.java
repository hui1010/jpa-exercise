package se.lexicon.huiyi.jpaexercises.dao_access;

import se.lexicon.huiyi.jpaexercises.entity.TodoItem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TodoItemDao {
    Optional<TodoItem> findById(String id);
    TodoItem update(TodoItem todoItem);
    TodoItem save(TodoItem todoItem);
    Boolean delete(TodoItem todoItem);
    List<TodoItem> findByTitle(String title);
    List<TodoItem> findAll();
    List<TodoItem> findByDone();
    List<TodoItem> findByDeadLineBetween(LocalDateTime start, LocalDateTime end);
    List<TodoItem> findByDeadLineBefore(LocalDateTime end);
    List<TodoItem> findByDeadLineAfter(LocalDateTime start);
}
