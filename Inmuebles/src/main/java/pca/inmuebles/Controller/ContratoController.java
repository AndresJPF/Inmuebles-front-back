package pca.inmuebles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pca.inmuebles.Service.ContratoService;
import pca.inmuebles.models.Contrato;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contratos")
@CrossOrigin(origins = "*")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public ResponseEntity<List<Contrato>> obtenerTodos() {
        return ResponseEntity.ok(contratoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> obtenerPorId(@PathVariable Long id) {
        Optional<Contrato> contrato = contratoService.obtenerPorId(id);
        return contrato.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/inquilino/{idInquilino}")
    public ResponseEntity<List<Contrato>> obtenerPorInquilino(@PathVariable Long idInquilino) {
        return ResponseEntity.ok(contratoService.obtenerPorInquilino(idInquilino));
    }

    @GetMapping("/inmueble/{idInmueble}")
    public ResponseEntity<List<Contrato>> obtenerPorInmueble(@PathVariable Long idInmueble) {
        return ResponseEntity.ok(contratoService.obtenerPorInmueble(idInmueble));
    }

    @GetMapping("/activos/true")
    public ResponseEntity<List<Contrato>> obtenerActivos() {
        return ResponseEntity.ok(contratoService.obtenerActivos());
    }

    @PostMapping
    public ResponseEntity<Contrato> crear(@RequestBody Contrato contrato) {
        Contrato nuevo = contratoService.guardar(contrato);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> actualizar(@PathVariable Long id, @RequestBody Contrato contrato) {
        if (contratoService.existe(id)) {
            contrato.setIdContrato(id);
            return ResponseEntity.ok(contratoService.guardar(contrato));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (contratoService.existe(id)) {
            contratoService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
