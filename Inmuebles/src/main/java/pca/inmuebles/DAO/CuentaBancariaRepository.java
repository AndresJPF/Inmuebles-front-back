package pca.inmuebles.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pca.inmuebles.models.CuentaBancaria;
import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, Long> {
    
    // Buscar por IBAN (único)
    Optional<CuentaBancaria> findByIban(String iban);
    
    // Buscar cuentas de un banco
    List<CuentaBancaria> findByBancoIdBanco(Long idBanco);
    
    // Buscar cuentas de una empresa
    List<CuentaBancaria> findByEmpresaIdEmpresa(Long idEmpresa);
    
    // Buscar cuentas activas
    List<CuentaBancaria> findByActiva(Boolean activa);
    
    // Buscar cuentas de un banco y empresa
    List<CuentaBancaria> findByBancoIdBancoAndEmpresaIdEmpresa(Long idBanco, Long idEmpresa);
}
