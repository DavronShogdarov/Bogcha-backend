package net.idrok.bogcha.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.idrok.bogcha.entity.Lavozim;
import net.idrok.bogcha.service.LavozimService;


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
@RequestMapping("/api/lavozim")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class LavozimController {

    @Autowired
    LavozimService ls;

    @GetMapping()
    public ResponseEntity<Page<Lavozim>> getall(@RequestParam(name = "key", required = false) String key,
            Pageable pageable) {
        if (key == null)
            key = "";
        return ResponseEntity.ok(ls.getall(key, pageable));
    }

    @PostMapping()
    public ResponseEntity<Lavozim> postMethodName(@RequestBody Lavozim entity) {
        return ResponseEntity.ok(ls.create(entity));
    }

    @PutMapping()
    public ResponseEntity<Lavozim> putMethodName(@RequestBody Lavozim lavozim){
        return ResponseEntity.ok(ls.update(lavozim));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMethodName(@PathVariable Long id) {
        return ResponseEntity.ok(ls.deleteById(id));
    }
}
