package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {

		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		app.launch();
	}

//  private void test() throws SQLException {
//    Film film = db.findFilmById(1);
//    System.out.println(film);
//  }

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	
	
	private void startUserInterface(Scanner input) throws SQLException {

//	  User Story 1
//	  The user is presented with a menu in which they can choose to:
//
//	  Look up a film by its id.
//	  Look up a film by a search keyword.
//	  Exit the application.
		boolean menu = true;
		while (menu==true) {
			
			//print interface to the console
			printInterface();
			
			//get user input
			int userMenuSelection = getUserInput(input);
			
			switch (userMenuSelection) {

			case 1:
				
				//FINDS FILM MATCHING THE ID THE USER ENTERED
				
				System.out.println("Please enter film id");
				int filmId = input.nextInt();
				Film film = null;
				
				if (filmId>0) {
				film = db.findFilmById(filmId);
				System.out.println("1...\n2...\n3... \nQuery Succesful.");
				System.out.println(film);
				}else
					System.out.println("Query matched no results");
				break;
				
			case 2:
				
				//FINDS FILM MATCHING THE KEYWORD USER ENTERED
				System.out.println("Please enter a search keyword");
				String keyword = input.nextLine();
				// CALL METHOD
				break;
				
			case 3:
				//EXIT THE PROGRAM
				System.out.println("Goodbye");
				menu=false;
				break;
				
			default:
				continue;

			}
		}

	}

	private void printInterface() {

		String[] options = { "1- Look up film with film ID 1", "2- Look up film by a search Keyword 2",
				"3- Exit the application 3" };

		for (String option : options) {
			System.out.println(option);
		}

		System.out.println("Please select an option");
	}

	private int getUserInput(Scanner input) {

		int userMenuSelection;

		try {
			userMenuSelection = input.nextInt();
			if (userMenuSelection > 3 || userMenuSelection < 1) {

				input.nextLine();
				System.out.println("CRUD! That was an invalid Input \nPlease select an option from the menu");
				return userMenuSelection = 0;

			}
		}

		catch (InputMismatchException e) {
			input.nextLine();
			System.out.println("CRUD! That was an invalid input \nPlease select an option from the menu");
			return userMenuSelection = 0;

		} catch (Exception e) {
			return userMenuSelection = 0;

		}

		return userMenuSelection;

	}

}
