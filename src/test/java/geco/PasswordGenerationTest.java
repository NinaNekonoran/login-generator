package geco;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordGenerationTest {

    PasswordGeneration pt = new PasswordGeneration();
    @Test
    public void getRandomPassword() {
        String res = pt.getRandomPassword();
        assertTrue(res.length() == 8);
    }
}