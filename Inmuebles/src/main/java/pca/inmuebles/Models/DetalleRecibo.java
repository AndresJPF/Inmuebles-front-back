package pca.inmuebles.models;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_recibo")
public class DetalleRecibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_recibo")
    private Recibo recibo;

    @ManyToOne
    @JoinColumn(name = "id_concepto")
    private CatalogoConcepto concepto;

    private Double importe = 0.0;
    private Integer ordenImpresion = 0;

    // Constructor vacío
    public DetalleRecibo() {
    }

    // Constructor con datos principales
    public DetalleRecibo(Recibo recibo, CatalogoConcepto concepto, Double importe) {
        this.recibo = recibo;
        this.concepto = concepto;
        this.importe = importe;
    }

    // Getters y Setters
    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }

    public CatalogoConcepto getConcepto() {
        return concepto;
    }

    public void setConcepto(CatalogoConcepto concepto) {
        this.concepto = concepto;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Integer getOrdenImpresion() {
        return ordenImpresion;
    }

    public void setOrdenImpresion(Integer ordenImpresion) {
        this.ordenImpresion = ordenImpresion;
    }

    @Override
    public String toString() {
        return "DetalleRecibo{" +
                "id=" + idDetalle +
                ", concepto=" + concepto +
                ", importe=" + importe +
                '}';
    }
}
