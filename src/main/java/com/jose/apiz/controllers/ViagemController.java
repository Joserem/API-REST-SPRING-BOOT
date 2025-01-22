package com.jose.apiz.controllers;

import com.jose.apiz.model.Viagem;
import com.jose.apiz.repositories.ViagemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/viagens")
public class ViagemController {

    @Autowired
    ViagemRepository repository;

    @GetMapping
    public ResponseEntity<List<Viagem>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Viagem> create(@RequestBody Viagem viagem) {
        return ResponseEntity.ok(repository.save(viagem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viagem> getById(@PathVariable Integer id) {
        Optional<Viagem> viagem = repository.findById(id);
        return viagem.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Viagem> update(@PathVariable Integer id, @RequestBody Viagem viagem) {
        Optional<Viagem> existingViagem = repository.findById(id);
        if (existingViagem.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        BeanUtils.copyProperties(viagem, existingViagem.get(), "id");
        return ResponseEntity.ok(repository.save(existingViagem.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        Optional<Viagem> existingViagem = repository.findById(id);
        if (existingViagem.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Viagem não encontrada");
        }
        repository.delete(existingViagem.get());
        return ResponseEntity.ok("Viagem deletada com sucesso");
    }
}

