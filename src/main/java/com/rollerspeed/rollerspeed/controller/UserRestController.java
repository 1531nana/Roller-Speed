package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.Model.UserModel;
import com.rollerspeed.rollerspeed.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion de Usuarios", description = "API para crear, consultar, actualizar y eliminar usuarios de Roller Speed")
@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping
    @Operation(summary = "Listar todos los usuarios", description = "Devuelve una lista con todos los usuarios registrados en el sistema")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con exito")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }
}

@PutMapping("/{id}")
@Operation(
    summary = "Actualizar un usuario existente",
    description = "Recibe un JSON con los nuevos datos y actualiza el usuario indicado por ID"
)
@ApiResponse(responseCode = "200", description = "Usuario actualizado correctamente")
@ApiResponse(responseCode = "400", description = "Datos inválidos")
@ApiResponse(responseCode = "404", description = "Usuario no encontrado")
public ResponseEntity<?> updateUser(
        @Parameter(description = "ID del usuario a actualizar")
        @PathVariable Long id,
        @RequestBody UserModel userDetails) {

    try {
        UserModel updated = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updated);
    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
