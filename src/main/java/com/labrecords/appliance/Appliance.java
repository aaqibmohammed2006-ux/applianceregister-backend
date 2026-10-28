package com.applianceregister.appliance;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "appliances")
public class Appliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Appliance name is required")
    @Size(max = 120, message = "Name must be 120 characters or fewer")
    @Column(nullable = false, length = 120)
    private String name;

    @NotBlank(message = "Lab location is required")
    @Size(max = 120, message = "Lab location must be 120 characters or fewer")
    @Column(nullable = false, length = 120)
    private String labLocation;

    @Size(max = 120)
    private String manufacturer;

    @Size(max = 120)
    private String modelNumber;

    private Double sampleReading;

    @Size(max = 40)
    private String readingUnit;

    @Size(max = 1000)
    @Column(length = 1000)
    private String notes;

    public Appliance() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLabLocation() { return labLocation; }
    public void setLabLocation(String labLocation) { this.labLocation = labLocation; }
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public String getModelNumber() { return modelNumber; }
    public void setModelNumber(String modelNumber) { this.modelNumber = modelNumber; }
    public Double getSampleReading() { return sampleReading; }
    public void setSampleReading(Double sampleReading) { this.sampleReading = sampleReading; }
    public String getReadingUnit() { return readingUnit; }
    public void setReadingUnit(String readingUnit) { this.readingUnit = readingUnit; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
