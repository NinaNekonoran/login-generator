package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {
    String[] loginsExistants = {"coucou","non"};
    LoginService ls = null;
    @Before
    public void setUp() throws Exception {
        String[] loginsExistants = {"coucou","non"};
        ls = new LoginService(loginsExistants);
    }

    @Test
    public void loginExists() {
        assertTrue(ls.loginExists("coucou"));
        assertFalse(ls.loginExists("qsfqsdfqs"));
    }

    @Test
    public void addLogin() {
        assertFalse(ls.loginExists("Bonjour"));
        ls.addLogin("Bonjour");
        assertTrue(ls.loginExists("Bonjour"));
    }

    @Test
    public void findAllLoginsStartingWith() {
        List<String> resultats = new ArrayList<>();
        assertTrue(ls.findAllLoginsStartingWith("cou") instanceof List);
        assertEquals(resultats, ls.findAllLoginsStartingWith("cou"));
    }

    @Test
    public void findAllLogins() {
        List<String> resultats = new ArrayList<>();
        resultats.add(loginsExistants[0]);
        resultats.add(loginsExistants[1]);
        assertEquals(ls.findAllLogins(),resultats);
    }
}