package com.voghbum.ToDoCrudAppOneToMany.converter;

import com.voghbum.ToDoCrudAppOneToMany.data.entity.Todo;
import com.voghbum.ToDoCrudAppOneToMany.dto.TodoSaveDTO;
import com.voghbum.ToDoCrudAppOneToMany.mapper.ITodoSaveMapper;
import org.springframework.stereotype.Component;

@Component("TodoSaveConverter")
public class TodoSaveConverter implements ITodoSaveMapper {
    public Todo toTodo(TodoSaveDTO todoSaveDTO) {
        var todo = new Todo();

        todo.description = todoSaveDTO.getDescription();
        todo.title = todoSaveDTO.getTitle();

        return todo;
    }

    public TodoSaveDTO toTodoSaveDTO (Todo todo) {
        TodoSaveDTO todoSaveDTO = new TodoSaveDTO();

        todoSaveDTO.setDescription(todo.description);
        todoSaveDTO.setTitle(todo.title);

        return todoSaveDTO;
    }
}
