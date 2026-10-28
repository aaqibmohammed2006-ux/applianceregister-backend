package com.applianceregister.appliance;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appliances")
public class ApplianceController {
    private final ApplianceService service;

    public ApplianceController(ApplianceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Appliance> getAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Appliance create(@Valid @RequestBody Appliance appliance) {
        return service.create(appliance);
    }

    @PutMapping("/{id}")
    public Appliance update(@PathVariable Long id, @Valid @RequestBody Appliance appliance) {
        return service.update(id, appliance);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
