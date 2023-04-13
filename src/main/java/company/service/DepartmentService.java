package company.service;
import company.dto.request.DepartmentRq;
import company.dto.response.DepartmentRes;
import company.model.Department;
import company.repository.DepartmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentsRepository departmentsRepository;

    public DepartmentRes getDepartment(Integer id){
        Department department = departmentsRepository.findById(id).orElseThrow();
        System.out.println(department.getWorkers());
        return new DepartmentRes(department);
    }

    public List<DepartmentRes> getDepartments(){
        List<Department> departments = departmentsRepository.findAll();
        return departments.stream().map(DepartmentRes::new).collect(Collectors.toList());
    }

    public DepartmentRes deleteDepartment(Integer id){
        Department department = departmentsRepository.findById(id).orElseThrow();
        DepartmentRes resDepartment = new DepartmentRes(department);
        departmentsRepository.delete(department);
        return resDepartment;
    }

    public List<DepartmentRes> deleteDepartments(){
        List<Department> departments = departmentsRepository.findAll();
        List<DepartmentRes> resDepartments = departments.stream().map(DepartmentRes::new).collect(Collectors.toList());
        departmentsRepository.deleteAll();
        return resDepartments;
    }

    public DepartmentRes createDepartment(DepartmentRq departmentRq){
        Department department = new Department(departmentRq);
        departmentsRepository.save(department);
        return new DepartmentRes(new Department());
    }

    public DepartmentRes updateDepartment(Integer id, DepartmentRq departmentRq){
        Department department = departmentsRepository.findById(id).orElseThrow();
        department.setNumber(departmentRq.getNumber());
        department.setDirection(departmentRq.getDirection());
        department.setCity(departmentRq.getCity());
        department.setKPI(departmentRq.getKPI());
        department.setNumber(departmentRq.getNumberVacancies());
        departmentsRepository.save(department);
        return new DepartmentRes(department);
    }
}
