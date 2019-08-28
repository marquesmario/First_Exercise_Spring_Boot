package br.com.runescape.Service;

import br.com.runescape.Entity.Cooking;
import br.com.runescape.Exceptions.*;
import br.com.runescape.Repository.CookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CookingService implements ICookingService{

    @Autowired
    private CookingRepository cookingRepository;

    public List<Cooking> getTopCookings(){
        List<Cooking> cookings = new ArrayList<>();
        cookingRepository.findAll().forEach(cookings::add);

        return cookings.stream()
                         .sorted(Comparator.comparingInt(Cooking::getLevel).thenComparing(Cooking::getXp).reversed())
                         .limit(10)
                         .collect(Collectors.toList());
    }

    public List<Cooking> readAll(){
        List<Cooking> cookings = new ArrayList<>();
        cookingRepository.findAll().forEach(cookings::add);
        return cookings;
    }

    public Cooking create(Cooking cooking) throws InvalidEntityException, EntityNullException {
        Cooking result = null;
        if(cooking != null && !cookingRepository.existsByName(cooking.getName())) {
            result = cooking;
            cookingRepository.save(cooking);
        }else if(cooking.getName() != null && cooking.getXp() >= 0 && cooking.getLevel() >= 0 ){
            throw new InvalidEntityException();
        }else {
            throw new EntityNullException();
        }
        return result;
    }

    public Cooking update(int id,Cooking cooking) throws InvalidIdException, InvalidUpdateEntityException {
        Cooking result = null;

        if(cookingRepository.existsById(id) && cooking != null && (cookingRepository.findByName(cooking.getName())) == null ||cookingRepository.findById(id).get().getLevel() != cooking.getLevel() || cookingRepository.findById(id).get().getXp() != cooking.getXp()) {
            cooking.setId(id);
            result = cooking;
            cookingRepository.save(cooking);
        }else if (cookingRepository.existsById(id) == false){
            throw new InvalidIdException();
        }else{
            throw new InvalidUpdateEntityException();
        }
        return result;
    }

    public boolean delete(int id) throws InvalidIdException{
        boolean result = false;
        if(cookingRepository.existsById(id)) {
            cookingRepository.deleteById(id);
            result = true;
        }else{
            throw new InvalidIdException();
        }
        return result;
    }

    public Optional<Cooking> findById(int id) throws InvalidIdException{
        Optional<Cooking> result = null;
        if(cookingRepository.existsById(id)){
           result = cookingRepository.findById(id);
        }else{
            throw new InvalidIdException();
        }

        return result;
    }

    public Cooking findByName(String name) throws InvalidNameException {
        Cooking result = null;
        if (cookingRepository.existsByName(name)){
            result = cookingRepository.findByName(name);
        } else{
            throw new InvalidNameException();
        }
        return result;
    }
}
