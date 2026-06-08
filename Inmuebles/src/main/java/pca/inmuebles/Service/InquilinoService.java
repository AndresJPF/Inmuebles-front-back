package pca.inmuebles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.inmuebles.DAO.InquilinoRepository;
import pca.inmuebles.models.Inquilino;
import java.util.List;
import java.util.Optional;

@Service
public class InquilinoService {

    @Autowired
    private InquilinoRepository inquilinoRepository;

    // Obtener todos los inquilinos
    public List<Inquilino> obtenerTodos() {
        return inquilinoRepository.findAll();
    }

    // Obtener un inquilino por ID
    public Optional<Inquilino> obtenerPorId(Long id) {
        return inquilinoRepository.findById(id);
    }

    // Buscar inquilino por DNI
    public Optional<Inquilino> obtenerPorDni(String dni) {
        return inquilinoRepository.findByDni(dni);
    }

    // Obtener inquilinos activos
    public List<Inquilino> obtenerActivos() {
        return inquilinoRepository.findByActivo(true);
    }

    // Buscar por nombre
    public List<Inquilino> buscarPorNombre(String nombre) {
        return inquilinoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    // Buscar por apellidos
    public List<Inquilino> buscarPorApellidos(String apellidos) {
        return inquilinoRepository.findByApellidosContainingIgnoreCase(apellidos);
    }

    // Buscar por email
    public Optional<Inquilino> obtenerPorEmail(String email) {
        return inquilinoRepository.findByEmail(email);
    }

    // Guardar inquilino
    public Inquilino guardar(Inquilino inquilino) {
        return inquilinoRepository.save(inquilino);
    }

    // Eliminar inquilino
    public void eliminar(Long id) {
        inquilinoRepository.deleteById(id);
    }

    // Verificar si existe
    public Boolean existe(Long id) {
        return inquilinoRepository.existsById(id);
    }

    // Contar total de inquilinos
    public Long contar() {
        return inquilinoRepository.count();
    }
}
