package br.com.runescape.Controller;

import br.com.runescape.Entity.Magic;
import br.com.runescape.Exceptions.*;
import br.com.runescape.Service.MagicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/magics")
public class MagicController {

    @Autowired
    private MagicService magicService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Magic> readAll(){
        return this.magicService.readAll();
    }

    @RequestMapping( value = "/topMagics", method = RequestMethod.GET)
    public List<Magic> getTopMagics(){
        return this.magicService.getTopMagics();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Magic> findById(@PathVariable int id) throws InvalidIdException{
        return this.magicService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Magic create(@RequestBody Magic magic) throws InvalidEntityException, EntityNullException {
        return this.magicService.create(magic);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Magic update(@PathVariable int id, @RequestBody Magic magic) throws InvalidIdException, InvalidUpdateEntityException {
        return this.magicService.update(id, magic);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id) throws InvalidIdException {
        return this.magicService.delete(id);
    }

    @RequestMapping(value = "name/{name}", method = RequestMethod.GET)
    public Magic findByName(@PathVariable String name) throws InvalidNameException {
        return this.magicService.findByName(name);
    }
}
