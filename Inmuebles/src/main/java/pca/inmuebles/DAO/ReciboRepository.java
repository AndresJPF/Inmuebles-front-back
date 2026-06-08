package pca.inmuebles.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pca.inmuebles.models.Recibo;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Long> {
    
    // Buscar por número de recibo
    Optional<Recibo> findByNumeroRecibo(String numeroRecibo);
    
    // Buscar recibos de un inmueble
    List<Recibo> findByInmuebleIdInmueble(Long idInmueble);
    
    // Buscar recibos de un contrato
    List<Recibo> findByContratoIdContrato(Long idContrato);
    
    // Buscar recibos cobrados
    List<Recibo> findByCobrado(Boolean cobrado);
    
    // Buscar recibos de un período
    List<Recibo> findByPeriodoMesAndPeriodoAnio(Integer mes, Integer anio);
    
    // Buscar recibos de un inmueble en un período
    List<Recibo> findByInmuebleIdInmuebleAndPeriodoMesAndPeriodoAnio(Long idInmueble, Integer mes, Integer anio);
    
    // Buscar recibos no cobrados
    List<Recibo> findByCobradoFalse();
}
