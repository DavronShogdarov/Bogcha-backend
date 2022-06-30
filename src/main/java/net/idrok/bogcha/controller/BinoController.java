package net.idrok.bogcha.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.idrok.bogcha.entity.Bino;
import net.idrok.bogcha.service.BinoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/bino")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class BinoController {

    @Autowired
    BinoService bs;

    @GetMapping()
    public ResponseEntity<Page<Bino>> getall(@RequestParam(name = "key", required = false) String key,
            Pageable pageable) {

        if (key == null)
            key = "";
        return ResponseEntity.ok(bs.getall(key, pageable));
    }

    @PostMapping()
    public ResponseEntity<Bino> postMethodName(@RequestBody Bino entity) {
        return ResponseEntity.ok(bs.create(entity));
    }

    @PutMapping()
    public ResponseEntity<Bino> putMethodName(@RequestBody Bino bino) {
        return ResponseEntity.ok(bs.update(bino));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMethodName(@PathVariable Long id) {
        return ResponseEntity.ok(bs.deleteById(id));
    }
}