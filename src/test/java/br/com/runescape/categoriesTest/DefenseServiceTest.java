package br.com.runescape.categoriesTest;

import br.com.runescape.Entity.Defense;
import br.com.runescape.Exceptions.*;
import br.com.runescape.Service.DefenseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefenseServiceTest {


    Defense defense1 = new Defense("Heroboy",99,1234566);
    Defense defenseSame = new Defense("Heroboy",99,1234566);


    private DefenseService defenseService = new DefenseService();

    @Test
    public void createCategorySuccessful() throws EntityNullException, InvalidEntityException {
        assertSame(defenseService.create(defense1), defense1);
    }

    @Test(expected = InvalidEntityException.class)
    public void whenSaveTwoCategoriesEqual_ThenCallInvalidEntityException() throws EntityNullException, InvalidEntityException {
        defenseService.create(defense1);
        defenseService.create(defenseSame);
    }

    @Test(expected = EntityNullException.class)
    public void whenSaveNullEntity_thenCallEntityNullException() throws EntityNullException, InvalidEntityException {
        defense1.setLevel(-1);
        defense1.setName(null);
        defenseService.create(defense1);
    }

    @Test
    public void updateCategorySuccessful() throws InvalidEntityException, InvalidIdException, InvalidUpdateEntityException, EntityNullException {
        defenseService.create(defense1);
        defense1.setName("NewHero");
        defense1.setLevel(98);
        assertSame(defenseService.update(1, defense1), defense1);
    }

    @Test(expected = InvalidUpdateEntityException.class)
    public void whenUpdateIsEqualThanSaved_thenCallInvalidUpdateEntityException() throws EntityNullException, InvalidEntityException, InvalidIdException, InvalidUpdateEntityException {
        defenseService.create(defense1);
        defenseService.update(1, defense1);
    }

    @Test(expected = InvalidIdException.class)
    public void whenUpdateIdDoesntExist_thenCallInvalidIdException() throws InvalidIdException, InvalidUpdateEntityException {
        defenseService.update(13,defense1);
    }

    @Test
    public void deleteCategorySuccessful() throws EntityNullException, InvalidEntityException, InvalidIdException {
        defenseService.create(defense1);
        assertTrue(defenseService.delete(1));
    }

    @Test(expected = InvalidIdException.class)
    public void whenDeleteIdDoesntExist_thenCallInvalidIdException() throws InvalidIdException {
        defenseService.delete(13);
    }

    @Test
    public void findByIdSuccessful() throws EntityNullException, InvalidEntityException, InvalidIdException{
        defenseService.create(defense1);
        assertSame(defenseService.findById(1), defense1);
    }

    @Test(expected = InvalidIdException.class)
    public void whenFindByIdDoesntExist_thenCallInvalidIdException() throws InvalidIdException {
        defenseService.findById(13);
    }

    @Test
    public void findByNameSuccessful() throws EntityNullException, InvalidEntityException, InvalidNameException {
        defenseService.create(defense1);
        assertSame(defenseService.findByName("Heroboy"), defense1);
    }

    @Test(expected = InvalidNameException.class)
    public void whenFindByNameDoesntExist_thenCallInvalidNameException() throws InvalidNameException {
        defenseService.findByName("Ultron");
    }

}
