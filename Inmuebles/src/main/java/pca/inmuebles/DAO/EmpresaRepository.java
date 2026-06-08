package pca.inmuebles.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pca.inmuebles.models.Empresa;
import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    
    // Buscar empresas activas
    List<Empresa> findByActiva(Boolean activa);
    
    // Buscar por CIF
    Empresa findByCif(String cif);
    
    // Buscar por nombre
    List<Empresa> findByNombreContainingIgnoreCase(String nombre);
}
