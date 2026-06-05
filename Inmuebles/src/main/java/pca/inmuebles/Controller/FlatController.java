/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pca.inmuebles.Controller;

/**
 *
 * @author aandr
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pca.inmuebles.DTO.Flat;
import pca.inmuebles.Service.FlatService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/flats")
@CrossOrigin(origins = "*")
public class FlatController {
    @Autowired private FlatService flatService;
    
    @GetMapping
    public List<Flat> getAll() { return flatService.findAll(); }
    
    @GetMapping("/{id}")
    public ResponseEntity<Flat> getById(@PathVariable Long id) {
        return flatService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Flat> create(@Valid @RequestBody Flat flat) {
        return ResponseEntity.status(HttpStatus.CREATED).body(flatService.save(flat));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Flat> update(@PathVariable Long id, @Valid @RequestBody Flat flat) {
        if (!flatService.existsById(id)) return ResponseEntity.notFound().build();
        flat.setId(id);
        return ResponseEntity.ok(flatService.save(flat));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!flatService.existsById(id)) return ResponseEntity.notFound().build();
        flatService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/building/{buildingId}")
    public List<Flat> getByBuilding(@PathVariable Long buildingId) {
        return flatService.findByBuildingId(buildingId);
    }
}
