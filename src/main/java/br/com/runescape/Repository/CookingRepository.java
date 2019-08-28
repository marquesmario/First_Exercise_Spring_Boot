package br.com.runescape.Repository;

import br.com.runescape.Entity.Cooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookingRepository extends JpaRepository<Cooking, Integer> {

    Cooking findByName(String Name);
    boolean existsByName(String name);
}
