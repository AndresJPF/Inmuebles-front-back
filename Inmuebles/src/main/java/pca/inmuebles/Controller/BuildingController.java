package pca.inmuebles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pca.inmuebles.DTO.Building;
import pca.inmuebles.Service.BuildingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buildings")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Buildings", description = "API para gestión de edificios e inmuebles")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    /**
     * Obtiene todos los edificios
     */
    @GetMapping
    @Operation(summary = "Obtener todos los edificios", description = "Retorna la lista completa de edificios registrados")
    @ApiResponse(responseCode = "200", description = "Lista de edificios obtenida exitosamente")
    public ResponseEntity<List<Building>> getAll() {
        List<Building> buildings = buildingService.findAll();
        return ResponseEntity.ok(buildings);
    }

    /**
     * Obtiene un edificio por ID
     * @return 
     */
    @GetMapping("/{id}")
    @Operation(summary = "Obtener un edificio por ID", description = "Retorna los detalles de un edificio específico")
    @ApiResponse(responseCode = "200", description = "Edificio encontrado")
    @ApiResponse(responseCode = "404", description = "Edificio no encontrado")
    public ResponseEntity<Building> getById(
            @Parameter(description = "ID del edificio") @PathVariable Long id) {
        Optional<Building> building = buildingService.findById(id);
        return building.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Busca edificios por ciudad
     * @param city
     * @return 
     */
    @GetMapping("/search/city/{city}")
    @Operation(summary = "Buscar edificios por ciudad", description = "Retorna edificios de una ciudad específica")
    @ApiResponse(responseCode = "200", description = "Búsqueda realizada")
    public ResponseEntity<List<Building>> findByCity(
            @Parameter(description = "Nombre de la ciudad") @PathVariable String city) {
        List<Building> buildings = buildingService.findByCity(city);
        return ResponseEntity.ok(buildings);
    }

    /**
     * Busca edificios por código postal
     * @param postalCode
     * @return 
     */
    @GetMapping("/search/postal/{postalCode}")
    @Operation(summary = "Buscar edificios por código postal", description = "Retorna edificios con un código postal específico")
    @ApiResponse(responseCode = "200", description = "Búsqueda realizada")
    public ResponseEntity<List<Building>> findByPostalCode(
            @Parameter(description = "Código postal") @PathVariable String postalCode) {
        List<Building> buildings = buildingService.findByPostalCode(postalCode);
        return ResponseEntity.ok(buildings);
    }

    /**
     * Crea un nuevo edificio
     * @param building
     * @param bindingResult
     * @return 
     */
    @PostMapping
    @Operation(summary = "Crear un nuevo edificio", description = "Registra un nuevo edificio en el sistema")
    @ApiResponse(responseCode = "201", description = "Edificio creado exitosamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    public ResponseEntity<?> create(
            @Valid @RequestBody Building building,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Errores de validación: " + bindingResult.getAllErrors());
        }
        Building savedBuilding = buildingService.save(building);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBuilding);
    }

    /**
     * Actualiza un edificio existente
     * @param id
     * @param building
     * @param bindingResult
     * @return 
     */
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un edificio", description = "Modifica los datos de un edificio existente")
    @ApiResponse(responseCode = "200", description = "Edificio actualizado exitosamente")
    @ApiResponse(responseCode = "404", description = "Edificio no encontrado")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    public ResponseEntity<?> update(
            @Parameter(description = "ID del edificio") @PathVariable Long id,
            @Valid @RequestBody Building building,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Errores de validación: " + bindingResult.getAllErrors());
        }

        Optional<Building> existingBuilding = buildingService.findById(id);
        if (existingBuilding.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Building buildingToUpdate = existingBuilding.get();
        buildingToUpdate.setAddress(building.getAddress());
        buildingToUpdate.setNumber(building.getNumber());
        buildingToUpdate.setPostalCode(building.getPostalCode());
        buildingToUpdate.setCity(building.getCity());
        buildingToUpdate.setProvince(building.getProvince());

        Building updatedBuilding = buildingService.save(buildingToUpdate);
        return ResponseEntity.ok(updatedBuilding);
    }

    /**
     * Elimina un edificio
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un edificio", description = "Borra un edificio del sistema")
    @ApiResponse(responseCode = "204", description = "Edificio eliminado exitosamente")
    @ApiResponse(responseCode = "404", description = "Edificio no encontrado")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID del edificio") @PathVariable Long id) {
        if (!buildingService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        buildingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Obtiene el total de edificios
     * @return 
     */
    @GetMapping("/stats/count")
    @Operation(summary = "Contar edificios", description = "Retorna el número total de edificios en el sistema")
    @ApiResponse(responseCode = "200", description = "Conteo realizado")
    public ResponseEntity<Long> count() {
        long total = buildingService.count();
        return ResponseEntity.ok(total);
    }
}
