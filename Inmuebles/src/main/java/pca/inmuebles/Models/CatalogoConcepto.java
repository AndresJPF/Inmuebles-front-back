package pca.inmuebles.models;

import jakarta.persistence.*;

@Entity
@Table(name = "catalogo_conceptos")
public class CatalogoConcepto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConcepto;

    private String nombre; // Renta, Agua, Luz, IVA, etc.
    private Boolean obligatorio = false;
    private Boolean aplicaIva = false;
    private Boolean activo = true;

    // Constructor vacío
    public CatalogoConcepto() {
    }

    // Constructor con datos principales
    public CatalogoConcepto(String nombre, Boolean obligatorio) {
        this.nombre = nombre;
        this.obligatorio = obligatorio;
        this.activo = true;
    }

    // Getters y Setters
    public Long getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Long idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(Boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    public Boolean getAplicaIva() {
        return aplicaIva;
    }

    public void setAplicaIva(Boolean aplicaIva) {
        this.aplicaIva = aplicaIva;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "CatalogoConcepto{" +
                "id=" + idConcepto +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
