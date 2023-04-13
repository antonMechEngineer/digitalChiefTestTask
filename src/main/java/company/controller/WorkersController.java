package company.controller;
import company.dto.request.WorkerRq;
import company.dto.response.WorkerRes;
import company.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workers")
public class WorkersController {

    private final WorkerService workerService;

    @PostMapping("/")
    public WorkerRes createWorker(@RequestBody WorkerRq workerRq) {
        return workerService.createWorker(workerRq);
    }

    @PutMapping("/{id}")
    public WorkerRes updateWorker(@PathVariable Integer id,
                                  @RequestBody WorkerRq workerRq) {
        return workerService.updateWorker(id, workerRq);
    }

    @GetMapping("/")
    public List<WorkerRes> getWorkers() {
        return workerService.getWorkers();
    }

    @GetMapping("/{id}")
    public WorkerRes getWorker(@PathVariable Integer id) {
        return workerService.getWorker(id);
    }

    @DeleteMapping("/{id}")
    public WorkerRes deleteWorker(@PathVariable Integer id) {
        return workerService.deleteWorker(id);
    }

    @DeleteMapping("/")
    public List<WorkerRes> deleteWorkers() {
        return workerService.deleteWorkers();

    }
}
