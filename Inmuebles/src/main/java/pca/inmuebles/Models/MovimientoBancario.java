package pca.inmuebles.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "movimientos_bancarios")
public class MovimientoBancario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimiento;

    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private CuentaBancaria cuenta;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoMovimiento tipo;

    private String clasificacion; // GASTO o INGRESO

    @ManyToOne
    @JoinColumn(name = "id_inmueble")
    private Inmueble inmueble;

    @ManyToOne
    @JoinColumn(name = "id_recibo")
    private Recibo recibo; // Opcional: solo si es cobro de recibo

    private LocalDate fecha;
    private Double importe; // Siempre positivo
    private String descripcion;

    // Constructor vacío
    public MovimientoBancario() {
    }

    // Constructor con datos principales
    public MovimientoBancario(CuentaBancaria cuenta, TipoMovimiento tipo,
                              String clasificacion, Inmueble inmueble,
                              LocalDate fecha, Double importe) {
        this.cuenta = cuenta;
        this.tipo = tipo;
        this.clasificacion = clasificacion;
        this.inmueble = inmueble;
        this.fecha = fecha;
        this.importe = importe;
    }

    // Getters y Setters
    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "MovimientoBancario{" +
                "id=" + idMovimiento +
                ", clasificacion='" + clasificacion + '\'' +
                ", fecha=" + fecha +
                ", importe=" + importe +
                '}';
    }
}
