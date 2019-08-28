package br.com.runescape.Service;

import br.com.runescape.Entity.Attack;
import br.com.runescape.Exceptions.*;

import java.util.List;
import java.util.Optional;

public interface IAttackService {

    public List<Attack> getTopAttacks();
    public List<Attack> readAll();
    public Attack create(Attack attack) throws InvalidEntityException, EntityNullException;
    public Attack update(int id, Attack attack) throws InvalidIdException, InvalidUpdateEntityException;
    public boolean delete(int id) throws InvalidIdException;
    public Optional<Attack> findById(int id) throws InvalidIdException;
    public Attack findByName(String name) throws InvalidNameException;

}
