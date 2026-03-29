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
