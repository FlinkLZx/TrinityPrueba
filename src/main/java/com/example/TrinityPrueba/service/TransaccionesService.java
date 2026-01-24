package com.example.TrinityPrueba.service;

import com.example.TrinityPrueba.dtos.TransaccionesRequestDto;
import com.example.TrinityPrueba.dtos.TransaccionesResponseDto;

public interface TransaccionesService {

    TransaccionesResponseDto createTransaccion(TransaccionesRequestDto dto) throws Exception;

}
