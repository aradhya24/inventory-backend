package com.inventory.imsbackend.controller;

import com.inventory.imsbackend.dto.InventoryDto;
import com.inventory.imsbackend.services.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin
@RestController //handles the http req
@RequestMapping("/api/inventory")
public class InventoryController {

    private InventoryService inventoryService;

    //Build add login REST API
    @PostMapping
    public ResponseEntity<InventoryDto> createInventory (@RequestBody InventoryDto inventory){
        InventoryDto savedInventory = inventoryService.createInventory(inventory);
        return new ResponseEntity<>(savedInventory , HttpStatus.CREATED);
    }

    //Build get login REST API
    @GetMapping("{id}")
    public ResponseEntity<InventoryDto> getInventoryById(@PathVariable("id") long id){
        InventoryDto inventoryDto = inventoryService.getInventoryById(id);
        return ResponseEntity.ok(inventoryDto);
    }


    @GetMapping("/not/{departmentName}")
    public ResponseEntity<List<InventoryDto>> getNotAssignedInventory(@PathVariable("departmentName") String departmentName){
        List<InventoryDto> inventoryDtos =  inventoryService.getNotAssignedInventory(departmentName);
        return ResponseEntity.ok(inventoryDtos);
    }

    //build getAll inventory REST API
    @GetMapping
    public ResponseEntity<List<InventoryDto>> getAllInventory (){
        List<InventoryDto> inventoryDtos = inventoryService.getAllInventory();
        return ResponseEntity.ok(inventoryDtos);
    }

    // build Update inventory REST API
    @PutMapping("{id}")
    public ResponseEntity<InventoryDto> updateInventory(@PathVariable("id") long id ,
                                                        @RequestBody InventoryDto updatedInvnetory){
        InventoryDto inventoryDto = inventoryService.updateInventory(id , updatedInvnetory);

        return ResponseEntity.ok(inventoryDto);
    }

    //build Delete inventory REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable("id") long id){
        inventoryService.deleteInventoryById(id);
        return ResponseEntity.ok("Inventory Deleted Successfully.....");
    }

}
