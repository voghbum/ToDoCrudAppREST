package com.voghbum.ToDoCrudAppOneToMany.data.dal;

import com.voghbum.ToDoCrudAppOneToMany.data.entity.Item;
import com.voghbum.ToDoCrudAppOneToMany.data.entity.Todo;
import com.voghbum.ToDoCrudAppOneToMany.data.repository.IItemRepository;
import com.voghbum.ToDoCrudAppOneToMany.data.repository.ITodoRepository;
import com.voghbum.util.data.DatabaseUtil;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

@Component
public class TodoAppDAL {
    private final ITodoRepository m_todoRepository;
    private final IItemRepository m_itemRepository;

    private Item saveItemCallback(Item item) {
        var optTodo = m_todoRepository.findById(item.todoId);

        if(optTodo.isEmpty())
            throw new IllegalArgumentException("todId cannot found");

        item.todo = optTodo.get();

        return m_itemRepository.save(item);
    }

    public TodoAppDAL(ITodoRepository todoRepository, IItemRepository itemRepository) {
        m_todoRepository = todoRepository;
        m_itemRepository = itemRepository;
    }

    public Iterable<Todo> findAllTodos() {
        return DatabaseUtil.doWorkForRepository(m_todoRepository::findAll,
                "TodoAppDAL.findAllTodos()");
    }

    public Iterable<Todo> findTodosByCompleted(boolean completed) {
        return DatabaseUtil.doWorkForRepository(() -> m_todoRepository.findByCompleted(completed),
                "TodoAppDAL.findTodosByCompleted(boolean)");
    }

    public Iterable<Todo> findTodosByTitle(String title) {
        return DatabaseUtil.doWorkForRepository(() -> m_todoRepository.findByTitleIgnoreCase(title),
                "TodoAppDAL.findTodosByTitle(String)");
    }

    public Todo saveTodo(Todo todo) {
        return DatabaseUtil.doWorkForRepository(() -> m_todoRepository.save(todo),
                "TodoAppDAL.saveTodo(Todo)");
    }

    //TODO:
    /*
    public Iterable<Todo> findTodosByTitleOrderBy(String title) {
        return DatabaseUtil.doWorkForRepository(() -> m_todoRepository.findByTitleOrderBy(title),
                "TodoAppDAL.findTodosByTitleOrderBy(String)");
    }
    */

    public Iterable<Todo> findTodosByTitleContains(String title) {
        return DatabaseUtil.doWorkForRepository(() -> m_todoRepository.findByTitleContainsIgnoreCase(title),
                "TodoAppDAL.findTodosByTitleContains(String)");
    }

    public Iterable<Todo> findTodosByCompletedAndTitle(boolean completed, String title) {
        return DatabaseUtil.doWorkForRepository(() -> m_todoRepository.findByCompletedAndTitle(completed, title),
                "TodoAppDAL.findTodosByCompletedAndTitle(boolean, String)");

    }

    public Iterable<Todo> findTodosByCompletedAndTitleContains(boolean completed, String title) {
        return DatabaseUtil.doWorkForRepository(() -> m_todoRepository.findByCompletedAndTitleContains(completed, title),
                "TodoAppDAL.findTodosByCompletedAndTitleContains(boolean, String)");

    }

    public Iterable<Todo> findTodosByMonth(int month) {
        return DatabaseUtil.doWorkForRepository(() -> m_todoRepository.findByMonth(month),
                "TodoAppDAL.findTodosByMonth(int)");
    }

    public void deleteAllTodos() {
        DatabaseUtil.doWorkForRepositoryRunnable(m_todoRepository::deleteAll,
                "TodoAppDAL.deleteAllTodos()");
    }

    @Transactional
    public Item saveItem(Item item) {
        return DatabaseUtil.doWorkForRepository(() -> saveItemCallback(item),
                "TopoAppDAL.saveItem()");
    }

   /*
   public Optional<Todo> findTodoById(long id) {
        return DatabaseUtil.doWorkForRepository(() -> m_todoRepository.findById(id),
                "TodoAppDAL.findTodoById(long)");
    }*/


}
