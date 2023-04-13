package company.service;

import company.dto.request.WorkerRq;
import company.dto.response.WorkerRes;
import company.model.Department;
import company.model.Worker;
import company.repository.DepartmentsRepository;
import company.repository.WorkersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkersRepository workersRepository;
    private final DepartmentsRepository departmentsRepository;

    public WorkerRes getWorker(Integer id){
        Worker worker = workersRepository.findById(id).orElseThrow();
        return new WorkerRes(worker);
    }

    public List<WorkerRes> getWorkers(){
        List<Worker> workers = workersRepository.findAll();
        return workers.stream().map(WorkerRes::new).collect(Collectors.toList());
    }

    public WorkerRes deleteWorker(Integer id){
        Worker worker = workersRepository.findById(id).orElseThrow();
        WorkerRes workerRes = new WorkerRes(worker);
        workersRepository.delete(worker);
        return workerRes;
    }

    public List<WorkerRes> deleteWorkers(){
        List<Worker> Workers = workersRepository.findAll();
        List<WorkerRes> resWorkers = Workers.stream().map(WorkerRes::new).collect(Collectors.toList());
        workersRepository.deleteAll();
        return resWorkers;
    }

    public WorkerRes createWorker(WorkerRq workerRq){
        Department department = departmentsRepository.findById(workerRq.getDepartmentId()).orElseThrow();
        Worker worker = new Worker(workerRq);
        worker.setDepartment(department);
        workersRepository.save(worker);
        return new WorkerRes(worker);

    }

    public WorkerRes updateWorker(Integer id, WorkerRq workerRq){
        Worker worker = workersRepository.findById(id).orElseThrow();
        worker.setName(workerRq.getName());
        worker.setSurname(workerRq.getSurname());
        worker.setEMail(workerRq.getEMail());
        worker.setPosition(workerRq.getPosition());
        worker.setSalary(workerRq.getSalary());
        workersRepository.save(worker);
        return new WorkerRes(worker);
    
}}
