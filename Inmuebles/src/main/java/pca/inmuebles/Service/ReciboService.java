package pca.inmuebles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.inmuebles.DAO.ReciboRepository;
import pca.inmuebles.models.Recibo;
import java.util.List;
import java.util.Optional;

@Service
public class ReciboService {

    @Autowired
    private ReciboRepository reciboRepository;

    // Obtener todos los recibos
    public List<Recibo> obtenerTodos() {
        return reciboRepository.findAll();
    }

    // Obtener un recibo por ID
    public Optional<Recibo> obtenerPorId(Long id) {
        return reciboRepository.findById(id);
    }

    // Buscar recibo por número
    public Optional<Recibo> obtenerPorNumero(String numeroRecibo) {
        return reciboRepository.findByNumeroRecibo(numeroRecibo);
    }

    // Obtener recibos de un inmueble
    public List<Recibo> obtenerPorInmueble(Long idInmueble) {
        return reciboRepository.findByInmuebleIdInmueble(idInmueble);
    }

    // Obtener recibos de un contrato
    public List<Recibo> obtenerPorContrato(Long idContrato) {
        return reciboRepository.findByContratoIdContrato(idContrato);
    }

    // Obtener recibos cobrados
    public List<Recibo> obtenerCobrados() {
        return reciboRepository.findByCobrado(true);
    }

    // Obtener recibos no cobrados
    public List<Recibo> obtenerNoCobrados() {
        return reciboRepository.findByCobradoFalse();
    }

    // Obtener recibos de un período
    public List<Recibo> obtenerPorPeriodo(Integer mes, Integer anio) {
        return reciboRepository.findByPeriodoMesAndPeriodoAnio(mes, anio);
    }

    // Obtener recibos de un inmueble en un período
    public List<Recibo> obtenerPorInmuebleYPeriodo(Long idInmueble, Integer mes, Integer anio) {
        return reciboRepository.findByInmuebleIdInmuebleAndPeriodoMesAndPeriodoAnio(idInmueble, mes, anio);
    }

    // Guardar recibo
    public Recibo guardar(Recibo recibo) {
        return reciboRepository.save(recibo);
    }

    // Marcar recibo como cobrado
    //public Recibo marcarComo Cobrado(Long id, LocalDate fechaCobro) {
    //    Optional<Recibo> recibo = reciboRepository.findById(id);
    //    if (recibo.isPresent()) {
    //        Recibo r = recibo.get();
    //        r.setCobrado(true);
    //        r.setFechaCobro(fechaCobro);
    //        return reciboRepository.save(r);
    //    }
    //    return null;
    //}

    // Eliminar recibo
    public void eliminar(Long id) {
        reciboRepository.deleteById(id);
    }

    // Verificar si existe
    public Boolean existe(Long id) {
        return reciboRepository.existsById(id);
    }

    // Contar total de recibos
    public Long contar() {
        return reciboRepository.count();
    }
}
