package br.com.runescape.Controller;

import br.com.runescape.Entity.Attack;
import br.com.runescape.Exceptions.*;
import br.com.runescape.Service.AttackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attacks")
public class AttackController {

    @Autowired
    private AttackService attackService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Attack> readAll(){
        return this.attackService.readAll();
    }

    @RequestMapping( value = "/topAttacks", method = RequestMethod.GET)
    public List<Attack> getTopAttacks(){
        return this.attackService.getTopAttacks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Attack> findById(@PathVariable int id) throws InvalidIdException{
        return this.attackService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Attack create(@RequestBody Attack attack) throws InvalidEntityException, EntityNullException {
        return this.attackService.create(attack);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Attack update(@PathVariable int id, @RequestBody Attack attack) throws InvalidIdException, InvalidUpdateEntityException {
        return this.attackService.update(id, attack);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id) throws InvalidIdException {
        return this.attackService.delete(id);
    }

    @RequestMapping(value = "name/{name}", method = RequestMethod.GET)
    public Attack findByName(@PathVariable String name) throws InvalidNameException {
        return this.attackService.findByName(name);
    }
}
