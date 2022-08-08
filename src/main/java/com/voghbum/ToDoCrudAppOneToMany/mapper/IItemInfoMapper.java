package com.voghbum.ToDoCrudAppOneToMany.mapper;

import com.voghbum.ToDoCrudAppOneToMany.data.entity.Item;
import com.voghbum.ToDoCrudAppOneToMany.dto.ItemInfoDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "ItemInfoMapperImpl", componentModel = "spring")
public interface IItemInfoMapper {
    ItemInfoDTO toItemInfoDTO(Item item);
    Item toItem(ItemInfoDTO itemInfoDTO);
}
