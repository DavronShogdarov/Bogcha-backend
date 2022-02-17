package net.idrok.bogcha.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.bogcha.entity.Tulov;
import net.idrok.bogcha.repository.TulovRepository;

@Service
public class TulovService {
    @Autowired
    TulovRepository tr;

    public Page<Tulov> getall(String key, Pageable pageable) {
        return tr.findAllByMiqdorContainingIgnoreCaseAndSanaContainingIgnoreCaseAndBolaIsmContainingIgnoreCase(key, key, key, pageable);
    }

    public Tulov create(Tulov tulov) {
        if (tulov.getId() == null)
            return tr.save(tulov);
        return null;
    }

    public Tulov update(Tulov tulov) {
        if (tulov.getId() != null)
            return tr.save(tulov);
        return null;
    }

    public void delete(Tulov tulov) {
        tr.delete(tulov);
    }

    public boolean deleteById(Long id) {
        tr.deleteById(id);
        return true;
    }

}
