package br.com.runescape.Service;

import br.com.runescape.Entity.Cooking;
import br.com.runescape.Exceptions.*;

import java.util.List;
import java.util.Optional;

public interface ICookingService {

    public List<Cooking> getTopCookings();
    public List<Cooking> readAll();
    public Cooking create(Cooking cooking) throws InvalidEntityException, EntityNullException;
    public Cooking update(int id, Cooking cooking) throws InvalidIdException, InvalidUpdateEntityException;
    public boolean delete(int id) throws InvalidIdException;
    public Optional<Cooking> findById(int id) throws InvalidIdException;
    public Cooking findByName(String name) throws InvalidNameException;

}
