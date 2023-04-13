package company.model;

import company.dto.request.DepartmentRq;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;

    private String direction;

    private String city;

    @Column(name = "kpi")
    private Float kPI;

    @Column(name = "number_vacancies")
    private Integer numberVacancies;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Worker> workers = new ArrayList<>();


    public Department(DepartmentRq departmentRq) {
        this.number = departmentRq.getNumber();
        this.direction = departmentRq.getDirection();
        this.city = departmentRq.getCity();
        this.kPI = departmentRq.getKPI();
        this.numberVacancies = departmentRq.getNumberVacancies();
    }
}
