package pca.inmuebles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pca.inmuebles.Service.CuentaBancariaService;
import pca.inmuebles.models.CuentaBancaria;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cuentas")
@CrossOrigin(origins = "*")
public class CuentaBancariaController {

    @Autowired
    private CuentaBancariaService cuentaService;

    @GetMapping
    public ResponseEntity<List<CuentaBancaria>> obtenerTodas() {
        return ResponseEntity.ok(cuentaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaBancaria> obtenerPorId(@PathVariable Long id) {
        Optional<CuentaBancaria> cuenta = cuentaService.obtenerPorId(id);
        return cuenta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/iban/{iban}")
    public ResponseEntity<CuentaBancaria> obtenerPorIban(@PathVariable String iban) {
        Optional<CuentaBancaria> cuenta = cuentaService.obtenerPorIban(iban);
        return cuenta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/banco/{idBanco}")
    public ResponseEntity<List<CuentaBancaria>> obtenerPorBanco(@PathVariable Long idBanco) {
        return ResponseEntity.ok(cuentaService.obtenerPorBanco(idBanco));
    }

    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<CuentaBancaria>> obtenerPorEmpresa(@PathVariable Long idEmpresa) {
        return ResponseEntity.ok(cuentaService.obtenerPorEmpresa(idEmpresa));
    }

    @GetMapping("/activas/true")
    public ResponseEntity<List<CuentaBancaria>> obtenerActivas() {
        return ResponseEntity.ok(cuentaService.obtenerActivas());
    }

    @PostMapping
    public ResponseEntity<CuentaBancaria> crear(@RequestBody CuentaBancaria cuenta) {
        CuentaBancaria nueva = cuentaService.guardar(cuenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuentaBancaria> actualizar(@PathVariable Long id, @RequestBody CuentaBancaria cuenta) {
        if (cuentaService.existe(id)) {
            cuenta.setIdCuenta(id);
            return ResponseEntity.ok(cuentaService.guardar(cuenta));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (cuentaService.existe(id)) {
            cuentaService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
