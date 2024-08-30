package com.inventory.imsbackend.services;

import com.inventory.imsbackend.dto.InventoryDto;
import com.inventory.imsbackend.dto.LoginDto;

import java.util.List;

public interface InventoryService {
    InventoryDto createInventory(InventoryDto inventoryDto);
    InventoryDto getInventoryById(long id);
    List<InventoryDto> getAllInventory();

    List<InventoryDto> getNotAssignedInventory(String departmentName);
    InventoryDto updateInventory(long id , InventoryDto inventoryDto);
    void deleteInventoryById(long id);
}
