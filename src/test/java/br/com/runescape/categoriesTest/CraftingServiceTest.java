package br.com.runescape.categoriesTest;

import br.com.runescape.Entity.Crafting;
import br.com.runescape.Exceptions.*;
import br.com.runescape.Service.CraftingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CraftingServiceTest {


    Crafting crafting1 = new Crafting("Heroboy",99,1234566);
    Crafting craftingSame = new Crafting("Heroboy",99,1234566);


    private CraftingService craftingService = new CraftingService();

    @Test
    public void createCategorySuccessful() throws EntityNullException, InvalidEntityException {
        assertSame(craftingService.create(crafting1), crafting1);
    }

    @Test(expected = InvalidEntityException.class)
    public void whenSaveTwoCategoriesEqual_ThenCallInvalidEntityException() throws EntityNullException, InvalidEntityException {
        craftingService.create(crafting1);
        craftingService.create(craftingSame);
    }

    @Test(expected = EntityNullException.class)
    public void whenSaveNullEntity_thenCallEntityNullException() throws EntityNullException, InvalidEntityException {
        crafting1.setLevel(-1);
        crafting1.setName(null);
        craftingService.create(crafting1);
    }

    @Test
    public void updateCategorySuccessful() throws EntityNullException, InvalidEntityException, InvalidIdException, InvalidUpdateEntityException {
        craftingService.create(crafting1);
        crafting1.setName("NewHero");
        crafting1.setLevel(98);
        assertSame(craftingService.update(1, crafting1), crafting1);
    }

    @Test(expected = InvalidUpdateEntityException.class)
    public void whenUpdateIsEqualThanSaved_thenCallInvalidUpdateEntityException() throws EntityNullException, InvalidEntityException, InvalidIdException, InvalidUpdateEntityException {
        craftingService.create(crafting1);
        craftingService.update(1, crafting1);
    }

    @Test(expected = InvalidIdException.class)
    public void whenUpdateIdDoesntExist_thenCallInvalidIdException() throws InvalidIdException, InvalidUpdateEntityException {
        craftingService.update(13,crafting1);
    }

    @Test
    public void deleteCategorySuccessful() throws EntityNullException, InvalidEntityException, InvalidIdException {
        craftingService.create(crafting1);
        assertTrue(craftingService.delete(1));
    }

    @Test(expected = InvalidIdException.class)
    public void whenDeleteIdDoesntExist_thenCallInvalidIdException() throws InvalidIdException {
        craftingService.delete(13);
    }

    @Test
    public void findByIdSuccessful() throws EntityNullException, InvalidEntityException, InvalidIdException{
        craftingService.create(crafting1);
        assertSame(craftingService.findById(1), crafting1);
    }

    @Test(expected = InvalidIdException.class)
    public void whenFindByIdDoesntExist_thenCallInvalidIdException() throws InvalidIdException {
        craftingService.findById(13);
    }

    @Test
    public void findByNameSuccessful() throws EntityNullException, InvalidEntityException, InvalidNameException {
        craftingService.create(crafting1);
        assertSame(craftingService.findByName("Heroboy"), crafting1);
    }

    @Test(expected = InvalidNameException.class)
    public void whenFindByNameDoesntExist_thenCallInvalidNameException() throws InvalidNameException {
        craftingService.findByName("Ultron");
    }

}
