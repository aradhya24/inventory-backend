package com.inventory.imsbackend.mapper;
import com.inventory.imsbackend.dto.DepartmentDto;
import com.inventory.imsbackend.entity.Department;


public class DepartmentMapper {
    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getDeptId(), department.getDepartmentName()
        );
    }

    public static Department mapToDepartment(DepartmentDto department){
        return new Department(
                department.getDeptId(), department.getDepartmentName()
        );
    }

}
