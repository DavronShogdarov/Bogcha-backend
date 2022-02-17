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

import net.idrok.bogcha.entity.Bola;
import net.idrok.bogcha.service.BolaService;

@RestController
@RequestMapping("/api/bola")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class BolaController {
    
    @Autowired
    BolaService bs;
    @GetMapping()
    public ResponseEntity<Page<Bola>> getall(@RequestParam(name = "key", required = false) String key,
            Pageable pageable) {
        if (key == null)
            key = "";
        return ResponseEntity.ok(bs.getall(key, pageable));
    }
    // @GetMapping()
    // public ResponseEntity<Page<Bola>> getall(@RequestParam(name = "key", required = false) String key,
    //         Pageable pageable) {
    //     if (key == null)
    //         key = "";
    //     return ResponseEntity.ok(bs.getall(key, pageable));
    // }

    @PostMapping()
    public ResponseEntity<Bola> postMethodName(@RequestBody Bola entity){
        return ResponseEntity.ok(bs.create(entity));
    }
    @PutMapping()
    public ResponseEntity<Bola> putMethodName(@RequestBody Bola bola){
        return ResponseEntity.ok(bs.update(bola));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMethodName(@PathVariable Long id){
        return ResponseEntity.ok(bs.deleteById(id));
    }

}
