package company.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import company.model.Worker;
import lombok.Data;

@Data
public class WorkerRes {

    private String name;

    private String surname;

    private String eMail;

    private String position;

    private Double salary;

    @JsonProperty("department_id")
    private Integer department;

    public WorkerRes(Worker worker){
        this.name = worker.getName();
        this.surname = worker.getSurname();
        this.eMail = worker.getEMail();
        this.position = worker.getPosition();
        this.salary = worker.getSalary();
        this.department = worker.getDepartment().getId();
    }

}
