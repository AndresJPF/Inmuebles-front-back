package pca.inmuebles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.inmuebles.DAO.InmuebleRepository;
import pca.inmuebles.models.Inmueble;
import java.util.List;
import java.util.Optional;

@Service
public class InmuebleService {

    @Autowired
    private InmuebleRepository inmuebleRepository;

    // Obtener todos los inmuebles
    public List<Inmueble> obtenerTodos() {
        return inmuebleRepository.findAll();
    }

    // Obtener un inmueble por ID
    public Optional<Inmueble> obtenerPorId(Long id) {
        return inmuebleRepository.findById(id);
    }

    // Obtener inmuebles por tipo
    public List<Inmueble> obtenerPorTipo(String tipo) {
        return inmuebleRepository.findByTipo(tipo);
    }

    // Obtener inmuebles activos
    public List<Inmueble> obtenerActivos() {
        return inmuebleRepository.findByActivo(true);
    }

    // Obtener inmuebles por ciudad
    public List<Inmueble> obtenerPorCiudad(String ciudad) {
        return inmuebleRepository.findByCiudad(ciudad);
    }

    // Obtener inmuebles por código postal
    public List<Inmueble> obtenerPorCodigoPostal(String codigoPostal) {
        return inmuebleRepository.findByCodigoPostal(codigoPostal);
    }

    // Obtener inmuebles de una empresa
    public List<Inmueble> obtenerPorEmpresa(Long idEmpresa) {
        return inmuebleRepository.findByEmpresaIdEmpresa(idEmpresa);
    }

    // Obtener pisos/locales de un edificio
    public List<Inmueble> obtenerHijos(Long idPadre) {
        return inmuebleRepository.findByPadreIdInmueble(idPadre);
    }

    // Guardar inmueble
    public Inmueble guardar(Inmueble inmueble) {
        return inmuebleRepository.save(inmueble);
    }

    // Eliminar inmueble
    public void eliminar(Long id) {
        inmuebleRepository.deleteById(id);
    }

    // Verificar si existe
    public Boolean existe(Long id) {
        return inmuebleRepository.existsById(id);
    }

    // Contar total de inmuebles
    public Long contar() {
        return inmuebleRepository.count();
    }
}
