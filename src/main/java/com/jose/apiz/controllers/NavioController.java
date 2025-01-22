package com.jose.apiz.controllers;

import com.jose.apiz.model.Navio;
import com.jose.apiz.repositories.NavioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/navios")
public class NavioController {

    @Autowired
    NavioRepository repository;

    @GetMapping
    public ResponseEntity<List<Navio>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Navio> create(@RequestBody Navio navio) {
        return ResponseEntity.ok(repository.save(navio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Navio> getById(@PathVariable Integer id) {
        Optional<Navio> navio = repository.findById(id);
        return navio.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Navio> update(@PathVariable Integer id, @RequestBody Navio navio) {
        Optional<Navio> existingNavio = repository.findById(id);
        if (existingNavio.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        BeanUtils.copyProperties(navio, existingNavio.get(), "id");
        return ResponseEntity.ok(repository.save(existingNavio.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        Optional<Navio> existingNavio = repository.findById(id);
        if (existingNavio.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Navio não encontrado");
        }
        repository.delete(existingNavio.get());
        return ResponseEntity.ok("Navio deletado com sucesso");
    }
}
