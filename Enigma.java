public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            char outerChar2 = message.charAt(i); //get outer character from message
            int outerIndex = rotors[2].indexOf(outerChar2); //find corresponding position in outer rotor (2)
            char middleChar = rotors[1].charAt(outerIndex); //get matching first middle char from outer index
            int middleIndex = rotors[2].indexOf(middleChar); //find corresponding position of outer char from middle char
            char ogChar = rotors[0].charAt(middleIndex); //get matching inner char from middle index 
            result += ogChar;
            rotate();
        }
        return result;
    }


    
    public String encrypt(String message){ 
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            char ogChar = message.charAt(i); //get character 1 from message
            int innerIndex = rotors[0].indexOf(ogChar); // find corresponding position in inner rotor (0)
            char outerChar1 = rotors[2].charAt(innerIndex); // get matching outer char for first pass 
            int middleIndex = rotors[1].indexOf(outerChar1); // find corresponding position of outer char in middle rotor (1)
            char outerChar2 = rotors[2].charAt(middleIndex); // get matching char from outside rotor (2)
            result += outerChar2;
            rotate();
        }
        return result;
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()) {
                rotors[2].rotate();
            }
        }
    }
    
}
