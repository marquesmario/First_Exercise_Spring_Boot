package br.com.runescape.Controller;

import br.com.runescape.Entity.Defense;
import br.com.runescape.Exceptions.*;
import br.com.runescape.Service.DefenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/defenses")
public class DefenseController {

    @Autowired
    private DefenseService defenseService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Defense> readAll(){
        return this.defenseService.readAll();
    }

    @RequestMapping( value = "/topDefenses", method = RequestMethod.GET)
    public List<Defense> getTopDefenses(){
        return this.defenseService.getTopDefenses();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Defense> findById(@PathVariable int id) throws InvalidIdException{
        return this.defenseService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Defense create(@RequestBody Defense defense) throws InvalidEntityException, EntityNullException {
        return this.defenseService.create(defense);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Defense update(@PathVariable int id, @RequestBody Defense defense) throws InvalidIdException, InvalidUpdateEntityException {
        return this.defenseService.update(id, defense);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id) throws InvalidIdException {
        return this.defenseService.delete(id);
    }

    @RequestMapping(value = "name/{name}", method = RequestMethod.GET)
    public Defense findByName(@PathVariable String name) throws InvalidNameException {
        return this.defenseService.findByName(name);
    }
}
