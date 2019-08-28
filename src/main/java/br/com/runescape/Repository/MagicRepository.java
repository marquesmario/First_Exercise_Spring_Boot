package br.com.runescape.Repository;

import br.com.runescape.Entity.Magic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagicRepository extends JpaRepository<Magic, Integer> {

    Magic findByName(String name);
    boolean existsByName(String name);
}
