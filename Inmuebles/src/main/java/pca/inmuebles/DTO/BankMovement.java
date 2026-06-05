package pca.inmuebles.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "bank_movements")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate movementDate;

    @Positive(message = "El monto debe ser positivo")
    private Double amount;

    @NotBlank(message = "El tipo no puede estar vacío")
    @Enumerated(EnumType.STRING)
    private MovementType type; // INGRESO o GASTO

    @NotBlank(message = "La descripción no puede estar vacía")
    private String description;

    @NotBlank(message = "La categoría no puede estar vacía")
    private String category; // Tipo de gasto/ingreso

    @ManyToOne
    @JoinColumn(name = "bank_account_id", nullable = false)
    private BankAccount account;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private Flat flat;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;

    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt; // en caso de ser un ingreso por recibo

    public enum MovementType {
        INGRESO,
        GASTO
    }
}
