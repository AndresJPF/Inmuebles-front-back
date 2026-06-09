package pca.inmuebles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pca.inmuebles.Service.InmuebleService;
import pca.inmuebles.models.Inmueble;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inmuebles")
@CrossOrigin(origins = "*")
public class InmuebleController {

    @Autowired
    private InmuebleService inmuebleService;

    @GetMapping
    public ResponseEntity<List<Inmueble>> obtenerTodos() {
        return ResponseEntity.ok(inmuebleService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inmueble> obtenerPorId(@PathVariable Long id) {
        Optional<Inmueble> inmueble = inmuebleService.obtenerPorId(id);
        return inmueble.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Inmueble>> obtenerPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(inmuebleService.obtenerPorTipo(tipo));
    }

    @GetMapping("/ciudad/{ciudad}")
    public ResponseEntity<List<Inmueble>> obtenerPorCiudad(@PathVariable String ciudad) {
        return ResponseEntity.ok(inmuebleService.obtenerPorCiudad(ciudad));
    }

    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<Inmueble>> obtenerPorEmpresa(@PathVariable Long idEmpresa) {
        return ResponseEntity.ok(inmuebleService.obtenerPorEmpresa(idEmpresa));
    }

    @GetMapping("/{idPadre}/hijos")
    public ResponseEntity<List<Inmueble>> obtenerHijos(@PathVariable Long idPadre) {
        return ResponseEntity.ok(inmuebleService.obtenerHijos(idPadre));
    }

    @PostMapping
    public ResponseEntity<Inmueble> crear(@RequestBody Inmueble inmueble) {
        Inmueble nuevo = inmuebleService.guardar(inmueble);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inmueble> actualizar(@PathVariable Long id, @RequestBody Inmueble inmueble) {
        if (inmuebleService.existe(id)) {
            inmueble.setIdInmueble(id);
            return ResponseEntity.ok(inmuebleService.guardar(inmueble));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (inmuebleService.existe(id)) {
            inmuebleService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
