package company.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DepartmentRq {

    private final Integer number;

    private final String direction;

    private final String city;

    @JsonProperty("kpi")
    private final Float kPI;

    @JsonProperty("number_vacancies")
    private final Integer numberVacancies;

}
