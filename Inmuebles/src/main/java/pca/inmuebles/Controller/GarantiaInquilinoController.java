package pca.inmuebles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pca.inmuebles.Service.GarantiaInquilinoService;
import pca.inmuebles.models.GarantiaInquilino;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/garantias")
@CrossOrigin(origins = "*")
public class GarantiaInquilinoController {

    @Autowired
    private GarantiaInquilinoService garantiaService;

    @GetMapping
    public ResponseEntity<List<GarantiaInquilino>> obtenerTodas() {
        return ResponseEntity.ok(garantiaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GarantiaInquilino> obtenerPorId(@PathVariable Long id) {
        Optional<GarantiaInquilino> garantia = garantiaService.obtenerPorId(id);
        return garantia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/inquilino/{idInquilino}")
    public ResponseEntity<List<GarantiaInquilino>> obtenerPorInquilino(@PathVariable Long idInquilino) {
        return ResponseEntity.ok(garantiaService.obtenerPorInquilino(idInquilino));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<GarantiaInquilino>> obtenerPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(garantiaService.obtenerPorTipo(tipo));
    }

    @GetMapping("/activas/true")
    public ResponseEntity<List<GarantiaInquilino>> obtenerActivas() {
        return ResponseEntity.ok(garantiaService.obtenerActivas());
    }

    @PostMapping
    public ResponseEntity<GarantiaInquilino> crear(@RequestBody GarantiaInquilino garantia) {
        GarantiaInquilino nueva = garantiaService.guardar(garantia);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GarantiaInquilino> actualizar(@PathVariable Long id, @RequestBody GarantiaInquilino garantia) {
        if (garantiaService.existe(id)) {
            garantia.setIdGarantia(id);
            return ResponseEntity.ok(garantiaService.guardar(garantia));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (garantiaService.existe(id)) {
            garantiaService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
