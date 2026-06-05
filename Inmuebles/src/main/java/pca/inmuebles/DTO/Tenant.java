package pca.inmuebles.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tenants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotBlank(message = "El DNI no puede estar vacío")
    @Column(unique = true)
    private String dni;

    @Positive(message = "La edad debe ser positiva")
    private Integer age;

    @NotBlank(message = "El género no puede estar vacío")
    private String gender; // "M", "F", "Otro"

    private String phone;

    @Email(message = "El email debe ser válido")
    private String email;

    private String photoPath; // ruta de la fotografía

    @NotBlank(message = "El tipo de aval no puede estar vacío")
    private String guaranteeType; // "Nómina", "Aval bancario", "Contrato trabajo", "Persona"

    private String guaranteeDetails; // detalles del aval

    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;

    private boolean active = true;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private List<Receipt> receipts;
}
