package controller;
import model.Alphabet;

public class AlphabetController
{
    Alphabet alphabet;
    
    public AlphabetController(final Alphabet alphabet) {
        this.alphabet = alphabet;
    }
    
    public void setAlphabet(final String alphabet) {
        this.alphabet.setAlphabet(alphabet);
    }
    
    public void addAphabet(final String alpahbet) {
        this.alphabet.addAlphabet(alpahbet);
    }
}