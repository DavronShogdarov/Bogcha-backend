package net.idrok.bogcha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.bogcha.entity.Bino;
import net.idrok.bogcha.repository.BinoRepository;

@Service
public class BinoService {
    @Autowired
    BinoRepository br;

    public Page<Bino> getall(String key, Pageable pageable) {
        return br.findAllByNomContainingIgnoreCaseOrInfoContainingIgnoreCase(key, key, pageable);
    }

    public Bino create(Bino bino) {
        if (bino.getId() == null)
            return br.save(bino);
        return null;
    }

    public Bino update(Bino bino) {
        if (bino.getId() != null)
            return br.save(bino);
        return null;
    }

    public void delete(Bino bino) {
        br.delete(bino);
    }

    public boolean deleteById(Long id) {
        br.deleteById(id);
        return true;
    }

}