package com.voghbum.ToDoCrudAppOneToMany.controller;

import com.voghbum.ToDoCrudAppOneToMany.dto.TodoInfoDTO;
import com.voghbum.ToDoCrudAppOneToMany.dto.TodoSaveDTO;
import com.voghbum.ToDoCrudAppOneToMany.service.TodoApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoController {
    private final TodoApplicationService m_todoApplicationService;

    public TodoController(TodoApplicationService todoApplicationService) {
        m_todoApplicationService = todoApplicationService;
    }

    @PostMapping("save")
    public TodoInfoDTO saveTodo(@RequestBody TodoSaveDTO todoSaveDTO) {
        return m_todoApplicationService.saveTodo(todoSaveDTO);
    }

    @GetMapping("todos")
    public List<TodoInfoDTO> findAllTodos() {
        return m_todoApplicationService.findAllTodos();
    }

    @GetMapping("todos/find/bycompleted")
    public List<TodoInfoDTO> findTodosByCompleted(@RequestParam boolean completed) {
        return m_todoApplicationService.findTodosByCompleted(completed);
    }

    @GetMapping("todos/find/bytitle")
    public List<TodoInfoDTO> findTodosByTitle(@RequestParam String title) {
        return m_todoApplicationService.findTodosByTitle(title);
    }

    @GetMapping("todos/find/contains/bytitle")
    public List<TodoInfoDTO> findTodosByTitleContains(@RequestParam String title) {
        return m_todoApplicationService.findTodosByTitleContains(title);
    }

    @GetMapping("todos/find/bycompleted/bytitle")
    public List<TodoInfoDTO> findTodosByCompletedAndTitle(@RequestParam boolean completed, @RequestParam String title) {
        return m_todoApplicationService.findTodosByCompletedAndTitle(completed, title);
    }

    @GetMapping("todos/find/contains/bycompleted/bytitle")
    public List<TodoInfoDTO> findTodosByCompletedAndTitleContains(@RequestParam boolean completed, @RequestParam String title) {
        return m_todoApplicationService.findByTodosByCompletedAndTitleContains(completed, title);
    }

    @GetMapping("todos/find/bymonth")
    public List<TodoInfoDTO> findTodosByMonth(@RequestParam int month) {
        return m_todoApplicationService.findTodosByMonth(month);
    }

    @GetMapping("todos/delete/all")
    public void deleteAllTodos() {
        m_todoApplicationService.deleteAllTodos();
    }
}
