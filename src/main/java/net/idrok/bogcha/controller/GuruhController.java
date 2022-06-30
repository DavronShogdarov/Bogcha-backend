package net.idrok.bogcha.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.idrok.bogcha.entity.Guruh;
import net.idrok.bogcha.service.GuruhService;

@RestController
@RequestMapping("/api/guruh")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class GuruhController {

    @Autowired
    GuruhService gs;

    @GetMapping()
    public ResponseEntity<Page<Guruh>> getall(@RequestParam(name = "key", required = false) String key,
            Pageable pageable) {
        if (key == null)
            key = "";
        return ResponseEntity.ok(gs.getall(key, pageable));
    }

    @PostMapping()
    public ResponseEntity<Guruh> postMethodName(@RequestBody Guruh entity) {
        return ResponseEntity.ok(gs.create(entity));
    }

    @PutMapping()
    public ResponseEntity<Guruh> putMethodName(@RequestBody Guruh bola) {
        return ResponseEntity.ok(gs.update(bola));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMethodName(@PathVariable Long id) {
        return ResponseEntity.ok(gs.deleteById(id));
    }

}
