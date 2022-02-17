package net.idrok.bogcha.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.idrok.bogcha.entity.Xodim;

@Repository
public interface XodimRepository extends JpaRepository<Xodim, Long>{
    Page<Xodim> findAllByIsmContainingIgnoreCaseAndFamilyaContainingIgnoreCaseAndSharifContainingIgnoreCaseAndLavozimNomContainingIgnoreCase(String k1, String k2, String k3, String k4, Pageable pageable); 
}
