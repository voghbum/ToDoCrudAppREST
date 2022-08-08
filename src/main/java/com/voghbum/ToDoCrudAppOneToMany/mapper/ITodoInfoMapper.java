package com.voghbum.ToDoCrudAppOneToMany.mapper;

import com.voghbum.ToDoCrudAppOneToMany.data.entity.Todo;
import com.voghbum.ToDoCrudAppOneToMany.dto.TodoInfoDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "TodoInfoMapperImpl", componentModel = "spring")
public interface ITodoInfoMapper {
    //@Mapping(target = "insertTime", source = "todoInfoDTO.insertTime")
    Todo toTodo(TodoInfoDTO todoInfoDTO);

    //@Mapping(target = "insertTime", source = "todo.insertTime")
    TodoInfoDTO toTodoInfoDTO(Todo todo);
}
