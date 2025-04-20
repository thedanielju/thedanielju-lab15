public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while (!this.rotate()) {
            this.rotate();
        }
    }

    //shifts rotor values one step to the right (clockwise)
    //save the last character and put at the start
    //check if a full rotation has been made
    public boolean rotate(){ 
        char[] charArray = rotorValues.toCharArray();
        
        char holdLast = charArray[charArray.length - 1];
        for (int i = charArray.length - 1; i > 0; i--) { 
            charArray[i] = charArray[i-1]; // shift each character to the right by setting each index to the value of the index before it
        } 

        charArray[0] = holdLast; //put saved last character as first character
        rotorValues = new String(charArray); 

        if (charArray[0] == startChar) { //check if rotor has completed a full cycle
            return true;
        } else {
            return false;
        }
    }
    
    //search for c in rotorValues
    //return index in the array
    //if not found, return -1
    public int indexOf(char c){
        int index = rotorValues.indexOf(c);
        return index;
    }

    //search for char at index
    //return char 
    //if index is invalid, return exception
    public char charAt(int idx){
        if (idx < 0 || idx >= rotorValues.length()) {
            throw new IndexOutOfBoundsException("this is invalid: " + idx);
        }
        return rotorValues.charAt(idx);
    }
}
    
