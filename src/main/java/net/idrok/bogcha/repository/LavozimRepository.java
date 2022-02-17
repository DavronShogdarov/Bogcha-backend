package net.idrok.bogcha.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.idrok.bogcha.entity.Lavozim;

@Repository
public interface LavozimRepository extends JpaRepository<Lavozim, Long>{
    // Page<Lavozim> findByNomAndInfo(String nom, String info, Pageable pageable);
    Page<Lavozim> findAllByNomContainingIgnoreCaseOrInfoContainingIgnoreCase(String k1, String k2, Pageable pageable);
}