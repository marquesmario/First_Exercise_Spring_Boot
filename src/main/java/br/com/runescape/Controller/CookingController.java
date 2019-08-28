package br.com.runescape.Controller;

import br.com.runescape.Entity.Cooking;
import br.com.runescape.Exceptions.*;
import br.com.runescape.Service.CookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cookings")
public class CookingController {

    @Autowired
    private CookingService cookingService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Cooking> readAll(){
        return this.cookingService.readAll();
    }

    @RequestMapping( value = "/topCookings", method = RequestMethod.GET)
    public List<Cooking> getTopCookings(){
        return this.cookingService.getTopCookings();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Cooking> findById(@PathVariable int id) throws InvalidIdException{
        return this.cookingService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Cooking create(@RequestBody Cooking cooking) throws InvalidEntityException, EntityNullException {
        return this.cookingService.create(cooking);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Cooking update(@PathVariable int id, @RequestBody Cooking cooking) throws InvalidIdException, InvalidUpdateEntityException {
        return this.cookingService.update(id, cooking);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id) throws InvalidIdException {
        return this.cookingService.delete(id);
    }

    @RequestMapping(value = "name/{name}", method = RequestMethod.GET)
    public Cooking findByName(@PathVariable String name) throws InvalidNameException {
        return this.cookingService.findByName(name);
    }
}
