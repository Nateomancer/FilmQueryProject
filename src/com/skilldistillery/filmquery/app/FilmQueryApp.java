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

	public static void main(String[] args) throws SQLException, InterruptedException {

		System.out.println("   " + ""
				+ " ____  __  ______________ __    _____ __  ______  ____     _    __________  __________     _______________  ____  ______\n"
				+ "   / __ \\/ / / /  _/ ____/ //_/   / ___// / / / __ \\/ __ \\   | |  / /  _/ __ \\/ ____/ __ \\   / ___/_  __/ __ \\/ __ \\/ ____/\n"
				+ "  / / / / / / // // /   / ,<      \\__ \\/ /_/ / / / / /_/ /   | | / // // / / / __/ / / / /   \\__ \\ / / / / / / /_/ / __/   \n"
				+ " / /_/ / /_/ // // /___/ /| |    ___/ / __  / /_/ / ____/    | |/ // // /_/ / /___/ /_/ /   ___/ // / / /_/ / _, _/ /___   \n"
				+ " \\___\\_\\____/___/\\____/_/ |_|   /____/_/ /_/\\____/_/         |___/___/_____/_____/\\____/   /____//_/  \\____/_/ |_/_____/   \n"
				+ "                                                                                                                          \n"
				+ "" + "\n ");

		System.out.println("\n" + "     \t\t\t      ___\n" + "     \t\t\t  _.-|   |          |\\__/,|   (`\\\n"
				+ "     \t\t\t {   |   |          |o o  |__ _) )\n" + "     \t\t\t   -.|___|        _.( T   )  `  /\n"
				+ "    \t\t\t   .--'-`-.     _((_ `^--' /_<  \\\n" + "     \t\t\t .+|______|__.-||__)`-'(((/  (((/");

		System.out.println("");
		Thread.sleep(3000);

		FilmQueryApp app = new FilmQueryApp();
		app.clear();
		// app.test();
		app.launch();

	}

	private void launch() throws SQLException, InterruptedException {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) throws SQLException, InterruptedException {

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

					System.out.println("\n\n\n" + "" + "		  ,-.       _,---._ __   / \\\n"
							+ "		  /  )    .-'       `./ /   \\\n" + "		 (  (   ,'            `/    /|\n"
							+ "		  \\  `-\"             \\'\\   / |\n" + "		   `.              ,  \\ \\ /  |\n"
							+ "		    /`.          ,'-`----Y   |\n" + "		   (            ;        |   '\n"
							+ "		   |  ,-.    ,-'         |  /\n" + "		   |  | (   |            | /\n"
							+ "		   )  |  \\  `.___________|/\n" + "		   `--'   `--'");

					System.out.println("Searching...");
					Thread.sleep(2000);

					// checks user input
					if (filmId > 0) {

						film = db.findFilmById(filmId);

						// checks if film is null
						if (film != null) {

							System.out.println("\nQuery Succesful.\n");

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
							System.out.println("NO RESULTS\n" + "\nOOPS, I nulled again " + "¯\\_(ツ)_/¯");
							System.out.println("\n");

						}

					}
				} catch (InputMismatchException e) {
					input.nextLine();
					System.out.println("\nCRUD! That was an invalid Input\n" + "Please try again" + "¯\\_(ツ)_/¯");
					System.out.println("\n");
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

					System.out.println("\n\n\n" + "" + "		  ,-.       _,---._ __   / \\\n"
							+ "		  /  )    .-'       `./ /   \\\n" + "		 (  (   ,'            `/    /|\n"
							+ "		  \\  `-\"             \\'\\   / |\n" + "		   `.              ,  \\ \\ /  |\n"
							+ "		    /`.          ,'-`----Y   |\n" + "		   (            ;        |   '\n"
							+ "		   |  ,-.    ,-'         |  /\n" + "		   |  | (   |            | /\n"
							+ "		   )  |  \\  `.___________|/\n" + "		   `--'   `--'");

					System.out.println("Searching...");
					Thread.sleep(2000);

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
						System.out.println("\nNO RESULTS\n"

								+ "OOPS, I nulled again,\n" + "¯\\_(ツ)_/¯");
						System.out.println("");

					}

				} catch (InputMismatchException e) {
					input.nextLine();
					System.out.println("\nCRUD! That was an invalid Input\n" + "Please try again\n" + "¯\\_(ツ)_/¯");
					System.out.println("\n");
					break;
				}

				break;

			case 3:
				// EXIT THE PROGRAM
				System.out.println("\n\n");
				System.out.println("        *      MMMM8&&&            *\n" + "             MMMMM88&&&&&&    .\n"
						+ "            MMMMM88&&&&&&&&\n" + "*           MMMM88&&&&&&&&&\n"
						+ "            MMMM88&&&&&&&&&\n" + "             MMMM88&&&&&&&\n"
						+ "               MMMMM8&&&      *\n" + " \n" + "  *\n" + "         \n" + "         \n"
						+ "         \n" + "        |\\___/|\n" + "        )     (             .              '\n"
						+ "       =\\     /=\n" + "         )===(       *\n" + "        /     \\\n"
						+ "        |     |\n" + "       /       \\\n" + "       \\       /\n"
						+ "_/\\_/\\_/\\__  _/_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_\n"
						+ "|  |  |  |( (  |  |  |  |  |  |  |  |  |  |\n"
						+ "|  |  |  | ) ) |  |  |  |  |  |  |  |  |  |\n"
						+ "|  |  |  |(_(  |  |  |  |  |  |  |  |  |  |\n"
						+ "|  |  |  |  |  |  |  |  |  |  |  |  |  |  |\n"
						+ "|  |  |  |  |  |  |  |  |  |  |  |  |  |  |");

				System.out.println("Goodbye");
				menu = false;
				break;

			default:
				continue;

			}
		}

	}

	private void printInterface(Scanner input) {

		System.out.println(
				"       	     |\\__/,|   (`\\\n" + "  	   _.|o o  |_   ) )\n" + " ---MENU---(((---(((---------");

		String[] options = { "1- Look up film with film ID", "2- Look up film by a search Keyword",
				"3- Exit the application" };

		for (String option : options) {
			System.out.println(option);
		}

		System.out.println("\nPlease select an option");
		System.out.println("\n\n");
	}

	private int getUserInput(Scanner input) {

		Scanner input3 = input;
		int userMenuSelection;

		try {
			userMenuSelection = input3.nextInt();
			if (userMenuSelection > 3 || userMenuSelection < 1) {

				input.nextLine();
				System.out.println("\nCRUD! That was an invalid Input\n" + "Please try again\n" + "¯\\_(ツ)_/¯");
				System.out.println("\n");

				return userMenuSelection = 0;

			}
		}

		catch (InputMismatchException e) {

			System.out.println("\nCRUD! That was an invalid input\n" + "please try again\n" + "¯\\_(ツ)_/¯ \n");
			return userMenuSelection = 0;

		}

		return userMenuSelection;

	}

	public void clear() {
		for (int i = 0; i < 100; i++) {
			System.out.println("\n");
		}
	}

}
