package pca.inmuebles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pca.inmuebles.Service.TipoMovimientoService;
import pca.inmuebles.models.TipoMovimiento;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipos-movimiento")
@CrossOrigin(origins = "*")
public class TipoMovimientoController {

    @Autowired
    private TipoMovimientoService tipoService;

    @GetMapping
    public ResponseEntity<List<TipoMovimiento>> obtenerTodos() {
        return ResponseEntity.ok(tipoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoMovimiento> obtenerPorId(@PathVariable Long id) {
        Optional<TipoMovimiento> tipo = tipoService.obtenerPorId(id);
        return tipo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<TipoMovimiento> obtenerPorNombre(@PathVariable String nombre) {
        Optional<TipoMovimiento> tipo = tipoService.obtenerPorNombre(nombre);
        return tipo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/clasificacion/{clasificacion}")
    public ResponseEntity<List<TipoMovimiento>> obtenerPorClasificacion(@PathVariable String clasificacion) {
        return ResponseEntity.ok(tipoService.obtenerPorClasificacion(clasificacion));
    }

    @GetMapping("/activos/true")
    public ResponseEntity<List<TipoMovimiento>> obtenerActivos() {
        return ResponseEntity.ok(tipoService.obtenerActivos());
    }

    @GetMapping("/gastos/activos")
    public ResponseEntity<List<TipoMovimiento>> obtenerGastosActivos() {
        return ResponseEntity.ok(tipoService.obtenerGastosActivos());
    }

    @GetMapping("/ingresos/activos")
    public ResponseEntity<List<TipoMovimiento>> obtenerIngresosActivos() {
        return ResponseEntity.ok(tipoService.obtenerIngresosActivos());
    }

    @PostMapping
    public ResponseEntity<TipoMovimiento> crear(@RequestBody TipoMovimiento tipo) {
        TipoMovimiento nuevo = tipoService.guardar(tipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoMovimiento> actualizar(@PathVariable Long id, @RequestBody TipoMovimiento tipo) {
        if (tipoService.existe(id)) {
            tipo.setIdTipo(id);
            return ResponseEntity.ok(tipoService.guardar(tipo));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (tipoService.existe(id)) {
            tipoService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
