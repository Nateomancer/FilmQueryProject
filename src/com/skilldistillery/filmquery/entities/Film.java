package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	
	//list of the movie cast
	private List<Actor> actors;
	
	//film table
	private int id;//Primary Key
	private String title;
	private String description;
	private short releaseYear;
	private int languageId; //Forgein key in film table. //Primary in language table
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String features;
	
	//Default constructor
	public Film() {
		
	}

	public Film(List<Actor> actors, int id, String title, String description, short releaseYear, int languageId,
			int rentalDuration, double rentalRate, int length, double replacementCost, String rating, String features) {
		super();
		this.actors = actors;
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.features = features;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actors, description, features, id, languageId, length, rating, releaseYear, rentalDuration,
				rentalRate, replacementCost, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(description, other.description)
				&& Objects.equals(features, other.features) && id == other.id && languageId == other.languageId
				&& length == other.length && Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Film [actors=" + actors + ", id=" + id + ", title=" + title + ", description=" + description
				+ ", releaseYear=" + releaseYear + ", languageId=" + languageId + ", rentalDuration=" + rentalDuration
				+ ", rentalRate=" + rentalRate + ", length=" + length + ", replacementCost=" + replacementCost
				+ ", rating=" + rating + ", features=" + features + "]";
	}
	
}