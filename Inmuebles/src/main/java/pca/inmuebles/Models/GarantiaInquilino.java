package pca.inmuebles.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "garantias_inquilino")
public class GarantiaInquilino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGarantia;

    @ManyToOne
    @JoinColumn(name = "id_inquilino")
    private Inquilino inquilino;

    private String tipoGarantia; // NOMINA, AVAL_BANCARIO, CONTRATO_TRABAJO, AVALISTA
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_avalista")
    private Inquilino avalista;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean activa = true;

    // Constructor vacío
    public GarantiaInquilino() {
    }

    // Constructor con datos principales
    public GarantiaInquilino(Inquilino inquilino, String tipoGarantia) {
        this.inquilino = inquilino;
        this.tipoGarantia = tipoGarantia;
        this.activa = true;
    }

    // Getters y Setters
    public Long getIdGarantia() {
        return idGarantia;
    }

    public void setIdGarantia(Long idGarantia) {
        this.idGarantia = idGarantia;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public String getTipoGarantia() {
        return tipoGarantia;
    }

    public void setTipoGarantia(String tipoGarantia) {
        this.tipoGarantia = tipoGarantia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Inquilino getAvalista() {
        return avalista;
    }

    public void setAvalista(Inquilino avalista) {
        this.avalista = avalista;
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

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    @Override
    public String toString() {
        return "GarantiaInquilino{" +
                "id=" + idGarantia +
                ", tipo='" + tipoGarantia + '\'' +
                '}';
    }
}
