package com.voghbum.ToDoCrudAppOneToMany.mapper;

import com.voghbum.ToDoCrudAppOneToMany.data.entity.Item;
import com.voghbum.ToDoCrudAppOneToMany.dto.ItemSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(implementationName = "ItemSaveMapperImpl", componentModel = "spring")
public interface IItemSaveMapper {
    @Mappings(@Mapping(source = "todoId", target = "todoId"))
    ItemSaveDTO toItemSaveDTO(Item item);

    @Mappings(@Mapping(source = "todoId", target = "todoId"))
    Item toItem(ItemSaveDTO itemSaveDTO);
}