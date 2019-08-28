package br.com.runescape.Service;

import br.com.runescape.Entity.Crafting;
import br.com.runescape.Exceptions.*;

import java.util.List;
import java.util.Optional;

public interface ICraftingService {

    public List<Crafting> getTopCraftings();
    public List<Crafting> readAll();
    public Crafting create(Crafting crafting) throws InvalidEntityException, EntityNullException;
    public Crafting update(int id, Crafting crafting) throws InvalidIdException, InvalidUpdateEntityException;
    public boolean delete(int id) throws InvalidIdException;
    public Optional<Crafting> findById(int id) throws InvalidIdException;
    public Crafting findByName(String name) throws InvalidNameException;

}
