import java.util.Scanner;
public class RandomNumberGuesser{

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int randNum, nextGuess, highGuess=100, lowGuess=0, numGuess=0;
		String response;
		boolean validGuess;
		do {
			randNum=RNG.rand();
			System.out.println(randNum);
			System.out.println("Enter a guess");
			nextGuess=sc.nextInt();
			sc.nextLine();
			validGuess=RNG.inputValidation(nextGuess, lowGuess, highGuess);
			while (validGuess==true) {
				if (nextGuess==randNum) {
					System.out.println("Congratulations, you guessed correctly!");
					highGuess=100;
					lowGuess=0;
					randNum=RNG.rand();
					numGuess=0;
					break;
				}
				if (nextGuess<randNum) {
					numGuess++;
					lowGuess=nextGuess;
					System.out.println("Number of guesses is "+numGuess);
					System.out.println("Your guess is too low");
					System.out.println("Enter a guess between "+(nextGuess)+" and "+highGuess);
					nextGuess=sc.nextInt();
					sc.nextLine();
					validGuess=RNG.inputValidation(nextGuess, lowGuess, highGuess);
				}
				if (nextGuess>randNum) {
					numGuess++;
					highGuess=nextGuess;
					System.out.println("Number of guesses is "+numGuess);
					System.out.println("Your guess is too high");
					System.out.println("Enter a guess between "+lowGuess+" and "+(nextGuess));
					nextGuess=sc.nextInt();
					sc.nextLine();
					validGuess=RNG.inputValidation(nextGuess, lowGuess, highGuess);
				}
			}
			System.out.println("Try again? (yes or no)");
			response=sc.nextLine();
		} while(response.equals("Yes") || response.equals("yes") || response.equals("y") || response.equals("Y"));
	
		if (response.equals("No") || response.equals("no") || response.equals("n") || response.equals("N")) {
			System.out.println("Thanks for playing...");
		}
		sc.close();
	}
}
