package com.inventory.imsbackend.services.impl;

import com.inventory.imsbackend.dto.InventoryAssignedToDepartmentDto;
import com.inventory.imsbackend.entity.InventoryAssignedToDepartment;
import com.inventory.imsbackend.exception.NullException;
import com.inventory.imsbackend.exception.ResourceNotFoundException;
import com.inventory.imsbackend.mapper.InventoryAssignedToDepartmentMapper;
import com.inventory.imsbackend.repository.InventoryAssignedToDepartmentRepository;
import com.inventory.imsbackend.services.InventoryAssignedToDepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InventoryAssignedToDepartmentImpl implements InventoryAssignedToDepartmentService  {

   private InventoryAssignedToDepartmentRepository inventoryAssignedToDepartmentRepository;
//    public InventoryAssignedToDepartmentImpl(InventoryAssignedToDepartmentRepository inventoryAssignedToDepartmentRepository) {
//       this.inventoryAssignedToDepartmentRepository = inventoryAssignedToDepartmentRepository;
//    }
    @Override
    public List<InventoryAssignedToDepartmentDto> getAllDepartmentAllocatedInventories(long deptId) {
        List<InventoryAssignedToDepartment> departmentsAllocated = inventoryAssignedToDepartmentRepository.findInventoryForDepartment(deptId);
        System.out.println("---------------------" + departmentsAllocated.get(1));

        return departmentsAllocated.stream().map(InventoryAssignedToDepartmentMapper::mapToInventoryAssignedToDepartmentDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<InventoryAssignedToDepartmentDto> getInventoryNotAssignedToDepartment(long deptId) {
//        List<InventoryAssignedToDepartment> departmentsAllocated = inventoryAssignedToDepartmentRepository.findInventoryNotAssignedToDepartment(deptId);
//        System.out.println("---------------------" + departmentsAllocated.get(1));
//
//        for (InventoryAssignedToDepartment inventoryAssignedToDepartment : departmentsAllocated) {
//            if (inventoryAssignedToDepartment != null) {
//                Long iatdId = inventoryAssignedToDepartment.getIatdId();
//                System.out.println("---------------------" + iatdId);
//            } else {
//                throw new NullException("Encountered a null InventoryAssignedToDepartment object");
//            }
//        }
//        return departmentsAllocated.stream().map(InventoryAssignedToDepartmentMapper::mapToInventoryAssignedToDepartmentDto)
//                .collect(Collectors.toList());
//    }

    @Override
    public InventoryAssignedToDepartmentDto createInventoryAssignedToDepartment(InventoryAssignedToDepartmentDto inventoryAssignedToDepartmentDto) {
        InventoryAssignedToDepartment inventory = InventoryAssignedToDepartmentMapper.mapToInventoryAssignedToDepartment(inventoryAssignedToDepartmentDto);
        InventoryAssignedToDepartment savedInventory = inventoryAssignedToDepartmentRepository.save(inventory);
        return InventoryAssignedToDepartmentMapper.mapToInventoryAssignedToDepartmentDto(savedInventory);
    }

    @Override
    public InventoryAssignedToDepartmentDto updateInventory(long id, InventoryAssignedToDepartmentDto updatedInventories) {
        InventoryAssignedToDepartment inventory = inventoryAssignedToDepartmentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Inventory Not Exist by Given ID" + id)) ;

        //inventory.setInventoryName(updatedInventories.getInventoryName());
        inventory.setQuantity(updatedInventories.getQuantity());
        InventoryAssignedToDepartment updatedInventoryObj = inventoryAssignedToDepartmentRepository.save(inventory);

        return InventoryAssignedToDepartmentMapper.mapToInventoryAssignedToDepartmentDto(updatedInventoryObj);
    }


    @Override
    public void deleteInventoryById(long id) {
        InventoryAssignedToDepartment inventory = inventoryAssignedToDepartmentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Inventory not exist by Id : " + id));

        inventoryAssignedToDepartmentRepository.deleteById(id);
    }


}
