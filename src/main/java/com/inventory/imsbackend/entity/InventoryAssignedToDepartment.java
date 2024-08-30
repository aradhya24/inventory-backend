package com.inventory.imsbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties
@Table(name = "inventories_allocated_department")
public class InventoryAssignedToDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long iatdId;

    @Column(name = "inventory_id")
    private long inventoryId;


    @Column(name = "quantity")
    private long quantity;

    @Column(name = "department_name")
    private String departmentName;

}
