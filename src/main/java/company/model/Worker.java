package company.model;

import company.dto.request.WorkerRq;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "workers")
public class Worker {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    @Column(name = "e_mail")
    private String eMail;

    private String position;

    private Double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Worker(WorkerRq workerRq) {
        this.name = workerRq.getName();
        this.surname = workerRq.getSurname();
        this.eMail = workerRq.getEMail();
        this.position = workerRq.getPosition();
        this.salary = workerRq.getSalary();
    }
}
