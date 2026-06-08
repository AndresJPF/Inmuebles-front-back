package pca.inmuebles.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pca.inmuebles.models.Inmueble;
import java.util.List;

@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {
    
    // Buscar por tipo (EDIFICIO, PISO, LOCAL)
    List<Inmueble> findByTipo(String tipo);
    
    // Buscar inmuebles activos
    List<Inmueble> findByActivo(Boolean activo);
    
    // Buscar por ciudad
    List<Inmueble> findByCiudad(String ciudad);
    
    // Buscar por código postal
    List<Inmueble> findByCodigoPostal(String codigoPostal);
    
    // Buscar por empresa
    List<Inmueble> findByEmpresaIdEmpresa(Long idEmpresa);
    
    // Buscar pisos/locales de un edificio (padre)
    List<Inmueble> findByPadreIdInmueble(Long idPadre);
}
