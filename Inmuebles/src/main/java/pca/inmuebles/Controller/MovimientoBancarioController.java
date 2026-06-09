package pca.inmuebles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pca.inmuebles.Service.MovimientoBancarioService;
import pca.inmuebles.models.MovimientoBancario;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimientos")
@CrossOrigin(origins = "*")
public class MovimientoBancarioController {

    @Autowired
    private MovimientoBancarioService movimientoService;

    @GetMapping
    public ResponseEntity<List<MovimientoBancario>> obtenerTodos() {
        return ResponseEntity.ok(movimientoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoBancario> obtenerPorId(@PathVariable Long id) {
        Optional<MovimientoBancario> movimiento = movimientoService.obtenerPorId(id);
        return movimiento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/cuenta/{idCuenta}")
    public ResponseEntity<List<MovimientoBancario>> obtenerPorCuenta(@PathVariable Long idCuenta) {
        return ResponseEntity.ok(movimientoService.obtenerPorCuenta(idCuenta));
    }

    @GetMapping("/inmueble/{idInmueble}")
    public ResponseEntity<List<MovimientoBancario>> obtenerPorInmueble(@PathVariable Long idInmueble) {
        return ResponseEntity.ok(movimientoService.obtenerPorInmueble(idInmueble));
    }

    @GetMapping("/clasificacion/{clasificacion}")
    public ResponseEntity<List<MovimientoBancario>> obtenerPorClasificacion(@PathVariable String clasificacion) {
        return ResponseEntity.ok(movimientoService.obtenerPorClasificacion(clasificacion));
    }

    @GetMapping("/gastos")
    public ResponseEntity<List<MovimientoBancario>> obtenerGastos() {
        return ResponseEntity.ok(movimientoService.obtenerGastos());
    }

    @GetMapping("/ingresos")
    public ResponseEntity<List<MovimientoBancario>> obtenerIngresos() {
        return ResponseEntity.ok(movimientoService.obtenerIngresos());
    }

    @GetMapping("/inmueble/{idInmueble}/gastos")
    public ResponseEntity<List<MovimientoBancario>> obtenerGastosPorInmueble(@PathVariable Long idInmueble) {
        return ResponseEntity.ok(movimientoService.obtenerGastosPorInmueble(idInmueble));
    }

    @GetMapping("/inmueble/{idInmueble}/ingresos")
    public ResponseEntity<List<MovimientoBancario>> obtenerIngresosPorInmueble(@PathVariable Long idInmueble) {
        return ResponseEntity.ok(movimientoService.obtenerIngresosPorInmueble(idInmueble));
    }

    @PostMapping
    public ResponseEntity<MovimientoBancario> crear(@RequestBody MovimientoBancario movimiento) {
        MovimientoBancario nuevo = movimientoService.guardar(movimiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimientoBancario> actualizar(@PathVariable Long id, @RequestBody MovimientoBancario movimiento) {
        if (movimientoService.existe(id)) {
            movimiento.setIdMovimiento(id);
            return ResponseEntity.ok(movimientoService.guardar(movimiento));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (movimientoService.existe(id)) {
            movimientoService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
