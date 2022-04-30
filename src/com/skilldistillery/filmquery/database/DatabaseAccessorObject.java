package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;




//ALL METHODS MUST RETURN A OBJECT. FILM, LIST<ACTOR> OR LIST<String>
public class DatabaseAccessorObject implements DatabaseAccessor {

	
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String user = "student";
	private static final String pass = "student";
	
	
	
	

	@Override
	public Film findFilmById(int filmId) throws SQLException {

		// LAB 3.A
		// Implement the findFilmById method that takes an int film ID,
		// and returns a Film object (or null, if the film ID returns no data.)

		Film film = null;

		// Makes connection to database
		String sql = "SELECT * FROM film where id=?";
		Connection conn = DriverManager.getConnection(URL, user, pass);

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			int id = filmId;
			String title = rs.getString("title");
			String description = rs.getString("description");
			Integer releaseYear = rs.getInt("release_year");
			int languageId = rs.getInt("language_id");
			int rentalDuration = rs.getInt("rental_duration");
			double rentalRate = rs.getDouble("rental_rate");
			Integer length = rs.getInt("length");
			double replacementCost = rs.getDouble("replacement_cost");
			String rating = rs.getString("rating");
			String specialfeatures = rs.getString("special_features");
			List<Actor> filmCast=new ArrayList<>();
			filmCast.addAll(filmCast);
			

			film = new Film(id, title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
					replacementCost, rating, specialfeatures, filmCast);
		}

		rs.close();
		stmt.close();
		conn.close();

		return film;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {

		// LAB 3.B
//		Implement findActorById method that takes an int actor ID,
//		and returns an Actor object (or null, if the actor ID returns no data.)

		Actor actor = null;

		// Makes connection to database
		String sql = "SELECT id, first_name, last_name FROM actor where id=?";
		Connection conn = DriverManager.getConnection(URL, user, pass);

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			int id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");

			actor = new Actor(id, firstName, lastName);

		}

		rs.close();
		stmt.close();
		conn.close();

		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {

//LAB 3.C		
//Implement findActorsByFilmId with an appropriate List implementation that will be populated using a ResultSet and returned.
//Make sure your JDBC code uses PreparedStatement with bind variables instead of concatenating values into SQL strings

		List<Actor> actors = new ArrayList<>();

		// Makes connection to database
		String sql = "select * from actor a join film_actor fa on fa.actor_id =a.id join film f on f.id = fa.film_id where f.id = ?";

		Connection conn = DriverManager.getConnection(URL, user, pass);

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			int id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");

			Actor actor = new Actor(id, firstName, lastName);

			actors.add(actor);
		}
		
		rs.close();
		stmt.close();
		conn.close();

		return actors;
	}

}
