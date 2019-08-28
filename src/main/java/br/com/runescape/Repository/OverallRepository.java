package br.com.runescape.Repository;

import br.com.runescape.Entity.Overall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OverallRepository extends JpaRepository<Overall, Integer> {

    Overall findByName(String name);
    boolean existsByName(String name);
}
