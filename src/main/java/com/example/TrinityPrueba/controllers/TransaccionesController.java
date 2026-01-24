package com.example.TrinityPrueba.controllers;

import com.example.TrinityPrueba.dtos.TransaccionesRequestDto;
import com.example.TrinityPrueba.dtos.TransaccionesResponseDto;
import com.example.TrinityPrueba.service.TransaccionesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacciones")
public class TransaccionesController {

    private final TransaccionesService transaccionesService;

    public TransaccionesController(TransaccionesService transaccionesService) {
        this.transaccionesService = transaccionesService;
    }

    @PostMapping
    public ResponseEntity<TransaccionesResponseDto> crear(@RequestBody TransaccionesRequestDto dto) throws Exception {

        TransaccionesResponseDto response = transaccionesService.createTransaccion(dto);

        return ResponseEntity.ok(response);
    }

}
