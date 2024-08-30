package com.inventory.imsbackend.controller;



import com.inventory.imsbackend.services.DepartmentService;
import com.inventory.imsbackend.dto.DepartmentDto;
import org.springframework.http.ResponseEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@AllArgsConstructor
//@NoArgsConstructor
@CrossOrigin
@RestController //handles the http req
@RequestMapping("/api/department")
public class DepartmentController {

   private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments (){
        List<DepartmentDto> departmentDtos = departmentService.getAllDepartment();
        return ResponseEntity.ok(departmentDtos);
    }


}
