package wordle;
import java.util.*;

/*
 * 
 * WORDS
 * 
 */

public class Testing {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Wordle game1 = new Wordle();


        
        for(int turn = 0; turn < 10; turn++){
            System.out.println("Computer's guess: " + game1.guessWord());

            List<Integer> greenList = new ArrayList<Integer>();
            List<Integer> yellowList = new ArrayList<Integer>();

            System.out.print("GREEN INDICES: ");
            String[] greenString = sc.nextLine().split(" ");
            for(int i = 0; i < greenString.length; i++){
                greenList.add(Integer.valueOf(greenString[i]));
            }

            System.out.print("YELLOW INDICES: ");
            String[] yellowString = sc.nextLine().split(" ");
            for(int i = 0; i < yellowString.length; i++){
                yellowList.add(Integer.valueOf(yellowString[i]));
            }

            if(greenList.size() == 5){
                System.out.println("Computer has successfully guessed your word!! " + game1.guessWord());
                break;
            }

            game1.shortlistWords(greenList, yellowList);
        }
        
        sc.close();
    }
}