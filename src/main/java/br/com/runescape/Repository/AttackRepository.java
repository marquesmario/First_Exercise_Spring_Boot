package br.com.runescape.Repository;

import br.com.runescape.Entity.Attack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttackRepository extends JpaRepository<Attack, Integer> {

    Attack findByName(String name);
    boolean existsByName(String name);
}
