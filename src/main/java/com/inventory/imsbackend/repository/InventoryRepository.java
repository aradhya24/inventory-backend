package com.inventory.imsbackend.repository;

import com.inventory.imsbackend.entity.Inventory;
import com.inventory.imsbackend.entity.InventoryAssignedToDepartment;
import com.inventory.imsbackend.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @Modifying
    @Query(value = "INSERT INTO inventory (inventory_id, inventory_name, quantity) " +
            "VALUES (:inventoryId, :inventoryName, :quantity) " +
            "ON DUPLICATE KEY UPDATE " +
            "inventory_name = VALUES(inventory_name), " +
            "quantity = quantity + VALUES(quantity)",
            nativeQuery = true)
    void insertOrUpdateInventory(long inventoryId, String inventoryName, int quantity);

//    @Query(value = "SELECT i.inventory_id, i.inventory_name, i.quantity " +
//            "FROM inventory_db.inventory i " +
//            "JOIN inventory_db.inventories_allocated_department iad " +
//            "    ON i.inventory_id = iad.inventory_id " +
//            "WHERE iad.department_name IS NULL OR iad.department_name <> :departmentName ", nativeQuery = true)
//    List<Inventory> findInventoryNotAssignedToDepartment(String departmentName);

    @Query(value = "SELECT i.inventory_id, i.inventory_name, i.quantity " +
            "FROM inventory_db.inventory i " +
            "LEFT JOIN inventory_db.inventories_allocated_department iad " +
            "ON i.inventory_id = iad.inventory_id " +
            "WHERE COALESCE(iad.department_name, '') <> COALESCE(:departmentName, '')", nativeQuery = true)
    List<Inventory> findInventoryNotAssignedToDepartment(@Param("departmentName") String departmentName);


}
