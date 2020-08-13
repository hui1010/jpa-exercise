package se.lexicon.huiyi.jpaexercises.dao_access;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.huiyi.jpaexercises.entity.TodoItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class TodoItemDaoJpaImpl implements TodoItemDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<TodoItem> findById(String id) {
        return Optional.ofNullable(entityManager.find(TodoItem.class, id));
    }

    @Override
    public TodoItem update(TodoItem todoItem) {
        return entityManager.merge(todoItem);
    }

    @Override
    public TodoItem save(TodoItem todoItem) {
        entityManager.persist(todoItem);
        return todoItem;
    }

    @Override
    public Boolean delete(TodoItem todoItem) {
        boolean isRemoved = false;
        if (todoItem != null && findById(todoItem.getToDoId()).isPresent()){
            entityManager.remove(todoItem);
            isRemoved = true;
        }
        return isRemoved;
    }

    @Override
    public List<TodoItem> findByTitle(String title) {
        List<TodoItem> results;
        Query query = entityManager.createQuery("SELECT t From TodoItem t WHERE t.title = :title ");
        query.setParameter("title", title);
        results = query.getResultList();
        return results;
    }

    @Override
    public List<TodoItem> findAll() {
        List<TodoItem> all;
        Query query = entityManager.createQuery("SELECT t FROM TodoItem t");
        all = query.getResultList();
        return all;
    }

    @Override
    public List<TodoItem> findByDone() {
        List<TodoItem> results;
        Query query = entityManager.createQuery("SELECT t From TodoItem t WHERE t.done = 'true'");
        results = query.getResultList();
        return results;
    }

    @Override
    public List<TodoItem> findByDeadLineBetween(LocalDateTime start, LocalDateTime end) {
        List<TodoItem> results;
        Query query = entityManager.createQuery("SELECT t From TodoItem t WHERE t.deadline BETWEEN :start AND :end");
        query.setParameter("start", start);
        query.setParameter("end", end);
        results = query.getResultList();
        return results;

    }

    @Override
    public List<TodoItem> findByDeadLineBefore(LocalDateTime end) {
        List<TodoItem> results;
        Query query = entityManager.createQuery("SELECT t From TodoItem t WHERE t.deadline < :end");
        query.setParameter("end", end);
        results = query.getResultList();
        return results;
    }

    @Override
    public List<TodoItem> findByDeadLineAfter(LocalDateTime start) {
        List<TodoItem> results;
        Query query = entityManager.createQuery("SELECT t From TodoItem t WHERE t.deadline > :start");
        query.setParameter("start", start);
        results = query.getResultList();
        return results;
    }
}
