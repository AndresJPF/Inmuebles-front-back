package pca.inmuebles.models;

import jakarta.persistence.*;

@Entity
@Table(name = "bancos")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBanco;

    private String nombre;
    private String codigoBic;
    private Boolean activo = true;

    // Constructor vacío
    public Banco() {
    }

    // Constructor con datos principales
    public Banco(String nombre, String codigoBic) {
        this.nombre = nombre;
        this.codigoBic = codigoBic;
        this.activo = true;
    }

    // Getters y Setters
    public Long getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Long idBanco) {
        this.idBanco = idBanco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoBic() {
        return codigoBic;
    }

    public void setCodigoBic(String codigoBic) {
        this.codigoBic = codigoBic;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "id=" + idBanco +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
