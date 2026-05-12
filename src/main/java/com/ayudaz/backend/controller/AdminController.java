package com.ayudaz.backend.controller;

import com.ayudaz.backend.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request
    ) {

        if (
                request.getCorreo().equals("admin@ayudaz.com")
                        &&
                        request.getPassword().equals("admin123")
        ) {

            Map<String, String> response =
                    new HashMap<>();

            response.put(
                    "token",
                    "admin-token"
            );

            return ResponseEntity.ok(
                    response
            );
        }

        return ResponseEntity
                .status(401)
                .body("Credenciales inválidas");
    }
}