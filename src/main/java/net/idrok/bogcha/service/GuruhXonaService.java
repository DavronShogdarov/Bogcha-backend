package net.idrok.bogcha.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import net.idrok.bogcha.entity.GuruhXona;
import net.idrok.bogcha.repository.GuruhXonaRepository;

@Service
public class GuruhXonaService {
    @Autowired
    GuruhXonaRepository gxs;

    public Page<GuruhXona> getall(String key, Pageable pageable) {
        return gxs.findAllByGuruhNomContainingIgnoreCaseOrXonaNomContainingIgnoreCase(key, key, pageable);
    }

    public GuruhXona create(GuruhXona guruhXona) {
        if (guruhXona.getId() == null)
            return gxs.save(guruhXona);
        return null;

    }

    public GuruhXona update(GuruhXona guruhXona) {
        if (guruhXona.getId() != null)
            return gxs.save(guruhXona);
        return null;

    }

    public void deete(GuruhXona guruhXona) {
        gxs.delete(guruhXona);
    }

    public boolean deleteById(Long id) {
        gxs.deleteById(id);
        return true;
    }

}
