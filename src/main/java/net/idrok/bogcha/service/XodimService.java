package net.idrok.bogcha.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.bogcha.entity.Xodim;
import net.idrok.bogcha.repository.XodimRepository;

@Service
public class XodimService {
    @Autowired
    XodimRepository xr;

    public Page<Xodim> getall(String key, Pageable pageable) {
        return xr.findAllByIsmContainingIgnoreCaseAndFamilyaContainingIgnoreCaseAndSharifContainingIgnoreCaseAndLavozimNomContainingIgnoreCase(key, key, key, key, pageable);
    }

    public Xodim create(Xodim xodim) {
        if (xodim.getId() == null)
            return xr.save(xodim);
        return null;
    }

    public Xodim update(Xodim xodim) {
        if (xodim.getId() != null)
            return xr.save(xodim);
        return null;
    }

    public void delete(Xodim xodim) {
        xr.delete(xodim);
    }

    public boolean deleteById(Long id) {
        xr.deleteById(id);
        return true;
    }
}
