package br.com.runescape.Service;

import br.com.runescape.Entity.Attack;
import br.com.runescape.Exceptions.*;
import br.com.runescape.Repository.AttackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttackService implements IAttackService{

    @Autowired
    private AttackRepository attackRepository;


    public List<Attack> getTopAttacks(){
        List<Attack> attacks = new ArrayList<>();
        attackRepository.findAll().forEach(attacks::add);

        return attacks.stream()
                         .sorted(Comparator.comparingInt(Attack::getLevel).thenComparing(Attack::getXp).reversed())
                         .limit(10)
                         .collect(Collectors.toList());
    }

    public List<Attack> readAll(){
        List<Attack> attacks = new ArrayList<>();
        attackRepository.findAll().forEach(attacks::add);
        return attacks;
    }

    public Attack create(Attack attack) throws InvalidEntityException, EntityNullException{
        Attack result = null;
        if(attack != null && !attackRepository.existsByName(attack.getName())) {
            result = attack;
            attackRepository.save(attack);
        }else if(attack.getName() != null && attack.getXp() >= 0 && attack.getLevel() >= 0 ){
            throw new InvalidEntityException();
        }else {
            throw new EntityNullException();
        }
        return result;
    }

    public Attack update(int id,Attack attack) throws InvalidIdException, InvalidUpdateEntityException {
        Attack result = null;

        if(attackRepository.existsById(id) && attack != null && (attackRepository.findByName(attack.getName())) == null ||attackRepository.findById(id).get().getLevel() != attack.getLevel() || attackRepository.findById(id).get().getXp() != attack.getXp()) {
            attack.setId(id);
            result = attack;
            attackRepository.save(attack);
        }else if (!attackRepository.existsById(id)){
            throw new InvalidIdException();
        }else{
            throw new InvalidUpdateEntityException();
        }
        return result;
    }

    public boolean delete(int id) throws InvalidIdException{
        boolean result = false;
        if(attackRepository.existsById(id)) {
            attackRepository.deleteById(id);
            result = true;
        }else{
            throw new InvalidIdException();
        }
        return result;
    }

    public Optional<Attack> findById(int id) throws InvalidIdException{
        Optional<Attack> result = null;
        if(attackRepository.existsById(id)){
           result = attackRepository.findById(id);
        }else{
            throw new InvalidIdException();
        }

        return result;
    }

    public Attack findByName(String name) throws InvalidNameException {
        Attack result = null;
        if (attackRepository.existsByName(name)){
            result = attackRepository.findByName(name);
        } else{
            throw new InvalidNameException();
        }
        return result;
    }
}
