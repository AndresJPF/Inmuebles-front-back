/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pca.inmuebles;

/**
 *
 * @author aandr
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
 
@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "API Gestión de Inmuebles",
        version = "1.0.0",
        description = "Sistema de gestión de fincas, inmuebles, inquilinos y movimientos bancarios"
    )
)
public class Inmuebles {
 
    public static void main(String[] args) {
        SpringApplication.run(Inmuebles.class, args);
    }
}
