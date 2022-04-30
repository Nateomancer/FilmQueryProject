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

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String user = "student";
	private static final String pass = "student";

	@Override
	public Film findFilmById(int filmId) throws SQLException {

		Film film = null;

		// Makes connection to database
		String sql = "SELECT * FROM film where id=?";
		Connection conn = DriverManager.getConnection(URL, user, pass);

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			// get film and all attributes by filmId
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

			// create list of actors for each film
			List<Actor> filmCast = new ArrayList<>();
			filmCast.addAll((findActorsByFilmId(filmId)));

			// get the language for each film
			getLanguage(filmId);

			film = new Film(id, title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
					replacementCost, rating, specialfeatures, filmCast, getLanguage(filmId));

		}

		rs.close();
		stmt.close();
		conn.close();

		return film;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {

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

		List<Actor> actors = new ArrayList<>();

		// Makes connection to database
		String sql = "SELECT * from actor a join film_actor fa on fa.actor_id =a.id join film f on f.id = fa.film_id where f.id = ?";

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

	@Override
	public List<Film> findFilmByKeyword(String keyword) throws SQLException {

		Film matchedFilm = null;
		List<Film> filmResults = new ArrayList<>();
		List<Actor> filmCast = new ArrayList<>();
		Film film = null;
		int counter = 0;

		// Makes connection to database
		String sql = "SELECT id, title, description, release_year, rating FROM film WHERE description LIKE ? OR title LIKE ?";

		Connection conn = DriverManager.getConnection(URL, user, pass);

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, "%" + keyword + "%");
		stmt.setString(2, "%" + keyword + "%");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			counter++;
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String description = rs.getString("description");
			Integer releaseYear = rs.getInt("release_year");
			String rating = rs.getString("rating");

			matchedFilm = new Film(id, title, description, releaseYear, rating);

			filmResults.add(matchedFilm);

		}

		rs.close();
		stmt.close();
		conn.close();

		return filmResults;
	}

	@Override
	public String getLanguage(int filmId) throws SQLException {

		String sql = "SELECT f.title, f.language_id, l.name FROM film f JOIN language l ON f.language_id = l.id WHERE f.id = ?";

		Connection conn = DriverManager.getConnection(URL, user, pass);

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, filmId);

		ResultSet rs = stmt.executeQuery();

		String languageName = null;

		while (rs.next()) {

			String filmTitle = rs.getString("title");
			int filmLanguageId = rs.getInt("language_id");
			languageName = rs.getString("name");

			return languageName;
		}
		return languageName;

	}

}
