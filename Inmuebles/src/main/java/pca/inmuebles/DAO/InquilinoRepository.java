package pca.inmuebles.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pca.inmuebles.models.Inquilino;
import java.util.List;
import java.util.Optional;

@Repository
public interface InquilinoRepository extends JpaRepository<Inquilino, Long> {
    
    // Buscar por DNI (único)
    Optional<Inquilino> findByDni(String dni);
    
    // Buscar inquilinos activos
    List<Inquilino> findByActivo(Boolean activo);
    
    // Buscar por nombre
    List<Inquilino> findByNombreContainingIgnoreCase(String nombre);
    
    // Buscar por apellidos
    List<Inquilino> findByApellidosContainingIgnoreCase(String apellidos);
    
    // Buscar por email
    Optional<Inquilino> findByEmail(String email);
}
