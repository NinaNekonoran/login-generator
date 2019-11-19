package geco;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    LoginService loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
    LoginGenerator lg = new LoginGenerator(loginService);
    @Test
    public void generateLoginForNomAndPrenom() {
        //CT1 : quand on génère le login de "Paul Durand", on vérifie que le login
        //généré et ajouté à la liste des logins existants est "PDUR".
        assertEquals(lg.generateLoginForNomAndPrenom("Durand","Paul"), "PDUR");
        assertTrue(loginService.loginExists("PDUR"));

        // quand on génère le login
        //de "John Ralling", on vérifie que le login généré et ajouté à la liste des logins
        //existants est "JRAL2".
        assertEquals(lg.generateLoginForNomAndPrenom("Ralling","John"), "JRAL2");
        assertTrue(loginService.loginExists("JRAL2"));

        //CT2 : quand on génère le login de "Jean Rolling", on vérifie que le login
        //généré et ajouté à la liste des logins existants est "JROL1" ;
        assertEquals(lg.generateLoginForNomAndPrenom("Rolling","Jean"), "JROL1");
        assertTrue(loginService.loginExists("JROL1"));

        //CT3 : quand on génère le login de "Paul Dùrand", on vérifie que le login
        //généré et ajouté à la liste des logins existants est "PDUR".
        assertEquals(lg.generateLoginForNomAndPrenom("Dùrand","Paul"), "PDUR1");
        assertTrue(loginService.loginExists("PDUR1"));
    }
}