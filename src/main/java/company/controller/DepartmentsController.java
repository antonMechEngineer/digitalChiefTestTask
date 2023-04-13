package company.controller;

import company.dto.request.DepartmentRq;
import company.dto.response.DepartmentRes;
import company.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentsController {

    private final DepartmentService departmentService;

    @PostMapping("/")
    public DepartmentRes createDepartment(@RequestBody DepartmentRq departmentRq){
        return departmentService.createDepartment(departmentRq);
    }

    @PutMapping("/{id}")
    public DepartmentRes updateDepartment(@PathVariable Integer id,
                                          @RequestBody DepartmentRq departmentRq){
        return departmentService.updateDepartment(id, departmentRq);
    }

    @GetMapping("/")
    public List<DepartmentRes> getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentRes getDepartment(@PathVariable Integer id){
        return departmentService.getDepartment(id);
    }

    @DeleteMapping("/{id}")
    public DepartmentRes deleteDepartment(@PathVariable Integer id){
         return departmentService.deleteDepartment(id);
    }

    @DeleteMapping("/")
    public List<DepartmentRes> deleteDepartments(){
        return departmentService.deleteDepartments();
    }

}
