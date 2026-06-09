package pca.inmuebles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pca.inmuebles.Service.CatalogoConceptoService;
import pca.inmuebles.models.CatalogoConcepto;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conceptos")
@CrossOrigin(origins = "*")
public class CatalogoConceptoController {

    @Autowired
    private CatalogoConceptoService conceptoService;

    @GetMapping
    public ResponseEntity<List<CatalogoConcepto>> obtenerTodos() {
        return ResponseEntity.ok(conceptoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatalogoConcepto> obtenerPorId(@PathVariable Long id) {
        Optional<CatalogoConcepto> concepto = conceptoService.obtenerPorId(id);
        return concepto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<CatalogoConcepto> obtenerPorNombre(@PathVariable String nombre) {
        Optional<CatalogoConcepto> concepto = conceptoService.obtenerPorNombre(nombre);
        return concepto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/obligatorios/true")
    public ResponseEntity<List<CatalogoConcepto>> obtenerObligatorios() {
        return ResponseEntity.ok(conceptoService.obtenerObligatorios());
    }

    @GetMapping("/activos/true")
    public ResponseEntity<List<CatalogoConcepto>> obtenerActivos() {
        return ResponseEntity.ok(conceptoService.obtenerActivos());
    }

    @GetMapping("/iva/true")
    public ResponseEntity<List<CatalogoConcepto>> obtenerConIva() {
        return ResponseEntity.ok(conceptoService.obtenerConIva());
    }

    @PostMapping
    public ResponseEntity<CatalogoConcepto> crear(@RequestBody CatalogoConcepto concepto) {
        CatalogoConcepto nuevo = conceptoService.guardar(concepto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatalogoConcepto> actualizar(@PathVariable Long id, @RequestBody CatalogoConcepto concepto) {
        if (conceptoService.existe(id)) {
            concepto.setIdConcepto(id);
            return ResponseEntity.ok(conceptoService.guardar(concepto));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (conceptoService.existe(id)) {
            conceptoService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
