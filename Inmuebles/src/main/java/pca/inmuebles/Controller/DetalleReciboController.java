package pca.inmuebles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pca.inmuebles.Service.DetalleReciboService;
import pca.inmuebles.models.DetalleRecibo;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalles-recibo")
@CrossOrigin(origins = "*")
public class DetalleReciboController {

    @Autowired
    private DetalleReciboService detalleService;

    @GetMapping
    public ResponseEntity<List<DetalleRecibo>> obtenerTodos() {
        return ResponseEntity.ok(detalleService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleRecibo> obtenerPorId(@PathVariable Long id) {
        Optional<DetalleRecibo> detalle = detalleService.obtenerPorId(id);
        return detalle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/recibo/{idRecibo}")
    public ResponseEntity<List<DetalleRecibo>> obtenerPorRecibo(@PathVariable Long idRecibo) {
        return ResponseEntity.ok(detalleService.obtenerPorRecibo(idRecibo));
    }

    @GetMapping("/concepto/{idConcepto}")
    public ResponseEntity<List<DetalleRecibo>> obtenerPorConcepto(@PathVariable Long idConcepto) {
        return ResponseEntity.ok(detalleService.obtenerPorConcepto(idConcepto));
    }

    @PostMapping
    public ResponseEntity<DetalleRecibo> crear(@RequestBody DetalleRecibo detalle) {
        DetalleRecibo nuevo = detalleService.guardar(detalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleRecibo> actualizar(@PathVariable Long id, @RequestBody DetalleRecibo detalle) {
        if (detalleService.existe(id)) {
            detalle.setIdDetalle(id);
            return ResponseEntity.ok(detalleService.guardar(detalle));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (detalleService.existe(id)) {
            detalleService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
