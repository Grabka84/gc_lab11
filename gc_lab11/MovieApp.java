package gc_lab11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MovieApp {

	static Set<String> movieSet = new TreeSet<>(); // new set of strings of movie names in alphabetical order, between multiple methods
	
	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in); // new scanner to take user inputs
		List<Movie> movieList = new ArrayList<Movie>(100); // new array list of size 100
		Set<String> catSet = new TreeSet<>(); // new set of strings of categories in alphabetical order
		String userCon = "y"; // while userContinue = y, will loop the program using do loop
		int userCategorySelect; // when choosing a category, will ask for an integer input
		
		// create a new list using the movies in the MovieIO file
		for(int i = 1; i <= 100; i++) {
			movieList.add(MovieIO.getMovie(i));
		}
		
		// create the set of categories based on the movie list
		for (Movie thisMovie : movieList) {
			catSet.add(thisMovie.getCategory());
		}
		
		DisplayHeader();
		DisplayMenu();
		
		do {
			System.out.print("Please choose one of the options from the categories (enter any number between 1-7, 0 exits): ");
			try {
				userCategorySelect = scnr.nextInt(); // get an integer value from user
				scnr.nextLine(); // clear the scanner
				// if not an integer, go back to start of do loop
			} catch (Exception ex) {
				System.out.println("Please enter an integer value between 1-7: "); 
				scnr.nextLine(); // clear the scanner
				continue;
			}
			
			switch (userCategorySelect) {
			case 0:
				break;
			case 1:
				movieSet.clear(); // clear the existing movie set
				createMovieSet("animated", movieList); // create the movie set based on string category 'animated'
				displayMovieSet("animated", movieSet); // display the movie set based on what was created in createMovieSet
				break; // end switch case
			case 2: 
				movieSet.clear();
				createMovieSet("comedy", movieList);
				displayMovieSet("comedy", movieSet);
				break;
			case 3:
				movieSet.clear();
				createMovieSet("drama", movieList);
				displayMovieSet("drama", movieSet);
				break;
			case 4:
				movieSet.clear();
				createMovieSet("horror", movieList);
				displayMovieSet("horror", movieSet);
				break;
			case 5:
				movieSet.clear();
				createMovieSet("musical", movieList);
				displayMovieSet("musical", movieSet);
				break;
			case 6:
				movieSet.clear();
				createMovieSet("scifi", movieList);
				displayMovieSet("scifi", movieSet);
				break;
			default:
				System.out.println("You have entered an invalid number");
				continue;
			}
			
			System.out.print("Would you like to choose another category? (y or Y to continue, any other key exits): ");
			userCon = scnr.nextLine();
			if (userCon.equalsIgnoreCase("y")) {
				System.out.println();
				DisplayMenu();
			}
			
		} while (userCon.equalsIgnoreCase("y"));
		
		System.out.println("Goodbye!");
		scnr.close();
	}
	
	public static void DisplayHeader(){
		System.out.println("Welcome to the Movie List Application!");
		System.out.println("This program will list movies by category");
		System.out.println();
	}
	
	public static void DisplayMenu() {
		System.out.println("There are 100 movies in this list. Once you select a category, the movies will be listed.");
		System.out.println("1. Animated");
		System.out.println("2. Comedy");
		System.out.println("3. Drama");
		System.out.println("4. Horror");
		System.out.println("5. Musical");
		System.out.println("6. Science fiction");
		System.out.println("");
	}
	
	public static void createMovieSet(String category, List<Movie> movieList) {
		for(Movie movie : movieList) {
			if(movie.getCategory() == category) {
				movieSet.add(movie.getTitle());
			}
		}
	}
	
	public static void displayMovieSet(String category, Set<String> movieSet) {
		System.out.println();
		System.out.println("You have selected to view all " + category + " movies.");
		for (String movie : movieSet) {
			System.out.println(movie);
		}
		System.out.println();
	}
	
}
