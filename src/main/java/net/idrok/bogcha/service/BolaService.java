package net.idrok.bogcha.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.bogcha.entity.Bola;
import net.idrok.bogcha.repository.BolaRepository;

@Service
public class BolaService {
    @Autowired
    BolaRepository br;

    public Page<Bola> getall(String key, Pageable pageable) {
        return br.findAllByIsmContainingIgnoreCaseAndFamilyaContainingIgnoreCaseAndSharifContainingIgnoreCaseAndJinsContainingIgnoreCase(key, key, key, key, pageable);
    }
    
    public Bola create(Bola bola) {
        if (bola.getId() == null)
            return br.save(bola);
        return null;
    }

    public Bola update(Bola bola) {
        if (bola.getId() != null)
            return br.save(bola);
        return null;
    }

    public void delete(Bola bola) {
        br.delete(bola);
    }

    public boolean deleteById(Long id) {
        br.deleteById(id);
        return true;
    }

}
