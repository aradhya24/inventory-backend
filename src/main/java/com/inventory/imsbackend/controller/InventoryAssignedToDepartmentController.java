package com.inventory.imsbackend.controller;



import com.inventory.imsbackend.dto.InventoryAssignedToDepartmentDto;

import com.inventory.imsbackend.dto.InventoryDto;
import com.inventory.imsbackend.entity.InventoryAssignedToDepartment;
import com.inventory.imsbackend.services.InventoryAssignedToDepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
//@NoArgsConstructor
@CrossOrigin
@RestController //handles the http req
@RequestMapping("/api/departmentallocatedinventory")
public class InventoryAssignedToDepartmentController {
    private InventoryAssignedToDepartmentService inventoryAssignedToDepartmentService;


    @PostMapping
    public ResponseEntity<InventoryAssignedToDepartmentDto> createInventory (@RequestBody InventoryAssignedToDepartmentDto inventory){
        InventoryAssignedToDepartmentDto savedInventory = inventoryAssignedToDepartmentService.createInventoryAssignedToDepartment(inventory);
        return new ResponseEntity<>(savedInventory , HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<List<InventoryAssignedToDepartmentDto>> getAllInventoryAssignedToDepartment(@PathVariable("id") long deptId){
        List<InventoryAssignedToDepartmentDto> departmentDtos = inventoryAssignedToDepartmentService.getAllDepartmentAllocatedInventories(deptId);
        return ResponseEntity.ok(departmentDtos);
    }

//    @GetMapping("/not/{id}")
//    public ResponseEntity<List<InventoryAssignedToDepartmentDto>> getAllInventoryNotAssignedToDepartment(@PathVariable("id") long deptId){
//        System.out.println("------------fgjdfgj---------"   +deptId);
//        List<InventoryAssignedToDepartmentDto> departmentDtos = inventoryAssignedToDepartmentService.getInventoryNotAssignedToDepartment(deptId);
//        if (!departmentDtos.isEmpty()) {
//            InventoryAssignedToDepartmentDto inventoryAssignedToDepartment = departmentDtos.get(0);
//            Long iatdId = inventoryAssignedToDepartment.getIatdId();
//            System.out.println("---------------------" + iatdId);
//        } else {
//            System.out.println("list is empty------------------------------------------");
//        }
//        return ResponseEntity.ok(departmentDtos);
//    }


    // build Update inventory REST API
    @PutMapping("{id}")
    public ResponseEntity<InventoryAssignedToDepartmentDto> updateInventory(@PathVariable("id") long id ,
                                                        @RequestBody InventoryAssignedToDepartmentDto updatedInvnetory){
        InventoryAssignedToDepartmentDto inventoryDto = inventoryAssignedToDepartmentService.updateInventory(id , updatedInvnetory);

        return ResponseEntity.ok(inventoryDto);
    }

    //delete query
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable("id") long id){
        inventoryAssignedToDepartmentService.deleteInventoryById(id);
        return ResponseEntity.ok("Inventory Deleted Successfully.....");
    }




}
