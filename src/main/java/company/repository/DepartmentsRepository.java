package company.repository;

import company.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentsRepository extends JpaRepository<Department, Integer> {

    Optional<Department> findById(Integer id);

}
