package pca.inmuebles.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contratos")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrato;

    @ManyToOne
    @JoinColumn(name = "id_inquilino")
    private Inquilino inquilino;

    @ManyToOne
    @JoinColumn(name = "id_inmueble")
    private Inmueble inmueble;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double rentaMensual;
    private Boolean activo = true;
    private String observaciones;

    // Constructor vacío
    public Contrato() {
    }

    // Constructor con datos principales
    public Contrato(Inquilino inquilino, Inmueble inmueble, LocalDate fechaInicio, Double rentaMensual) {
        this.inquilino = inquilino;
        this.inmueble = inmueble;
        this.fechaInicio = fechaInicio;
        this.rentaMensual = rentaMensual;
        this.activo = true;
    }

    // Getters y Setters
    public Long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getRentaMensual() {
        return rentaMensual;
    }

    public void setRentaMensual(Double rentaMensual) {
        this.rentaMensual = rentaMensual;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id=" + idContrato +
                ", inquilino=" + inquilino +
                ", inmueble=" + inmueble +
                '}';
    }
}
