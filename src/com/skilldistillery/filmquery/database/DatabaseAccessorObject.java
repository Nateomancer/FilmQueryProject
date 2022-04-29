package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String user = "student";
	private static final String pass = "student";
	
	
	
  @Override
  public Film findFilmById(int filmId) {
	  
	  Film film=null;
	  
	  //Makes connection to database
	  String sql = "SELECT * FROM film where id=?";
	  Connection conn = DriverManager.getConnection(URL, user, pass);
		
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  stmt.setInt(1, filmId);
	  
	  ResultSet rs = stmt.executeQuery();
	  
	  
	  while (rs.next()) {
			System.out.println("Film Id: " + rs.getInt("id") + " " + "Film Title: " + rs.getString("title") + " "
					+ "Description: " + rs.getString("description") + " Release Year: " + rs.getShort("release_Year")+
				" Language ID: "+rs.getInt("language_id")+ " Rental Duration: "+ rs.getInt("rental_duration")+ "Rental Rate: "+rs.getDouble("rental_cost")+ "length"+rs.getInt("length")+ "Replacement Cost: "+rs.getDouble("replacement_cost")+"Film Rating: "+rs.getString("rating")+ " Special Features: "+rs.getString("special_features"));	
		}
	  
		rs.close();
		stmt.close();
		conn.close();
	  
    return Film;
  }

@Override
public Actor findActorById(int actorId) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Actor> findActorsByFilmId(int filmId) {
	// TODO Auto-generated method stub
	return null;
}
  
  

}

