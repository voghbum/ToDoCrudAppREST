package com.voghbum.ToDoCrudAppOneToMany.service;

import com.voghbum.ToDoCrudAppOneToMany.data.dal.TodoAppDAL;
import com.voghbum.ToDoCrudAppOneToMany.dto.ItemInfoDTO;
import com.voghbum.ToDoCrudAppOneToMany.dto.ItemSaveDTO;
import com.voghbum.ToDoCrudAppOneToMany.dto.TodoInfoDTO;
import com.voghbum.ToDoCrudAppOneToMany.dto.TodoSaveDTO;
import com.voghbum.ToDoCrudAppOneToMany.mapper.IItemInfoMapper;
import com.voghbum.ToDoCrudAppOneToMany.mapper.IItemSaveMapper;
import com.voghbum.ToDoCrudAppOneToMany.mapper.ITodoInfoMapper;
import com.voghbum.ToDoCrudAppOneToMany.mapper.ITodoSaveMapper;
import com.voghbum.util.data.DatabaseUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TodoApplicationService {
    private final TodoAppDAL m_todoAppDAL;
    private final ITodoInfoMapper m_todoInfoMapper;
    private final ITodoSaveMapper m_todoSaveMapper;
    private final IItemInfoMapper m_itemInfoMapper;
    private final IItemSaveMapper m_itemSaveMapper;

    private TodoInfoDTO saveTodoCallback(TodoSaveDTO todoSaveDTO) {
        return m_todoInfoMapper.toTodoInfoDTO(m_todoAppDAL.saveTodo(m_todoSaveMapper.toTodo(todoSaveDTO)));
    }

    private List<TodoInfoDTO> findAllCallback() {
        return StreamSupport.stream(m_todoAppDAL.findAllTodos().spliterator(), false).map(m_todoInfoMapper::toTodoInfoDTO)
                .collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findTodosByCompletedCallback(boolean completed) {
        return StreamSupport.stream(m_todoAppDAL.findTodosByCompleted(completed).spliterator(), false)
                .map(m_todoInfoMapper::toTodoInfoDTO).collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findTodosByTitleCallback(String title) {
        return StreamSupport.stream(m_todoAppDAL.findTodosByTitle(title).spliterator(), false).
                map(m_todoInfoMapper::toTodoInfoDTO).collect(Collectors.toList());
    }

    /*
    private List<TodoInfoDTO> findTodosByTitleOrderByCallback(String title) {
        return StreamSupport.stream(m_todoAppDAL.findTodosByTitleOrderBy(title).spliterator(), false)
                .map(m_todoInfoConverter::toTodoInfoDTO).collect(Collectors.toList());
    }
    */

    private List<TodoInfoDTO> findTodosByTitleContainsCallback(String title) {
        return StreamSupport.stream(m_todoAppDAL.findTodosByTitleContains(title).spliterator(), false)
                .map(m_todoInfoMapper::toTodoInfoDTO).collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findTodosByCompletedAndTitleContainsCallback(boolean completed, String title) {
        return StreamSupport.stream(m_todoAppDAL.findTodosByCompletedAndTitleContains(completed, title).spliterator(), false)
                .map(m_todoInfoMapper::toTodoInfoDTO).collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findTodosByCompletedAndTitleCallback(boolean completed, String title) {
        return StreamSupport.stream(m_todoAppDAL.findTodosByCompletedAndTitle(completed, title).spliterator(), false)
                .map(m_todoInfoMapper::toTodoInfoDTO).collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findTodosByMonthCallback(int month) {
        return StreamSupport.stream(m_todoAppDAL.findTodosByMonth(month).spliterator(), false)
                .map(m_todoInfoMapper::toTodoInfoDTO).collect(Collectors.toList());
    }

    private ItemInfoDTO saveItemCallback(ItemSaveDTO itemSaveDTO) {
        var item = m_itemSaveMapper.toItem(itemSaveDTO);
        m_todoAppDAL.saveItem(item);

        return m_itemInfoMapper.toItemInfoDTO(item);
    }

    public List<TodoInfoDTO> findByTodosByCompletedAndTitleContains(boolean completed, String title) {
        return DatabaseUtil.doWorkForService(() -> findTodosByCompletedAndTitleContainsCallback(completed, title),
                "TodoService.findByCompletedAndTitle(boolean, String)");
    }

    public List<TodoInfoDTO> findTodosByCompletedAndTitle(boolean completed, String title) {
        return DatabaseUtil.doWorkForService(() -> findTodosByCompletedAndTitleCallback(completed, title),
                "TodoService.findByCompletedAndTitle(boolean, String)");
    }

    public List<TodoInfoDTO> findTodosByTitleContains(String title) {
        return DatabaseUtil.doWorkForService(() -> findTodosByTitleContainsCallback(title),
                "TodoService.findTodosByTitleContains(String)");
    }

    /*
    public List<TodoInfoDTO> findTodosByTitleOrderBy(String title) {
        return DatabaseUtil.doWorkForService(() -> findTodosByTitleOrderByCallback(title), "TodoService.findTodosByTitleOrderBy(String)");
    }
    */

    public List<TodoInfoDTO> findAllTodos() {
        return DatabaseUtil.doWorkForService(this::findAllCallback, "TodoService.findAllTodos");
    }

    public List<TodoInfoDTO> findTodosByCompleted(boolean completed) {
        return DatabaseUtil.doWorkForService(() -> findTodosByCompletedCallback(completed),
                "TodoService.findTodosByCompleted()");
    }

    public List<TodoInfoDTO> findTodosByTitle(String title) {
        return DatabaseUtil.doWorkForService(() -> findTodosByTitleCallback(title), "TodoService.findTodosByTitle()");
    }

    public List<TodoInfoDTO> findTodosByMonth(int month) {
        return DatabaseUtil.doWorkForService(() -> findTodosByMonthCallback(month), "TodoService.findTodosByMonth(int)");
    }

    public TodoApplicationService(TodoAppDAL todoAppDAL,
                                  @Qualifier("todoInfoMapperImpl") ITodoInfoMapper todoInfoMapper,
                                  @Qualifier("todoSaveMapperImpl") ITodoSaveMapper todoSaveMapper,
                                  IItemSaveMapper itemSaveMapper,
                                  IItemInfoMapper itemInfoMapper
                       ) {
        m_itemSaveMapper = itemSaveMapper;
        m_itemInfoMapper = itemInfoMapper;
        m_todoAppDAL = todoAppDAL;
        m_todoInfoMapper = todoInfoMapper;
        m_todoSaveMapper = todoSaveMapper;
    }

    public TodoInfoDTO saveTodo(TodoSaveDTO todoSaveDTO) {
        return DatabaseUtil.doWorkForService(() -> saveTodoCallback(todoSaveDTO), "TodoService.saveTodo()");
    }

    public ItemInfoDTO saveItem(ItemSaveDTO itemSaveDTO) {
        return DatabaseUtil.doWorkForService(() -> saveItemCallback(itemSaveDTO), "TodoService.saveItem()");
    }

    public void deleteAllTodos() {
        DatabaseUtil.doWorkForServiceRunnable(m_todoAppDAL::deleteAllTodos,
                "TodoService.deleteAllTodos");
    }


}
