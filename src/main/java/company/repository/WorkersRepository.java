package company.repository;

import company.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkersRepository extends JpaRepository<Worker, Integer> {

    Optional<Worker> findById(Integer id);
}
