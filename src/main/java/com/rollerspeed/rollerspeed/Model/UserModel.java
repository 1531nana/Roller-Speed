package com.rollerspeed.rollerspeed.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Schema(description = "Representa a un usuario registrado en Roller Speed")
@Entity
@Table(name = "tbl_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @Schema(description = "ID unico del usuario", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Nombre de usuario unico", example = "juan_patinador")
    @Column(name = "user_name", length = 40, nullable = false, unique = true)
    private String username;

    @Schema(description = "Correo electronico del usuario", example = "juan@rollerspeed.com")
    @Column(name = "user_email", length = 100, nullable = false, unique = true)
    private String email;

    @Schema(description = "Contrasena del usuario", example = "pass123")
    @Column(name = "user_password", length = 20, nullable = false)
    private String password;

}
