package pca.inmuebles.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pca.inmuebles.models.Contrato;
import java.util.List;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    
    // Buscar contratos de un inquilino
    List<Contrato> findByInquilinoIdInquilino(Long idInquilino);
    
    // Buscar contratos de un inmueble
    List<Contrato> findByInmuebleIdInmueble(Long idInmueble);
    
    // Buscar contratos activos
    List<Contrato> findByActivo(Boolean activo);
    
    // Buscar contratos de un inquilino activos
    List<Contrato> findByInquilinoIdInquilinoAndActivo(Long idInquilino, Boolean activo);
}
