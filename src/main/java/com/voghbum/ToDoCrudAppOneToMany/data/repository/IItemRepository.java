package com.voghbum.ToDoCrudAppOneToMany.data.repository;

import com.voghbum.ToDoCrudAppOneToMany.data.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface IItemRepository extends CrudRepository<Item, Long> {

}
