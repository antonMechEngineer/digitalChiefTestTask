package company.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WorkerRq {

    private String name;

    private String surname;

    private String eMail;

    private String position;

    private Double salary;

    @JsonProperty("department_id")
    private Integer departmentId;

}
