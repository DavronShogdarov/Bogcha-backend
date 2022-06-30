package net.idrok.bogcha.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import net.idrok.bogcha.entity.GuruhXona;


@Repository
public interface GuruhXonaRepository extends JpaRepository<GuruhXona, Long>{
    Page<GuruhXona> findAllByGuruhNomContainingIgnoreCaseOrXonaNomContainingIgnoreCase(String k1, String k2, Pageable pageable); 
}

