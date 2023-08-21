package wordle;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Wordle {
    private List<String> possibleWords = new ArrayList<String>();

    private static final int MAX_WORD_LENGTH = 5;
    
    public Wordle(){
        try {
            File Obj = new File("words.txt");
            Scanner Reader = new Scanner(Obj);
            while (Reader.hasNextLine()) {
                String word = Reader.nextLine().toUpperCase();
                possibleWords.add(word);
            }
            Reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        Collections.shuffle(possibleWords);

    }

    
    
    public String guessWord(){
        return possibleWords.get(0);
    }

    public int getSize(){
        return possibleWords.size();
    }
    
    
    

    public static boolean checkGreen(String guessedWord, String currentWord, List<Integer> greenList){

        for(int index: greenList){
            if(guessedWord.charAt(index) != currentWord.charAt(index))
                return false;
        }
        
        return true;
    }

    public static boolean checkYellow(String guessedWord, String currentWord, List<Integer> yellowList){
        
        for(int index: yellowList){
            if(currentWord.indexOf(guessedWord.charAt(index)) == -1 || 
            		currentWord.substring(index, index + 1).equals(guessedWord.substring(index, index + 1)))
                return false;
        }
        
        return true;
    }

    public static boolean checkAbsent(String guessedWord, String currentWord, List<Integer> absentList){

        for(int index: absentList){
            if(currentWord.indexOf(guessedWord.charAt(index)) != -1)
                return false;
        }
        
        return true;
    }

    public static List<Integer> getPresentList(List<Integer> greenList, List<Integer> yellowList){
        List<Integer> presentList = new ArrayList<Integer>();

        for(Integer i: greenList){
            presentList.add(i);
        }
        for(Integer i: yellowList){
            presentList.add(i);
        }

        return presentList;
    }

    
    public List<Integer> getAbsentList(List<Integer> presentList){
        String matchedLetters = "";
        String currentWord = guessWord();

        for(int i: presentList){
            matchedLetters += currentWord.substring(i, i + 1);
        }

        List<Integer> absentList = new ArrayList<Integer>();
        for(int i = 0; i < MAX_WORD_LENGTH; i++){
            if(matchedLetters.indexOf(currentWord.substring(i, i + 1)) == -1){
                absentList.add(i);
            }
        }

        return absentList;
    }

    
    
    
    
    public void shortlistWords(List<Integer> greenList, List<Integer> yellowList){
        String guessedWord = guessWord();

        List<Integer> presentList = getPresentList(greenList, yellowList);
        List<Integer> absentList = getAbsentList(presentList);

        List<String> nextPossibleWords = new ArrayList<String>();

        for(int i = 1; i < getSize(); i++){
            String currentWord = possibleWords.get(i);
            if(checkGreen(guessedWord, currentWord, greenList) &&
               checkYellow(guessedWord, currentWord, yellowList) &&
               checkAbsent(guessedWord, currentWord, absentList)){
                nextPossibleWords.add(currentWord);
            }
        }

        possibleWords = nextPossibleWords;
    }

}
