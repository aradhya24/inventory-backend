package com.inventory.imsbackend.mapper;

import com.inventory.imsbackend.dto.InventoryAssignedToDepartmentDto;
import com.inventory.imsbackend.entity.InventoryAssignedToDepartment;

public class InventoryAssignedToDepartmentMapper {
    public static InventoryAssignedToDepartmentDto mapToInventoryAssignedToDepartmentDto(InventoryAssignedToDepartment inventoryAssignedToDepartment){
        return new InventoryAssignedToDepartmentDto(
                inventoryAssignedToDepartment.getIatdId()  ,inventoryAssignedToDepartment.getInventoryId(),inventoryAssignedToDepartment.getQuantity(),inventoryAssignedToDepartment.getDepartmentName()
        );
    }

    public static InventoryAssignedToDepartment mapToInventoryAssignedToDepartment(InventoryAssignedToDepartmentDto inventoryAssignedToDepartment){
        return new InventoryAssignedToDepartment(
                inventoryAssignedToDepartment.getIatdId()  ,inventoryAssignedToDepartment.getInventoryId(),inventoryAssignedToDepartment.getQuantity(),inventoryAssignedToDepartment.getDepartmentName()
        );
    }
}
