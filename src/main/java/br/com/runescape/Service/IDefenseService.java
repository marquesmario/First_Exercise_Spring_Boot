package br.com.runescape.Service;

import br.com.runescape.Entity.Defense;
import br.com.runescape.Exceptions.*;

import java.util.List;
import java.util.Optional;

public interface IDefenseService {

    public List<Defense> getTopDefenses();
    public List<Defense> readAll();
    public Defense create(Defense defense) throws InvalidEntityException, EntityNullException;
    public Defense update(int id, Defense defense) throws InvalidIdException, InvalidUpdateEntityException;
    public boolean delete(int id) throws InvalidIdException;
    public Optional<Defense> findById(int id) throws InvalidIdException;
    public Defense findByName(String name) throws InvalidNameException;

}
