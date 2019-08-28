package br.com.runescape.categoriesTest;

import br.com.runescape.Entity.Attack;
import br.com.runescape.Exceptions.*;

import static org.junit.Assert.*;

import br.com.runescape.Repository.AttackRepository;
import br.com.runescape.Service.AttackService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.security.RunAs;
import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AttackServiceTest {


    Attack attack1 = new Attack("Heroboy",99,1234566);
    Attack attackSame = new Attack("Heroboy",99,1234566);


    @Autowired
    private AttackService attackService;

    @Test
    public void createCategorySuccessful() throws EntityNullException, InvalidEntityException {
        assertSame(attackService.create(attack1), attack1);
    }

    @Test(expected = InvalidEntityException.class)
    public void whenSaveTwoCategoriesEqual_ThenCallInvalidEntityException() throws EntityNullException, InvalidEntityException {
        attackService.create(attack1);
        attackService.create(attackSame);
    }

    @Test(expected = EntityNullException.class)
    public void whenSaveNullEntity_thenCallEntityNullException() throws EntityNullException, InvalidEntityException {
        attack1.setLevel(-1);
        attackService.create(attack1);
    }

    @Test
    public void updateCategorySuccessful() throws EntityNullException, InvalidEntityException, InvalidIdException, InvalidUpdateEntityException {
        attackService.create(attack1);
        attack1.setName("NewHero");
        attack1.setLevel(98);
        assertSame(attackService.update(1, attack1), attack1);
    }

    @Test(expected = InvalidUpdateEntityException.class)
    public void whenUpdateIsEqualThanSaved_thenCallInvalidUpdateEntityException() throws EntityNullException, InvalidEntityException, InvalidIdException, InvalidUpdateEntityException {
        attackService.create(attack1);
        attackService.update(1, attack1);
    }

    @Test(expected = InvalidIdException.class)
    public void whenUpdateIdDoesntExist_thenCallInvalidIdException() throws InvalidIdException, InvalidUpdateEntityException {
        attackService.update(13,attack1);
    }

    @Test
    public void deleteCategorySuccessful() throws EntityNullException, InvalidEntityException, InvalidIdException {
        attackService.create(attack1);
        assertTrue(attackService.delete(1));
    }

    @Test(expected = InvalidIdException.class)
    public void whenDeleteIdDoesntExist_thenCallInvalidIdException() throws InvalidIdException {
        attackService.delete(13);
    }

    @Test
    public void findByIdSuccessful() throws EntityNullException, InvalidEntityException, InvalidIdException{
        attackService.create(attack1);
        assertSame(attackService.findById(1).get(), attack1);
    }

    @Test(expected = InvalidIdException.class)
    public void whenFindByIdDoesntExist_thenCallInvalidIdException() throws InvalidIdException {
        attackService.findById(13);
    }

    @Test
    public void findByNameSuccessful() throws EntityNullException, InvalidEntityException, InvalidNameException {
        attackService.create(attack1);
        assertSame(attackService.findByName("Heroboy"), attack1);
    }

    @Test(expected = InvalidNameException.class)
    public void whenFindByNameDoesntExist_thenCallInvalidNameException() throws InvalidNameException {
        attackService.findByName("Ultron");
    }

}
