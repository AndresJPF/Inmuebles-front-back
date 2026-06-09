package pca.inmuebles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pca.inmuebles.Service.BancoService;
import pca.inmuebles.models.Banco;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bancos")
@CrossOrigin(origins = "*")
public class BancoController {

    @Autowired
    private BancoService bancoService;

    @GetMapping
    public ResponseEntity<List<Banco>> obtenerTodos() {
        return ResponseEntity.ok(bancoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banco> obtenerPorId(@PathVariable Long id) {
        Optional<Banco> banco = bancoService.obtenerPorId(id);
        return banco.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Banco> obtenerPorNombre(@PathVariable String nombre) {
        Optional<Banco> banco = bancoService.obtenerPorNombre(nombre);
        return banco.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/activos/true")
    public ResponseEntity<List<Banco>> obtenerActivos() {
        return ResponseEntity.ok(bancoService.obtenerActivos());
    }

    @PostMapping
    public ResponseEntity<Banco> crear(@RequestBody Banco banco) {
        Banco nuevo = bancoService.guardar(banco);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Banco> actualizar(@PathVariable Long id, @RequestBody Banco banco) {
        if (bancoService.existe(id)) {
            banco.setIdBanco(id);
            return ResponseEntity.ok(bancoService.guardar(banco));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (bancoService.existe(id)) {
            bancoService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
