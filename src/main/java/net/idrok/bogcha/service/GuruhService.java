package net.idrok.bogcha.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.bogcha.entity.Guruh;
import net.idrok.bogcha.repository.GuruhRepository;

@Service
public class GuruhService {
    @Autowired
    GuruhRepository gr;

    public Page<Guruh> getall(String key, Pageable pageable) {
        return gr.findAllByNomContainingIgnoreCaseAndXodimIsmContainingIgnoreCase(key, key, pageable);
    }

    public Guruh create(Guruh entity) {
        if (entity.getId() == null)
            return gr.save(entity);
        return null;
    }

    public Guruh update(Guruh guruh) {
        if (guruh.getId() != null)
            return gr.save(guruh);
        return null;
    }

    public void delete(Guruh guruh) {
        gr.delete(guruh);
    }

    public boolean deleteById(Long id) {
        gr.deleteById(id);
        return true;
    }

}
