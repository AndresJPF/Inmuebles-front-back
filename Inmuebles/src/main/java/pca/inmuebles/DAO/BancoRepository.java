package pca.inmuebles.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pca.inmuebles.models.Banco;
import java.util.List;
import java.util.Optional;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {
    
    // Buscar por nombre
    Optional<Banco> findByNombre(String nombre);
    
    // Buscar bancos activos
    List<Banco> findByActivo(Boolean activo);
    
    // Buscar por código BIC
    Optional<Banco> findByCodigoBic(String codigoBic);
}
