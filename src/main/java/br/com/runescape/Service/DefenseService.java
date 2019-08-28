package br.com.runescape.Service;

import br.com.runescape.Entity.Defense;
import br.com.runescape.Exceptions.*;
import br.com.runescape.Repository.DefenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefenseService implements IDefenseService{

    @Autowired
    private DefenseRepository defenseRepository;

    public List<Defense> getTopDefenses(){
        List<Defense> defenses = new ArrayList<>();
        defenseRepository.findAll().forEach(defenses::add);

        return defenses.stream()
                         .sorted(Comparator.comparingInt(Defense::getLevel).thenComparing(Defense::getXp).reversed())
                         .limit(10)
                         .collect(Collectors.toList());
    }

    public List<Defense> readAll(){
        List<Defense> defenses = new ArrayList<>();
        defenseRepository.findAll().forEach(defenses::add);
        return defenses;
    }

    public Defense create(Defense defense) throws InvalidEntityException, EntityNullException {
        Defense result = null;
        if (defense != null && !defenseRepository.existsByName(defense.getName())) {
            result = defense;
            defenseRepository.save(defense);
        } else if (defense.getName() != null && defense.getXp() >= 0 && defense.getLevel() >= 0) {
            throw new InvalidEntityException();
        } else {
            throw new EntityNullException();
        }
        return result;
    }

    public Defense update(int id,Defense defense) throws InvalidIdException, InvalidUpdateEntityException {
        Defense result = null;

        if(defenseRepository.existsById(id) && defense != null && (defenseRepository.findByName(defense.getName())) == null ||defenseRepository.findById(id).get().getLevel() != defense.getLevel() || defenseRepository.findById(id).get().getXp() != defense.getXp()) {
            defense.setId(id);
            result = defense;
            defenseRepository.save(defense);
        }else if (defenseRepository.existsById(id) == false){
            throw new InvalidIdException();
        }else{
            throw new InvalidUpdateEntityException();
        }
        return result;
    }

    public boolean delete(int id) throws InvalidIdException{
        boolean result = false;
        if(defenseRepository.existsById(id)) {
            defenseRepository.deleteById(id);
            result = true;
        }else{
            throw new InvalidIdException();
        }
        return result;
    }

    public Optional<Defense> findById(int id) throws InvalidIdException{
        Optional<Defense> result = null;
        if(defenseRepository.existsById(id)){
           result = defenseRepository.findById(id);
        }else{
            throw new InvalidIdException();
        }

        return result;
    }

    public Defense findByName(String name) throws InvalidNameException {
        Defense result = null;
        if (defenseRepository.existsByName(name)){
            result = defenseRepository.findByName(name);
        } else{
            throw new InvalidNameException();
        }
        return result;
    }
}
