package com.inventory.imsbackend.services.impl;

import com.inventory.imsbackend.dto.DepartmentDto;
import com.inventory.imsbackend.entity.Department;
import com.inventory.imsbackend.mapper.DepartmentMapper;
import com.inventory.imsbackend.repository.DepartmentRepository;
import com.inventory.imsbackend.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        return null;
    }

    @Override
    public DepartmentDto getDepartmentById(long deptId) {
        return null;
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(DepartmentMapper::mapToDepartmentDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(long deptId, DepartmentDto departmentDto) {
        return null;
    }

    @Override
    public void deleteDepartmentById(long deptId) {

    }


}
