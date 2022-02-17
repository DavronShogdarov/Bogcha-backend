package net.idrok.bogcha.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.idrok.bogcha.entity.Xodim;
import net.idrok.bogcha.service.XodimService;


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
@RequestMapping("/api/xodim")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class XodimController {

    @Autowired
    XodimService xs;

    @GetMapping()
    public ResponseEntity<Page<Xodim>> getall(@RequestParam(name = "key", required = false) String key,
            Pageable pageable) {
        if (key == null)
            key = "";
        return ResponseEntity.ok(xs.getall(key, pageable));
    }

    @PostMapping()
    public ResponseEntity<Xodim> postMethodName(@RequestBody Xodim entity) {
        return ResponseEntity.ok(xs.create(entity));
    }

    @PutMapping
    public ResponseEntity<Xodim> putMethodName(@RequestBody Xodim xodim) {
        return ResponseEntity.ok(xs.update(xodim));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMethodName(@PathVariable Long id) {
        return ResponseEntity.ok(xs.deleteById(id));
    }
}
