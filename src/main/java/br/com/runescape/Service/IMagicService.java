package br.com.runescape.Service;

import br.com.runescape.Entity.Magic;
import br.com.runescape.Exceptions.*;

import java.util.List;
import java.util.Optional;

public interface IMagicService {

    public List<Magic> getTopMagics();
    public List<Magic> readAll();
    public Magic create(Magic magic) throws InvalidEntityException, EntityNullException;
    public Magic update(int id, Magic magic) throws InvalidIdException, InvalidUpdateEntityException;
    public boolean delete(int id) throws InvalidIdException;
    public Optional<Magic> findById(int id) throws InvalidIdException;
    public Magic findByName(String name) throws InvalidNameException;

}
