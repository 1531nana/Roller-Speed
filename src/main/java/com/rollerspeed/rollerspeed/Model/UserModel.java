package com.rollerspeed.rollerspeed.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "user_password", length = 20, nullable = false)
    private String password;

    @Column(name = "user_name", length = 30, nullable = false, unique = true)
    private String username;

}

    
    
}