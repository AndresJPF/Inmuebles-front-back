package pca.inmuebles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pca.inmuebles.Service.EmpresaService;
import pca.inmuebles.models.Empresa;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "*")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    // GET - Obtener todas las empresas
    @GetMapping
    public ResponseEntity<List<Empresa>> obtenerTodas() {
        List<Empresa> empresas = empresaService.obtenerTodas();
        return ResponseEntity.ok(empresas);
    }

    // GET - Obtener una empresa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obtenerPorId(@PathVariable Long id) {
        Optional<Empresa> empresa = empresaService.obtenerPorId(id);
        return empresa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET - Obtener empresas activas
    @GetMapping("/activas/true")
    public ResponseEntity<List<Empresa>> obtenerActivas() {
        List<Empresa> empresas = empresaService.obtenerActivas();
        return ResponseEntity.ok(empresas);
    }

    // GET - Buscar por CIF
    @GetMapping("/cif/{cif}")
    public ResponseEntity<Empresa> obtenerPorCif(@PathVariable String cif) {
        Empresa empresa = empresaService.obtenerPorCif(cif);
        if (empresa != null) {
            return ResponseEntity.ok(empresa);
        }
        return ResponseEntity.notFound().build();
    }

    // GET - Buscar por nombre
    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<List<Empresa>> buscarPorNombre(@PathVariable String nombre) {
        List<Empresa> empresas = empresaService.buscarPorNombre(nombre);
        return ResponseEntity.ok(empresas);
    }

    // POST - Crear empresa
    @PostMapping
    public ResponseEntity<Empresa> crear(@RequestBody Empresa empresa) {
        Empresa nueva = empresaService.guardar(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // PUT - Actualizar empresa
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> actualizar(@PathVariable Long id, @RequestBody Empresa empresa) {
        Optional<Empresa> existente = empresaService.obtenerPorId(id);
        if (existente.isPresent()) {
            empresa.setIdEmpresa(id);
            Empresa actualizada = empresaService.guardar(empresa);
            return ResponseEntity.ok(actualizada);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE - Eliminar empresa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (empresaService.existe(id)) {
            empresaService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // GET - Contar empresas
    @GetMapping("/stats/contar")
    public ResponseEntity<Long> contar() {
        Long total = empresaService.contar();
        return ResponseEntity.ok(total);
    }
}
