package net.idrok.bogcha.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.idrok.bogcha.entity.Guruh;

@Repository
public interface GuruhRepository extends JpaRepository<Guruh, Long>{
    Page<Guruh> findAllByNomContainingIgnoreCaseAndXodimIsmContainingIgnoreCase(String k1, String k2, Pageable pageable); 
}
