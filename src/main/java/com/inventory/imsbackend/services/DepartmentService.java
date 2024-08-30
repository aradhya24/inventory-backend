package com.inventory.imsbackend.services;

import com.inventory.imsbackend.dto.DepartmentDto;


import java.util.List;


public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(long deptId);
    List<DepartmentDto> getAllDepartment();
    DepartmentDto updateDepartment(long deptId , DepartmentDto departmentDto);
    void deleteDepartmentById(long deptId);


    //

}
