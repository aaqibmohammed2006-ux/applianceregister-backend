package com.applianceregister.appliance;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ApplianceService {
    private final ApplianceRepository repository;

    public ApplianceService(ApplianceRepository repository) {
        this.repository = repository;
    }

    public List<Appliance> findAll() {
        return repository.findAll();
    }

    public Appliance create(Appliance appliance) {
        appliance.setId(null);
        return repository.save(appliance);
    }

    public Appliance update(Long id, Appliance incoming) {
        Appliance existing = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Appliance not found"));
        existing.setName(incoming.getName());
        existing.setLabLocation(incoming.getLabLocation());
        existing.setManufacturer(incoming.getManufacturer());
        existing.setModelNumber(incoming.getModelNumber());
        existing.setSampleReading(incoming.getSampleReading());
        existing.setReadingUnit(incoming.getReadingUnit());
        existing.setNotes(incoming.getNotes());
        return repository.save(existing);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Appliance not found");
        }
        repository.deleteById(id);
    }
}
