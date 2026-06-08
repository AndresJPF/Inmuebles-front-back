package pca.inmuebles.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cuentas_bancarias")
public class CuentaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;

    @ManyToOne
    @JoinColumn(name = "id_banco")
    private Banco banco;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    private String iban;
    private Double saldo = 0.0; // Positivo: acreedor, Negativo: deudor
    private String descripcion;
    private Boolean activa = true;

    // Constructor vacío
    public CuentaBancaria() {
    }

    // Constructor con datos principales
    public CuentaBancaria(Banco banco, Empresa empresa, String iban) {
        this.banco = banco;
        this.empresa = empresa;
        this.iban = iban;
        this.activa = true;
    }

    // Getters y Setters
    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "id=" + idCuenta +
                ", iban='" + iban + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
