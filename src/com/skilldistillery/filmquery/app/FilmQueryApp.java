package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		
		System.out.println("\nTHANKYOU FOR COMING TO THE QUICKSHOP VIDEO RENTAL TERMINAL\n"
				+ "WE ABADONED BLOCKBUSTER FOR NETLIX, AND NOW NETFLIX IS DYING\n"
				+ "HOPE YOU LIKE COMMAND PROMPTS\n");

		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		app.launch();
	}

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) throws SQLException {

		boolean menu = true;
		while (menu == true) {

			// print interface to the console
			printInterface(input);

			// get user input
			int userMenuSelection = getUserInput(input);

			switch (userMenuSelection) {

			case 1:

				// FINDS FILM MATCHING THE ID THE USER ENTERED

				System.out.println("Please enter film id number");
				try {

					Film film = null;
					int filmId;
					input.nextLine();
					filmId = input.nextInt();

					// checks user input
					if (filmId > 0) {

						film = db.findFilmById(filmId);

						// checks if film is null
						if (film != null) {

							System.out.println("1...\n2...\n3... \nQuery Succesful.\n");

							// print the film title, year, rating, and description
							System.out.println("TITLE: " + film.getTitle() + "\nRELEASE YEAR: " + film.getReleaseYear()
									+ "\nRating: " + film.getRating() + "\nDESCRIPTION: " + film.getDescription()
									+ "\n");

							// print the language
							System.out.println("FILM LANGUAGE: " + film.getFilmLanguage());

							// print the cast
							System.out.println("FILM CAST:");
							for (Actor actor : film.getCast()) {

								System.out.println(actor);

							}

							System.out.println("");

						} else if (film == null) {
							System.out.println("NO RESULTS\n"

									+ "\nOOPS, I nulled again,\n" + "I played with your code, got lost in queries\n"
									+ "Oh user, You think I have everything\n" + "But I'm not that acurate\n"

									+ "That search term didn't have any matches.");
						}

					}
				} catch (InputMismatchException e) {
					input.nextLine();
					System.out.println("\nCRUD! That was an invalid Input\n" + "Please try again");
					break;
				}
				break;

			case 2:

				// FINDS FILM MATCHING THE KEYWORD USER ENTERED

				List<Film> filmResults = new ArrayList<>();

				System.out.println("Please enter a search keyword");
				try {
					input.nextLine();
					String keyword = input.next();

					filmResults.addAll(db.findFilmByKeyword(keyword));
					int size = filmResults.size();
					if (size != 0) {

						int counter = 0;
						System.out.println("\nPrinting Results...\n");
						for (Film films : filmResults) {
							if (films != null) {
								counter++;
								System.out.println("Film ID: " + films.getId() + "\nTITLE:\t" + films.getTitle()
										+ "\nDESCRIPTION:  " + films.getDescription() + "\nREALESE YEAR:  "
										+ films.getReleaseYear() + "  RATING:  " + films.getRating());
								System.out.println("\n");
							}
						}

						System.out.println("LISTING " + counter + " RESULTS FOR " + keyword + "\n");
					}

					else if (size == 0) {
						System.out.println("NO RESULTS\n"

								+ "\nOOPS, I nulled again,\n" + "I played with your code, got lost in queries\n"
								+ "Oh user, You think I have everything\n" + "But I'm not that acurate\n\n");
					}

				} catch (InputMismatchException e) {
					input.nextLine();
					System.out.println("\nCRUD! That was an invalid Input\n" + "Please try again\n");
					break;
				}

				break;

			case 3:
				// EXIT THE PROGRAM
				System.out.println("Goodbye");
				menu = false;
				break;

			default:
				continue;

			}
		}

	}

	private void printInterface(Scanner input) {
		
		System.out.println("---MAIN MENU---");

		String[] options = { "1- Look up film with film ID", "2- Look up film by a search Keyword",
				"3- Exit the application" };

		for (String option : options) {
			System.out.println(option);
		}

		System.out.println("\nPlease select an option");
	}

	private int getUserInput(Scanner input) {

		Scanner input3 = input;
		int userMenuSelection;

		try {
			userMenuSelection = input3.nextInt();
			if (userMenuSelection > 3 || userMenuSelection < 1) {

				input.nextLine();
				System.out.println("\nCRUD! That was an invalid Input\n" + "Please try again\n");
				return userMenuSelection = 0;

			}
		}

		catch (InputMismatchException e) {

			System.out.println("\nCRUD! That was an invalid input\n" + "please try again");
			return userMenuSelection = 0;

		}

		return userMenuSelection;

	}

}
