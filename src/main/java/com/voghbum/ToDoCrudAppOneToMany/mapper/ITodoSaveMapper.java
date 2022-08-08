package com.voghbum.ToDoCrudAppOneToMany.mapper;

import com.voghbum.ToDoCrudAppOneToMany.data.entity.Todo;
import com.voghbum.ToDoCrudAppOneToMany.dto.TodoSaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "TodoSaveMapperImpl", componentModel = "spring")
public interface ITodoSaveMapper {
    Todo toTodo(TodoSaveDTO todoSaveDTO);
    TodoSaveDTO toTodoSaveDTO (Todo todo);
}
