import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        String hidden_word = "johan";//Palabra que tiene que adivinar el usuario
        int max_atts = 10;//Número de intentos máximos para adinivar la palabra
        int atts = 0;//Intentos que lleva el usuario 
        boolean guessed_word = false;//Variable para el estado de la palabra (adivinada o no)

        char[] current_word = new char[hidden_word.length()];
        //Asign the corresponding numbers of underlines in the target word 
        for (int i = 0; i < current_word.length; i++) {
            current_word[i] = '_';
        }

        while(!guessed_word && atts<max_atts){//Loop to ask the user for a letter
            System.out.println("Word to be guessed "+String.valueOf(current_word));//Show hidden word length
            System.out.println("Enter the letter: ");
            char given_letter =  scanner.nextLine().toLowerCase().charAt(0);//Input the letter

            boolean correct_letter = false;
            //Loop to check each inputted letter 
            for (int i = 0; i < current_word.length; i++) {
                //Compares if the given letter equals to the letter in the current loop index
                if(hidden_word.charAt(i) == given_letter){
                    current_word[i] = given_letter;//Therefore if the letter is right will be assigned on the array
                    //And the control variable gets the value of true so the user does not loses attemtps
                    correct_letter = true;
                }

            }

            if(!correct_letter){//Evalulate if the given letter was not right 
                atts++;//If not guessedm the number of attempts has to increase per 1
                //Tell the user they was wrong and show how many attemtps are left
                System.out.println("The letter was wrong, your numb of attempts is: "+(max_atts-atts));
            }
            if(String.valueOf(current_word).equals(hidden_word)){
                guessed_word=true;
                System.out.println("Conrgatulations!! The word was succesfully guessed ("+hidden_word+")");
            }
        }

        if(!guessed_word){
            System.out.println("Sorry the word wasn't guessed... GAME OVER!");
            System.out.println("The correct word was: "+hidden_word);
        }
        scanner.close();
    }
}