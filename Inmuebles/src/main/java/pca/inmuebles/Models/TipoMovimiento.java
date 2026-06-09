package pca.inmuebles.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipos_movimiento")
public class TipoMovimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipo;

    private String clasificacion; // GASTO o INGRESO
    private String nombre; // Reparación, Limpieza, Cobro recibo, etc.
    private Boolean activo = true;

    // Constructor vacío
    public TipoMovimiento() {
    }

    // Constructor con datos principales
    public TipoMovimiento(String clasificacion, String nombre) {
        this.clasificacion = clasificacion;
        this.nombre = nombre;
        this.activo = true;
    }

    // Getters y Setters
    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "TipoMovimiento{" +
                "id=" + idTipo +
                ", clasificacion='" + clasificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
