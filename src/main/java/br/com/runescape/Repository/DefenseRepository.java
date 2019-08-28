package br.com.runescape.Repository;

import br.com.runescape.Entity.Defense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefenseRepository extends JpaRepository<Defense, Integer> {

    Defense findByName(String name);
    boolean existsByName(String name);
}
