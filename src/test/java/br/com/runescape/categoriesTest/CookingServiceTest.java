package br.com.runescape.categoriesTest;

import br.com.runescape.Entity.Cooking;
import br.com.runescape.Exceptions.*;
import br.com.runescape.Service.CookingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CookingServiceTest {


    Cooking cooking1 = new Cooking("Heroboy",99,1234566);
    Cooking cookingSame = new Cooking("Heroboy",99,1234566);


    private CookingService cookingService = new CookingService();

    @Test
    public void createCategorySuccessful() throws EntityNullException, InvalidEntityException {
        assertSame(cookingService.create(cooking1), cooking1);
    }

    @Test(expected = InvalidEntityException.class)
    public void whenSaveTwoCategoriesEqual_ThenCallInvalidEntityException() throws EntityNullException, InvalidEntityException {
        cookingService.create(cooking1);
        cookingService.create(cookingSame);
    }

    @Test(expected = EntityNullException.class)
    public void whenSaveNullEntity_thenCallEntityNullException() throws EntityNullException, InvalidEntityException {
        cooking1.setLevel(-1);
        cooking1.setName(null);
        cookingService.create(cooking1);
    }

    @Test
    public void updateCategorySuccessful() throws EntityNullException, InvalidEntityException, InvalidIdException, InvalidUpdateEntityException {
        cookingService.create(cooking1);
        cooking1.setName("NewHero");
        cooking1.setLevel(98);
        assertSame(cookingService.update(1, cooking1), cooking1);
    }

    @Test(expected = InvalidUpdateEntityException.class)
    public void whenUpdateIsEqualThanSaved_thenCallInvalidUpdateEntityException() throws EntityNullException, InvalidEntityException, InvalidIdException, InvalidUpdateEntityException {
        cookingService.create(cooking1);
        cookingService.update(1, cooking1);
    }

    @Test(expected = InvalidIdException.class)
    public void whenUpdateIdDoesntExist_thenCallInvalidIdException() throws InvalidIdException, InvalidUpdateEntityException {
        cookingService.update(13,cooking1);
    }

    @Test
    public void deleteCategorySuccessful() throws EntityNullException, InvalidEntityException, InvalidIdException {
        cookingService.create(cooking1);
        assertTrue(cookingService.delete(1));
    }

    @Test(expected = InvalidIdException.class)
    public void whenDeleteIdDoesntExist_thenCallInvalidIdException() throws InvalidIdException {
        cookingService.delete(13);
    }

    @Test
    public void findByIdSuccessful() throws EntityNullException, InvalidEntityException, InvalidIdException{
        cookingService.create(cooking1);
        assertSame(cookingService.findById(1), cooking1);
    }

    @Test(expected = InvalidIdException.class)
    public void whenFindByIdDoesntExist_thenCallInvalidIdException() throws InvalidIdException {
        cookingService.findById(13);
    }

    @Test
    public void findByNameSuccessful() throws EntityNullException, InvalidEntityException, InvalidNameException {
        cookingService.create(cooking1);
        assertSame(cookingService.findByName("Heroboy"), cooking1);
    }

    @Test(expected = InvalidNameException.class)
    public void whenFindByNameDoesntExist_thenCallInvalidNameException() throws InvalidNameException {
        cookingService.findByName("Ultron");
    }

}
