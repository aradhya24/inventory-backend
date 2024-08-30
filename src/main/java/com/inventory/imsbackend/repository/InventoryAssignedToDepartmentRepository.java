package com.inventory.imsbackend.repository;

import com.inventory.imsbackend.entity.InventoryAssignedToDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InventoryAssignedToDepartmentRepository extends JpaRepository<InventoryAssignedToDepartment, Long> {
    @Query(value = "SELECT d.dept_id, d.department_name, id.iatd_id , id.assigned_by, id.inventory_id, i.inventory_name, id.quantity " +
            "FROM department d " +
            "JOIN inventories_allocated_department id ON d.dept_id = id.dept_id " +
            "JOIN inventory i ON id.inventory_id = i.inventory_id " +
            "WHERE id.dept_id = :deptId ", nativeQuery = true)
    List<InventoryAssignedToDepartment> findInventoryForDepartment(Long deptId);

//    @Query(value = "SELECT iad.inventory_id, i.inventory_name, i.quantity, iad.iatd_id , iad.assigned_by , iad.dept_id , iad.department_name "  +
//            "FROM inventory i " +
//            "LEFT JOIN inventories_allocated_department iad ON i.inventory_id = iad.inventory_id " +
//            "WHERE iad.dept_id IS NULL OR iad.dept_id <> :deptId ;", nativeQuery = true)
//    List<InventoryAssignedToDepartment> findInventoryNotAssignedToDepartment(Long deptId);
//    //System.out.println("---------------------" + findInventoryNotAssignedToDepartment.get(1);
}

