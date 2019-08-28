package br.com.runescape.Repository;

import br.com.runescape.Entity.Crafting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CraftingRepository extends JpaRepository<Crafting, Integer> {

    Crafting findByName(String Name);
    boolean existsByName(String name);
}
