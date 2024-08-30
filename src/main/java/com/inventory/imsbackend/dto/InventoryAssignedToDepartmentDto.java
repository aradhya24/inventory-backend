package com.inventory.imsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryAssignedToDepartmentDto {
    private long iatdId;
    private long inventoryId;
    private long quantity;
    private String departmentName;
}
