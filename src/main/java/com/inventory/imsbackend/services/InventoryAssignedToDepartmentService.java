package com.inventory.imsbackend.services;

import com.inventory.imsbackend.dto.DepartmentDto;
import com.inventory.imsbackend.dto.InventoryAssignedToDepartmentDto;
import com.inventory.imsbackend.dto.InventoryDto;
import com.inventory.imsbackend.exception.ResourceNotFoundException;

import java.util.List;

public interface InventoryAssignedToDepartmentService  {
    List<InventoryAssignedToDepartmentDto> getAllDepartmentAllocatedInventories(long deptId);
   // List<InventoryAssignedToDepartmentDto> getInventoryNotAssignedToDepartment(long deptId);


    InventoryAssignedToDepartmentDto createInventoryAssignedToDepartment(InventoryAssignedToDepartmentDto inventoryAssignedToDepartmentDto);

    InventoryAssignedToDepartmentDto updateInventory(long id , InventoryAssignedToDepartmentDto inventoryDto);

    void deleteInventoryById(long id);
}
