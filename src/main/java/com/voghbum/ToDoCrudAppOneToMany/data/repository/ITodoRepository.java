package com.voghbum.ToDoCrudAppOneToMany.data.repository;

import com.voghbum.ToDoCrudAppOneToMany.data.entity.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITodoRepository extends CrudRepository<Todo, Long> {
    Iterable<Todo> findByCompleted(boolean completed);
    Iterable<Todo> findByTitleIgnoreCase(String title);

    //TODO:
    //Iterable<Todo> findByTitleOrderBy(String title);
    Iterable<Todo> findByTitleContainsIgnoreCase(String title);
    Iterable<Todo> findByCompletedAndTitle(boolean completed, String title);
    Iterable<Todo> findByCompletedAndTitleContains(boolean completed, String title);

    @Query(nativeQuery = true, value = "select * from todos where date_part('month', insert_time) = ?")
    Iterable<Todo> findByMonth(int month);

}
