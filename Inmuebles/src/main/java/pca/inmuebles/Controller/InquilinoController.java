package pca.inmuebles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pca.inmuebles.Service.InquilinoService;
import pca.inmuebles.models.Inquilino;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inquilinos")
@CrossOrigin(origins = "*")
public class InquilinoController {

    @Autowired
    private InquilinoService inquilinoService;

    @GetMapping
    public ResponseEntity<List<Inquilino>> obtenerTodos() {
        return ResponseEntity.ok(inquilinoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inquilino> obtenerPorId(@PathVariable Long id) {
        Optional<Inquilino> inquilino = inquilinoService.obtenerPorId(id);
        return inquilino.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Inquilino> obtenerPorDni(@PathVariable String dni) {
        Optional<Inquilino> inquilino = inquilinoService.obtenerPorDni(dni);
        return inquilino.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/activos/true")
    public ResponseEntity<List<Inquilino>> obtenerActivos() {
        return ResponseEntity.ok(inquilinoService.obtenerActivos());
    }

    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity<List<Inquilino>> buscarPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(inquilinoService.buscarPorNombre(nombre));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Inquilino> obtenerPorEmail(@PathVariable String email) {
        Optional<Inquilino> inquilino = inquilinoService.obtenerPorEmail(email);
        return inquilino.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Inquilino> crear(@RequestBody Inquilino inquilino) {
        Inquilino nuevo = inquilinoService.guardar(inquilino);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inquilino> actualizar(@PathVariable Long id, @RequestBody Inquilino inquilino) {
        if (inquilinoService.existe(id)) {
            inquilino.setIdInquilino(id);
            return ResponseEntity.ok(inquilinoService.guardar(inquilino));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (inquilinoService.existe(id)) {
            inquilinoService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
