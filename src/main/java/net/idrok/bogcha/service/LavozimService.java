package net.idrok.bogcha.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.bogcha.entity.Lavozim;
import net.idrok.bogcha.repository.LavozimRepository;

@Service
public class LavozimService {
    @Autowired
    LavozimRepository lr;

    public Page<Lavozim> getall(String key, Pageable pageable) {
        return lr.findAllByNomContainingIgnoreCaseOrInfoContainingIgnoreCase(key, key, pageable);
    }

    public Lavozim create(Lavozim lavozim) {
        if (lavozim.getId() == null)
            return lr.save(lavozim);
        return null;
    }

    public Lavozim update(Lavozim lavozim) {
        if (lavozim.getId() != null)
            return lr.save(lavozim);
        return null;
    }

     public void delete(Lavozim lavozim){
        lr.delete(lavozim);
    }

    public boolean deleteById(Long id){
        lr.deleteById(id);
        return true;
    }
}