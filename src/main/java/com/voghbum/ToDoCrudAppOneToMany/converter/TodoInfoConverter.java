package com.voghbum.ToDoCrudAppOneToMany.converter;

import com.voghbum.ToDoCrudAppOneToMany.data.entity.Todo;
import com.voghbum.ToDoCrudAppOneToMany.dto.TodoInfoDTO;
import com.voghbum.ToDoCrudAppOneToMany.mapper.ITodoInfoMapper;
import org.springframework.stereotype.Component;

@Component("TodoInfoConverter")
public class TodoInfoConverter implements ITodoInfoMapper {
     public Todo toTodo(TodoInfoDTO todoInfoDTO) {
          Todo todo = new Todo();

          todo.title = todoInfoDTO.getTitle();
          todo.description = todoInfoDTO.getDescription();
          todo.insertTime = todoInfoDTO.getInsertTime();
          todo.completed = todoInfoDTO.isCompleted();

          return todo;
     }

     public TodoInfoDTO toTodoInfoDTO(Todo todo) {
          TodoInfoDTO todoInfoDTO = new TodoInfoDTO();

          todoInfoDTO.setId(todo.id);
          todoInfoDTO.setTitle(todo.title);
          todoInfoDTO.setDescription(todo.description);
          todoInfoDTO.setInsertTime(todo.insertTime);
          todoInfoDTO.setCompleted(todo.completed);

          return todoInfoDTO;
     }
}
