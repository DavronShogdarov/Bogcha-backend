package net.idrok.bogcha.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.idrok.bogcha.entity.Xona;

@Repository
public interface XonaRepository extends JpaRepository<Xona, Long> {
    Page<Xona> findAllByNomContainingIgnoreCaseOrBinoNomContainingIgnoreCaseOrInfoContainingIgnoreCase(String k1, String k2, String k3, Pageable pageable); 
}