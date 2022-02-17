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

import net.idrok.bogcha.entity.Tulov;
import net.idrok.bogcha.service.TulovService;

@RestController
@RequestMapping("/api/tulov")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class TulovController {
    
    @Autowired
    TulovService ts;

    @GetMapping()
    public ResponseEntity<Page<Tulov>> getall(@RequestParam(name = "key", required = false) String key,
            Pageable pageable) {
        if (key == null)
            key = "";
        return ResponseEntity.ok(ts.getall(key, pageable));
    }

    @PostMapping()
    public ResponseEntity<Tulov> postMethodName(@RequestBody Tulov entity){
        return ResponseEntity.ok(ts.create(entity));
    }

    @PutMapping()
    public ResponseEntity<Tulov> puttMethodName(@RequestBody Tulov entity){
        return ResponseEntity.ok(ts.update(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMethodName(@PathVariable Long id){
        return ResponseEntity.ok(ts.deleteById(id));
    }
}
