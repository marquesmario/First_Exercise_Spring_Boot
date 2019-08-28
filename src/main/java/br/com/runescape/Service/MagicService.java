package br.com.runescape.Service;

import br.com.runescape.Entity.Magic;
import br.com.runescape.Exceptions.*;
import br.com.runescape.Repository.MagicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MagicService implements IMagicService{

    @Autowired
    private MagicRepository magicRepository;

    public List<Magic> getTopMagics(){
        List<Magic> magics = new ArrayList<>();
        magicRepository.findAll().forEach(magics::add);

        return magics.stream()
                         .sorted(Comparator.comparingInt(Magic::getLevel).thenComparing(Magic::getXp).reversed())
                         .limit(10)
                         .collect(Collectors.toList());
    }

    public List<Magic> readAll(){
        List<Magic> magics = new ArrayList<>();
        magicRepository.findAll().forEach(magics::add);
        return magics;
    }

    public Magic create(Magic magic) throws InvalidEntityException, EntityNullException {
        Magic result = null;
        if(magic != null && !magicRepository.existsByName(magic.getName())) {
            result = magic;
            magicRepository.save(magic);
        }else if(magic.getName() != null && magic.getXp() >= 0 && magic.getLevel() >= 0 ){
            throw new InvalidEntityException();
        }else {
            throw new EntityNullException();
        }
        return result;
    }

    public Magic update(int id,Magic magic) throws InvalidIdException, InvalidUpdateEntityException {
        Magic result = null;

        if(magicRepository.existsById(id) && magic != null && (magicRepository.findByName(magic.getName())) == null ||magicRepository.findById(id).get().getLevel() != magic.getLevel() || magicRepository.findById(id).get().getXp() != magic.getXp()) {
            magic.setId(id);
            result = magic;
            magicRepository.save(magic);
        }else if (magicRepository.existsById(id) == false){
            throw new InvalidIdException();
        }else{
            throw new InvalidUpdateEntityException();
        }
        return result;
    }

    public boolean delete(int id) throws InvalidIdException{
        boolean result = false;
        if(magicRepository.existsById(id)) {
            magicRepository.deleteById(id);
            result = true;
        }else{
            throw new InvalidIdException();
        }
        return result;
    }

    public Optional<Magic> findById(int id) throws InvalidIdException{
        Optional<Magic> result = null;
        if(magicRepository.existsById(id)){
           result = magicRepository.findById(id);
        }else{
            throw new InvalidIdException();
        }

        return result;
    }

    public Magic findByName(String name) throws InvalidNameException {
        Magic result = null;
        if (magicRepository.existsByName(name)){
            result = magicRepository.findByName(name);
        } else{
            throw new InvalidNameException();
        }
        return result;
    }
}
