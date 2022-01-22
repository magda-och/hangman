import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello ! Write a word, that other players will guess. ");
        String wordToGuess = scanner.nextLine();

        ArrayList<Character> lettersOfWordToGuess = new ArrayList<Character>();
        for (char c : wordToGuess.toCharArray()) {
            lettersOfWordToGuess.add(Character.toLowerCase(c));
        }

        ArrayList <Character> guessingWord = new ArrayList<Character>();
        for (int i = 0; i < lettersOfWordToGuess.size(); i++){
            guessingWord.add('*');
        }

        System.out.println("Now, we're starting the game. Please, guess one od the letters of the world to guess. This world has " + lettersOfWordToGuess.size() + " letters.");
        int amountOfLife = 3;
        int guessLetters = 0;
        while (amountOfLife > 0) {
            System.out.println("\nPlease, write your letter");
            char selectedLetter = Character.toLowerCase(scanner.next().charAt(0));
            if(!lettersOfWordToGuess.contains(selectedLetter)){
                amountOfLife--;
                if(amountOfLife != 0){
                    System.out.println("\nThe word doesn't contain this letter. You lost one life. You still have " + amountOfLife + " life. Keep guessing");
                }
                continue;
            }
            int i = 0;
            for (Character x : lettersOfWordToGuess) {
                if (x.equals(selectedLetter)) {
                    System.out.println("The letter you entered is in that word and it's " + (i + 1) + ". letter");
                    guessLetters++;
                    guessingWord.set(i, x);
                }
                i++;
            }
            System.out.println("This is your word at the moment");
            for (char b: guessingWord){
                System.out.print(b);
            }
            if (guessLetters == lettersOfWordToGuess.size() ){
                System.out.println("\nCongratulation. You won the game. This is the word : " + wordToGuess);
                break;
            }
        }
        if (amountOfLife == 0){
            System.out.println("You lost this game.");
        }
        System.out.println("\nThis is the end of the game");
        }
    }


