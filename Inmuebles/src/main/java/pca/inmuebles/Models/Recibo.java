package pca.inmuebles.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "recibos")
public class Recibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecibo;

    private String numeroRecibo; // Número único del recibo

    @ManyToOne
    @JoinColumn(name = "id_inmueble")
    private Inmueble inmueble;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato contrato;

    private LocalDate fechaEmision;
    private Integer periodoMes; // 1-12
    private Integer periodoAnio;
    private Boolean cobrado = false;
    private LocalDate fechaCobro;
    private String observaciones;

    // Constructor vacío
    public Recibo() {
    }

    // Constructor con datos principales
    public Recibo(String numeroRecibo, Inmueble inmueble, Contrato contrato,
                  LocalDate fechaEmision, Integer periodoMes, Integer periodoAnio) {
        this.numeroRecibo = numeroRecibo;
        this.inmueble = inmueble;
        this.contrato = contrato;
        this.fechaEmision = fechaEmision;
        this.periodoMes = periodoMes;
        this.periodoAnio = periodoAnio;
        this.cobrado = false;
    }

    // Getters y Setters
    public Long getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(Long idRecibo) {
        this.idRecibo = idRecibo;
    }

    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Integer getPeriodoMes() {
        return periodoMes;
    }

    public void setPeriodoMes(Integer periodoMes) {
        this.periodoMes = periodoMes;
    }

    public Integer getPeriodoAnio() {
        return periodoAnio;
    }

    public void setPeriodoAnio(Integer periodoAnio) {
        this.periodoAnio = periodoAnio;
    }

    public Boolean getCobrado() {
        return cobrado;
    }

    public void setCobrado(Boolean cobrado) {
        this.cobrado = cobrado;
    }

    public LocalDate getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(LocalDate fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Recibo{" +
                "id=" + idRecibo +
                ", numero='" + numeroRecibo + '\'' +
                ", periodo=" + periodoMes + "/" + periodoAnio +
                '}';
    }
}
