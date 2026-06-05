package pca.inmuebles.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "receipts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String receiptNumber; // número único del recibo

    private LocalDate issueDate;
    private LocalDate dueDate;

    @Positive(message = "La renta debe ser positiva")
    private Double rent = 0.0;

    @Positive(message = "El agua debe ser positivo")
    private Double water = 0.0;

    @Positive(message = "La luz debe ser positiva")
    private Double electricity = 0.0;

    @Positive(message = "La portería debe ser positiva")
    private Double porterage = 0.0; // gastos de portería

    @Positive(message = "El IPC debe ser positivo")
    private Double ipc = 0.0; // actualización IPC anual

    @Positive(message = "El IVA debe ser positivo")
    private Double vat = 0.0; // IVA

    private Double otherConcepts = 0.0; // otros conceptos

    private boolean paid = false;
    private LocalDate paymentDate;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private Flat flat;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    public Double getTotalAmount() {
        return rent + water + electricity + porterage + ipc + vat + otherConcepts;
    }
}
