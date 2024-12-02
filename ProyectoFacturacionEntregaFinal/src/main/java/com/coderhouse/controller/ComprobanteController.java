package com.coderhouse.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dtos.ComprobanteDTO;
import com.coderhouse.services.ComprobanteService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/comprobante")
@RequiredArgsConstructor
public class ComprobanteController {

    private final ComprobanteService comprobanteService;

    @PostMapping
    public ResponseEntity<ComprobanteDTO> crearComprobante(
            @RequestParam Long clienteId,
            @RequestBody List<Long> pedidoIds) {
        ComprobanteDTO comprobante = comprobanteService.crearComprobante(clienteId, pedidoIds);
        return ResponseEntity.status(HttpStatus.CREATED).body(comprobante);
    }

    @GetMapping
    public ResponseEntity<List<ComprobanteDTO>> listarComprobantes() {
        return ResponseEntity.ok(comprobanteService.listarComprobantes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComprobanteDTO> obtenerComprobantePorId(@PathVariable Long id) {
        return ResponseEntity.ok(comprobanteService.obtenerComprobantePorId(id));
    }
}
