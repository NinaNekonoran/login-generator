package geco;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    LoginService loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
    LoginGenerator lg = new LoginGenerator(loginService);
    @Test
    public void generateLoginForNomAndPrenom() {

        assertEquals(lg.generateLoginForNomAndPrenom("Durand","Paul"), "PDUR");
        assertTrue(loginService.loginExists("PDUR"));

        assertEquals(lg.generateLoginForNomAndPrenom("Ralling","John"), "JRAL2");
        assertTrue(loginService.loginExists("JRAL2"));

        assertEquals(lg.generateLoginForNomAndPrenom("Rolling","Jean"), "JROL1");
        assertTrue(loginService.loginExists("JROL1"));

        assertEquals(lg.generateLoginForNomAndPrenom("Dùrand","Paul"), "PDUR1");
        assertTrue(loginService.loginExists("PDUR1"));

        //CT : Quand on génère le login de "Paul Du", on vérifie que le login généré et ajouté à
        //la liste des logins existants est "PDU".
        assertEquals(lg.generateLoginForNomAndPrenom("Du","Paul"), "PDU");
        System.out.println("----");
        assertTrue(loginService.loginExists("PDU"));
    }
}