package net.idrok.bogcha.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.idrok.bogcha.entity.Bola;

@Repository
public interface BolaRepository extends JpaRepository<Bola, Long>{
    // Page<Bola> findByIsmAndFamilyaAndSharifAndJins(String k1, String k2, String k3, String k4, Pageable pageable);
    Page<Bola> findAllByIsmContainingIgnoreCaseAndFamilyaContainingIgnoreCaseAndSharifContainingIgnoreCaseAndJinsContainingIgnoreCase(String k1, String k2, String k3, String k4, Pageable pageable); 
}
