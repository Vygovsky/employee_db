package main.java.ua.ukr.net.dao;

import org.junit.*;
import ua.ukr.net.Dao.JdbcEmployeeDao;
import ua.ukr.net.Dao.Db;
import main.java.ua.ukr.net.model.Employee;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by storm on 12/14/17.
 */
public class CollectionEmployeeDaoTest {
    private JdbcEmployeeDao dao;

    @BeforeClass
    public static void initClass() {
        Db.getEmployees().add(new Employee(12, "Roman", "vigmol@ukr.net", new Date(), 8985));
        Db.getEmployees().add(new Employee(19, "Sergey", "sergey@mail.net", new Date(), 8999));
        Db.getEmployees().add(new Employee(52, "Tany", "Tany@ukr.net", new Date(), 2222));
    }

    @AfterClass
    public static void destroyClass() {
        Db.getEmployees().remove(new Employee(12L, "Roman", "vigmol@ukr.net", new Date(), 8985));
        Db.getEmployees().remove(new Employee(19, "Sergey", "sergey@mail.net", new Date(), 8999));
        Db.getEmployees().remove(new Employee(52, "Tany", "Tany@ukr.net", new Date(), 2222));
    }

    @Before
    public void init() {
        dao = new JdbcEmployeeDao();
    }

    @Test
    public void findAllEmployee() {
        assertNotNull("Проверка ", dao.findAll());
        assertEquals("Проверка всех employees в БД", 3, dao.findAll().size());
    }

    @Test
    public void addEmployee() {
        try {
         dao.create(null);
            fail("");
        } catch (NullPointerException e) {
        }
        dao.create(new Employee(52, "Vova", "Vova@ukr.net", new Date(), 2582));
        assertEquals(4,dao.findAll().size());
    }
    @Test
    public void findByGoodId(){
        Employee roman = new Employee(12L, "Roman", "vigmol@ukr.net", new Date(), 8985);
        Employee byId = dao.findById(12L);
        assertNotNull(byId);
        assertEquals(roman,byId);
    }

    @Test
    public void findByBadId(){
        Employee byId = dao.findById(1888L);
        assertNull(byId);
    }
}
