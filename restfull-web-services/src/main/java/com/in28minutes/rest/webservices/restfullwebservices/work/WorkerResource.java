package com.in28minutes.rest.webservices.restfullwebservices.work;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class WorkerResource {

    @Autowired
    WorkerDaoService workerDaoService;

    @Autowired
    WorkerV2DaoService workerV2DaoService;

    @GetMapping("/workers")
    public List<Worker> retriveAllWorkers() {
        return workerDaoService.findAll();
    }

    @GetMapping(value = "/workers/{id}", produces="application/vnd.company.app-v1+json")
    public Worker retriveWorkerUseProduces(@PathVariable int id) {
        Worker worker = workerDaoService.findOne(id);
        if (worker == null)
            throw new WorkerNotFoundException(String.format("Worker with id '%s' not found", id));
        return worker;
    }

    @GetMapping(value = "/workers/{id}", produces="application/vnd.company.app-v2+json")
    public WorkerV2 retriveWorkerUseProducesV2(@PathVariable int id) {
        WorkerV2 worker = workerV2DaoService.findOne(id);
        if (worker == null)
            throw new WorkerNotFoundException(String.format("Worker with id '%s' not found", id));
        return worker;
    }

    @GetMapping(value = "/workers/{id}", headers="X-API-VERSION=1")
    public Worker retriveWorkerUseHeaders(@PathVariable int id) {
        Worker worker = workerDaoService.findOne(id);
        if (worker == null)
            throw new WorkerNotFoundException(String.format("Worker with id '%s' not found", id));
        return worker;
    }

    @GetMapping(value = "/workers/{id}", headers="X-API-VERSION=2")
    public WorkerV2 retriveWorkerUseHeadersV2(@PathVariable int id) {
        WorkerV2 worker = workerV2DaoService.findOne(id);
        if (worker == null)
            throw new WorkerNotFoundException(String.format("Worker with id '%s' not found", id));
        return worker;
    }

    @GetMapping(value = "/workers/{id}", params = "version=1")
    @ApiOperation(httpMethod = "GET",notes = "retrive worker by using params by version", value = "retriveWorker")
    public WorkerV2 retriveWorker(@PathVariable int id) {
        WorkerV2 worker = workerV2DaoService.findOne(id);
        if (worker == null)
            throw new WorkerNotFoundException(String.format("Worker with id '%s' not found", id));
        return worker;
    }

    @GetMapping(value = "/workers/{id}", params = "version=2")

    public WorkerV2 retriveWorkerV2(@PathVariable int id) {
        WorkerV2 worker = workerV2DaoService.findOne(id);
        if (worker == null)
            throw new WorkerNotFoundException(String.format("Worker with id '%s' not found", id));
        return worker;
    }


    @DeleteMapping("/workers/{id}")
    public void deleteWorker(@PathVariable int id) {
        Worker worker = workerDaoService.findOne(id);
        if (worker == null)
            throw new WorkerNotFoundException(String.format("Worker with id '%s' not found", id));
		Worker worker2 = workerDaoService.deleteById(id);
     }

    @PostMapping("/workers")
    public ResponseEntity<Object> createWorker(@Valid @RequestBody Worker worker) {
        Worker newWorker = workerDaoService.Save(worker);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}").buildAndExpand(newWorker.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


}
