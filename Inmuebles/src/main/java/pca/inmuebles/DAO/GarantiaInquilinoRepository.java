package pca.inmuebles.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pca.inmuebles.models.GarantiaInquilino;
import java.util.List;

@Repository
public interface GarantiaInquilinoRepository extends JpaRepository<GarantiaInquilino, Long> {
    
    // Buscar garantías de un inquilino
    List<GarantiaInquilino> findByInquilinoIdInquilino(Long idInquilino);
    
    // Buscar por tipo de garantía
    List<GarantiaInquilino> findByTipoGarantia(String tipoGarantia);
    
    // Buscar garantías activas
    List<GarantiaInquilino> findByActiva(Boolean activa);
}
