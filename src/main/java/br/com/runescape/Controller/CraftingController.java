package br.com.runescape.Controller;

import br.com.runescape.Entity.Crafting;
import br.com.runescape.Exceptions.*;
import br.com.runescape.Service.CraftingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/craftings")
public class CraftingController {

    @Autowired
    private CraftingService craftingService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Crafting> readAll(){
        return this.craftingService.readAll();
    }

    @RequestMapping( value = "/topCraftings", method = RequestMethod.GET)
    public List<Crafting> getTopCraftings(){
        return this.craftingService.getTopCraftings();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Crafting> findById(@PathVariable int id) throws InvalidIdException{
        return this.craftingService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Crafting create(@RequestBody Crafting crafting) throws InvalidEntityException, EntityNullException {
        return this.craftingService.create(crafting);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Crafting update(@PathVariable int id, @RequestBody Crafting crafting) throws InvalidIdException, InvalidUpdateEntityException {
        return this.craftingService.update(id, crafting);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id) throws InvalidIdException {
        return this.craftingService.delete(id);
    }

    @RequestMapping(value = "name/{name}", method = RequestMethod.GET)
    public Crafting findByName(@PathVariable String name) throws InvalidNameException {
        return this.craftingService.findByName(name);
    }
}
