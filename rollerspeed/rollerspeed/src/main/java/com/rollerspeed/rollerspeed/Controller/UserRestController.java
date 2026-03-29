package com.rollerspeed.rollerspeed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

// Nota: Asegúrate de importar correctamente UserModel y UserService
// de acuerdo a los paquetes de tu proyecto una vez creados, ejemplo:
// import com.rollerspeed.rollerspeed.model.UserModel;
// import com.rollerspeed.rollerspeed.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    // Juan Francisco
    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuario por ID", description = "Devuelve los datos de un usuario segun su ID")
    @ApiResponse(responseCode = "200", description = "Usuario encontrado")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public ResponseEntity<UserModel> getUserById(
            @Parameter(description = "ID del usuario a buscar") @PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
