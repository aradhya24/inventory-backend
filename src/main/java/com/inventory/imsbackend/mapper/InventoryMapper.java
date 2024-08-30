package com.inventory.imsbackend.mapper;

import com.inventory.imsbackend.dto.InventoryDto;
import com.inventory.imsbackend.entity.Inventory;

public class InventoryMapper {

    public static InventoryDto mapToInventoryDto(Inventory inventory){
        return new InventoryDto(
                inventory.getInventoryId(), inventory.getInventoryName(), inventory.getQuantity()
        );
    }

    public static Inventory mapToInventory(InventoryDto inventory){
        return new Inventory(
                inventory.getInventoryId(), inventory.getInventoryName(), inventory.getQuantity()
        );
    }

}
