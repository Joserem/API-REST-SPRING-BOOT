package com.jose.apiz.controllers;

import com.jose.apiz.model.TipoCarga;
import com.jose.apiz.repositories.TipoCargaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipos-carga")
public class TipoCargaController {

    @Autowired
    TipoCargaRepository repository;

    @GetMapping
    public ResponseEntity<List<TipoCarga>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<TipoCarga> create(@RequestBody TipoCarga tipoCarga) {
        return ResponseEntity.ok(repository.save(tipoCarga));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoCarga> getById(@PathVariable Integer id) {
        Optional<TipoCarga> tipoCarga = repository.findById(id);
        return tipoCarga.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoCarga> update(@PathVariable Integer id, @RequestBody TipoCarga tipoCarga) {
        Optional<TipoCarga> existingTipoCarga = repository.findById(id);
        if (existingTipoCarga.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        BeanUtils.copyProperties(tipoCarga, existingTipoCarga.get(), "id");
        return ResponseEntity.ok(repository.save(existingTipoCarga.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        Optional<TipoCarga> existingTipoCarga = repository.findById(id);
        if (existingTipoCarga.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de carga não encontrado");
        }
        repository.delete(existingTipoCarga.get());
        return ResponseEntity.ok("Tipo de carga deletado com sucesso");
    }
}

