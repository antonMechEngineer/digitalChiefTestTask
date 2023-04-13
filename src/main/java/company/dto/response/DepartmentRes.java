package company.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import company.model.Department;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DepartmentRes {

    private final Integer number;

    private final String direction;

    private final String city;

    private final Float kPI;

    @JsonProperty("number_vacancies")
    private final Integer numberVacancies;

    private final List<WorkerRes> workers;

    public DepartmentRes(Department department) {
        this.number = department.getNumber();
        this.direction = department.getDirection();
        this.city = department.getCity();
        this.kPI = department.getKPI();
        this.numberVacancies = department.getNumberVacancies();
        this.workers = department.getWorkers().stream().map(WorkerRes::new).collect(Collectors.toList());
    }



}
