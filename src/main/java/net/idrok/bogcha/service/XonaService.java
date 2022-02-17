package net.idrok.bogcha.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.bogcha.entity.Xona;
import net.idrok.bogcha.repository.XonaRepository;

@Service
public class XonaService {
    @Autowired
    XonaRepository xr;

    public Page<Xona> getall(String key, Pageable pageable) {
        return xr.findAllByNomContainingIgnoreCaseAndBinoNomContainingIgnoreCaseAndInfoContainingIgnoreCase(key, key, key, pageable);
    }

    public Xona create(Xona xona) {
        if (xona.getId() == null)
            return xr.save(xona);
        return null;
    }

    public Xona update(Xona xona) {
        if (xona.getId() != null)
            return xr.save(xona);
        return null;
    }

    public void delete(Xona xona) {
        xr.delete(xona);
    }

    public boolean deleteById(Long id) {
        xr.deleteById(id);
        return true;
    }
}
