package geco;

import java.util.Random;

public class PasswordGeneration {
    public PasswordGeneration() {
    }

    public String getRandomPassword(){
        String mdp ="";
        Random rand = new Random();
        for(int i=0; i<8;i++){
            mdp += String.valueOf(((char)(rand.nextInt(26) + 97)));
        }
        return mdp;
    }
}
