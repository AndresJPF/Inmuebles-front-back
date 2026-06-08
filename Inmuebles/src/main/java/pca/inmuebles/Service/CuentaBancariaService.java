package pca.inmuebles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.inmuebles.DAO.CuentaBancariaRepository;
import pca.inmuebles.models.CuentaBancaria;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaBancariaService {

    @Autowired
    private CuentaBancariaRepository cuentaRepository;

    // Obtener todas las cuentas
    public List<CuentaBancaria> obtenerTodas() {
        return cuentaRepository.findAll();
    }

    // Obtener una cuenta por ID
    public Optional<CuentaBancaria> obtenerPorId(Long id) {
        return cuentaRepository.findById(id);
    }

    // Buscar cuenta por IBAN
    public Optional<CuentaBancaria> obtenerPorIban(String iban) {
        return cuentaRepository.findByIban(iban);
    }

    // Obtener cuentas de un banco
    public List<CuentaBancaria> obtenerPorBanco(Long idBanco) {
        return cuentaRepository.findByBancoIdBanco(idBanco);
    }

    // Obtener cuentas de una empresa
    public List<CuentaBancaria> obtenerPorEmpresa(Long idEmpresa) {
        return cuentaRepository.findByEmpresaIdEmpresa(idEmpresa);
    }

    // Obtener cuentas activas
    public List<CuentaBancaria> obtenerActivas() {
        return cuentaRepository.findByActiva(true);
    }

    // Obtener cuentas de un banco y empresa
    public List<CuentaBancaria> obtenerPorBancoYEmpresa(Long idBanco, Long idEmpresa) {
        return cuentaRepository.findByBancoIdBancoAndEmpresaIdEmpresa(idBanco, idEmpresa);
    }

    // Guardar cuenta
    public CuentaBancaria guardar(CuentaBancaria cuenta) {
        return cuentaRepository.save(cuenta);
    }

    // Actualizar saldo
    public CuentaBancaria actualizarSaldo(Long id, Double nuevoSaldo) {
        Optional<CuentaBancaria> cuenta = cuentaRepository.findById(id);
        if (cuenta.isPresent()) {
            CuentaBancaria c = cuenta.get();
            c.setSaldo(nuevoSaldo);
            return cuentaRepository.save(c);
        }
        return null;
    }

    // Eliminar cuenta
    public void eliminar(Long id) {
        cuentaRepository.deleteById(id);
    }

    // Verificar si existe
    public Boolean existe(Long id) {
        return cuentaRepository.existsById(id);
    }

    // Contar total de cuentas
    public Long contar() {
        return cuentaRepository.count();
    }
}
