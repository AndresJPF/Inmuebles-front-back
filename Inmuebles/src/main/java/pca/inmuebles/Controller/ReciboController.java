package pca.inmuebles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pca.inmuebles.Service.ReciboService;
import pca.inmuebles.models.Recibo;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recibos")
@CrossOrigin(origins = "*")
public class ReciboController {

    @Autowired
    private ReciboService reciboService;

    @GetMapping
    public ResponseEntity<List<Recibo>> obtenerTodos() {
        return ResponseEntity.ok(reciboService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recibo> obtenerPorId(@PathVariable Long id) {
        Optional<Recibo> recibo = reciboService.obtenerPorId(id);
        return recibo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/numero/{numero}")
    public ResponseEntity<Recibo> obtenerPorNumero(@PathVariable String numero) {
        Optional<Recibo> recibo = reciboService.obtenerPorNumero(numero);
        return recibo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/inmueble/{idInmueble}")
    public ResponseEntity<List<Recibo>> obtenerPorInmueble(@PathVariable Long idInmueble) {
        return ResponseEntity.ok(reciboService.obtenerPorInmueble(idInmueble));
    }

    @GetMapping("/cobrados/true")
    public ResponseEntity<List<Recibo>> obtenerCobrados() {
        return ResponseEntity.ok(reciboService.obtenerCobrados());
    }

    @GetMapping("/noCobrados/false")
    public ResponseEntity<List<Recibo>> obtenerNoCobrados() {
        return ResponseEntity.ok(reciboService.obtenerNoCobrados());
    }

    @GetMapping("/periodo/{mes}/{anio}")
    public ResponseEntity<List<Recibo>> obtenerPorPeriodo(@PathVariable Integer mes, @PathVariable Integer anio) {
        return ResponseEntity.ok(reciboService.obtenerPorPeriodo(mes, anio));
    }

    @PostMapping
    public ResponseEntity<Recibo> crear(@RequestBody Recibo recibo) {
        Recibo nuevo = reciboService.guardar(recibo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recibo> actualizar(@PathVariable Long id, @RequestBody Recibo recibo) {
        if (reciboService.existe(id)) {
            recibo.setIdRecibo(id);
            return ResponseEntity.ok(reciboService.guardar(recibo));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (reciboService.existe(id)) {
            reciboService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
