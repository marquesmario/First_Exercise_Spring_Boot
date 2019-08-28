package br.com.runescape.Service;

import br.com.runescape.Entity.Crafting;
import br.com.runescape.Exceptions.*;
import br.com.runescape.Repository.CraftingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CraftingService implements ICraftingService{

    @Autowired
    private CraftingRepository craftingRepository;

    public List<Crafting> getTopCraftings(){
        List<Crafting> craftings = new ArrayList<>();
        craftingRepository.findAll().forEach(craftings::add);

        return craftings.stream()
                         .sorted(Comparator.comparingInt(Crafting::getLevel).thenComparing(Crafting::getXp).reversed())
                         .limit(10)
                         .collect(Collectors.toList());
    }

    public List<Crafting> readAll(){
        List<Crafting> craftings = new ArrayList<>();
        craftingRepository.findAll().forEach(craftings::add);
        return craftings;
    }

    public Crafting create(Crafting crafting) throws InvalidEntityException, EntityNullException {
        Crafting result = null;
        if (crafting != null && !craftingRepository.existsByName(crafting.getName())) {
            result = crafting;
            craftingRepository.save(crafting);
        } else if (crafting.getName() != null && crafting.getXp() >= 0 && crafting.getLevel() >= 0) {
            throw new InvalidEntityException();
        } else {
            throw new EntityNullException();
        }
        return result;
    }

    public Crafting update(int id,Crafting crafting) throws InvalidIdException, InvalidUpdateEntityException {
        Crafting result = null;

        if(craftingRepository.existsById(id) && crafting != null && (craftingRepository.findByName(crafting.getName())) == null ||craftingRepository.findById(id).get().getLevel() != crafting.getLevel() || craftingRepository.findById(id).get().getXp() != crafting.getXp()) {
            crafting.setId(id);
            result = crafting;
            craftingRepository.save(crafting);
        }else if (craftingRepository.existsById(id) == false){
            throw new InvalidIdException();
        }else{
            throw new InvalidUpdateEntityException();
        }
        return result;
    }

    public boolean delete(int id) throws InvalidIdException{
        boolean result = false;
        if(craftingRepository.existsById(id)) {
            craftingRepository.deleteById(id);
            result = true;
        }else{
            throw new InvalidIdException();
        }
        return result;
    }

    public Optional<Crafting> findById(int id) throws InvalidIdException{
        Optional<Crafting> result = null;
        if(craftingRepository.existsById(id)){
           result = craftingRepository.findById(id);
        }else{
            throw new InvalidIdException();
        }

        return result;
    }

    public Crafting findByName(String name) throws InvalidNameException {
        Crafting result = null;
        if (craftingRepository.existsByName(name)){
            result = craftingRepository.findByName(name);
        } else{
            throw new InvalidNameException();
        }
        return result;
    }
}
