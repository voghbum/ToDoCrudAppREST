package com.voghbum.ToDoCrudAppOneToMany.controller;

import com.voghbum.ToDoCrudAppOneToMany.dto.ItemInfoDTO;
import com.voghbum.ToDoCrudAppOneToMany.dto.ItemSaveDTO;
import com.voghbum.ToDoCrudAppOneToMany.service.TodoApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/item")
public class ItemController {
    private final TodoApplicationService m_todoApplicationService;

    public ItemController(TodoApplicationService todoApplicationService) {
        m_todoApplicationService = todoApplicationService;
    }

    @PostMapping("save")
    public ItemInfoDTO saveItem(@RequestBody ItemSaveDTO itemSaveDTO) {
        return m_todoApplicationService.saveItem(itemSaveDTO);
    }
}
