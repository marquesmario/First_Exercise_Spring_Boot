package br.com.runescape.categoriesTest;

import br.com.runescape.Entity.Magic;
import br.com.runescape.Exceptions.*;
import br.com.runescape.Service.MagicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MagicServiceTest {


    Magic magic1 = new Magic("Heroboy",99,1234566);
    Magic magicSame = new Magic("Heroboy",99,1234566);


    private MagicService magicService = new MagicService();

    @Test
    public void createCategorySuccessful() throws EntityNullException, InvalidEntityException {
        assertSame(magicService.create(magic1), magic1);
    }

    @Test(expected = InvalidEntityException.class)
    public void whenSaveTwoCategoriesEqual_ThenCallInvalidEntityException() throws EntityNullException, InvalidEntityException {
        magicService.create(magic1);
        magicService.create(magicSame);
    }

    @Test(expected = EntityNullException.class)
    public void whenSaveNullEntity_thenCallEntityNullException() throws EntityNullException, InvalidEntityException {
        magic1.setLevel(-1);
        magic1.setName(null);
        magicService.create(magic1);
    }

    @Test
    public void updateCategorySuccessful() throws EntityNullException, InvalidEntityException, InvalidIdException, InvalidUpdateEntityException {
        magicService.create(magic1);
        magic1.setName("NewHero");
        magic1.setLevel(98);
        assertSame(magicService.update(1, magic1), magic1);
    }

    @Test(expected = InvalidUpdateEntityException.class)
    public void whenUpdateIsEqualThanSaved_thenCallInvalidUpdateEntityException() throws EntityNullException, InvalidEntityException, InvalidIdException, InvalidUpdateEntityException {
        magicService.create(magic1);
        magicService.update(1, magic1);
    }

    @Test(expected = InvalidIdException.class)
    public void whenUpdateIdDoesntExist_thenCallInvalidIdException() throws InvalidIdException, InvalidUpdateEntityException {
        magicService.update(13,magic1);
    }

    @Test
    public void deleteCategorySuccessful() throws EntityNullException, InvalidEntityException, InvalidIdException {
        magicService.create(magic1);
        assertTrue(magicService.delete(1));
    }

    @Test(expected = InvalidIdException.class)
    public void whenDeleteIdDoesntExist_thenCallInvalidIdException() throws InvalidIdException {
        magicService.delete(13);
    }

    @Test
    public void findByIdSuccessful() throws EntityNullException, InvalidEntityException, InvalidIdException{
        magicService.create(magic1);
        assertSame(magicService.findById(1), magic1);
    }

    @Test(expected = InvalidIdException.class)
    public void whenFindByIdDoesntExist_thenCallInvalidIdException() throws InvalidIdException {
        magicService.findById(13);
    }

    @Test
    public void findByNameSuccessful() throws EntityNullException, InvalidEntityException, InvalidNameException {
        magicService.create(magic1);
        assertSame(magicService.findByName("Heroboy"), magic1);
    }

    @Test(expected = InvalidNameException.class)
    public void whenFindByNameDoesntExist_thenCallInvalidNameException() throws InvalidNameException {
        magicService.findByName("Ultron");
    }

}
