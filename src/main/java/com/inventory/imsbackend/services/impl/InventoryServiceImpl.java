package com.inventory.imsbackend.services.impl;

import com.inventory.imsbackend.dto.InventoryDto;
import com.inventory.imsbackend.entity.Inventory;
import com.inventory.imsbackend.exception.ResourceNotFoundException;
import com.inventory.imsbackend.mapper.InventoryMapper;
import com.inventory.imsbackend.repository.InventoryRepository;
import com.inventory.imsbackend.services.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryRepository inventoryRepository;
    @Override
    public InventoryDto createInventory(InventoryDto inventoryDto) {
        Inventory inventory = InventoryMapper.mapToInventory(inventoryDto);
        Inventory savedInventory = inventoryRepository.save(inventory);
        return InventoryMapper.mapToInventoryDto(savedInventory);
    }

    @Override
    public InventoryDto getInventoryById(long id) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist by given ID : "+ id));
        return InventoryMapper.mapToInventoryDto(inventory);
    }

    @Override
    public List<InventoryDto> getAllInventory() {
        List<Inventory> inventories = inventoryRepository.findAll();

        return inventories.stream().map((inventory)-> InventoryMapper.mapToInventoryDto(inventory))
                .collect(Collectors.toList());
    }

    @Override
    public List<InventoryDto> getNotAssignedInventory(String departmentName) {
        List<Inventory> inventories = inventoryRepository.findInventoryNotAssignedToDepartment(departmentName);
        System.out.println("___--____________--"+departmentName);
        int i = 0;
        for (Inventory inventory : inventories) {
            System.out.println(i+inventory.getInventoryName());
            i++;
        }

        return inventories.stream().map((inventory)-> InventoryMapper.mapToInventoryDto(inventory))
                .collect(Collectors.toList());
    }

    @Override
    public InventoryDto updateInventory(long id, InventoryDto updatedInventories) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Inventory Not Exist by Given ID" + id)) ;

        inventory.setInventoryName(updatedInventories.getInventoryName());
        inventory.setQuantity(updatedInventories.getQuantity());
        Inventory updatedInventoryObj = inventoryRepository.save(inventory);

        return InventoryMapper.mapToInventoryDto(updatedInventoryObj);
    }

    @Override
    public void deleteInventoryById(long id) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Inventory not exist by Id : " + id));

        inventoryRepository.deleteById(id);
    }
}
