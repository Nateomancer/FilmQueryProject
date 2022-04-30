package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	
//	LAB 1.A
//	Complete the Film class with attributes that map to the columns of the film table.
//	Use appropriate datatypes and Java naming conventions. Provide getters and setters, and appropriate constructors.
//	Also add a good toString, and equals and hashCode methods.
	
	
	

	// list of the movie cast
	private List<Actor> cast;

	// film table
	private int id;// Primary Key
	private String title;
	private String description;
	private Integer releaseYear;
	private int languageId; // Forgein key in film table. //Primary in language table
	private int rentalDuration;
	private double rentalRate;
	private Integer length;
	private double replacementCost;
	private String rating;
	private String features;
	

	// Default constructor
	public Film() {

	}

	// Primary constructor
	/*List<Actor> actors*/
	public Film( int id, String title, String description, int releaseYear, int languageId,
			int rentalDuration, double rentalRate, int length, double replacementCost, String rating, String features, List<Actor> cast) {
		super();
		//this.actors = actors;
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = (int) releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.features = features;
		this.cast=cast;
	}
	
	
	
	
//TOSTRING
	
	
	@Override
	public String toString() {
		return "Film [cast=" + cast + ", id=" + id + ", title=" + title + ", description=" + description
				+ ", releaseYear=" + releaseYear + ", languageId=" + languageId + ", rentalDuration=" + rentalDuration
				+ ", rentalRate=" + rentalRate + ", length=" + length + ", replacementCost=" + replacementCost
				+ ", rating=" + rating + ", features=" + features + "]";
	}
	
//HASHCODE

	@Override
	public int hashCode() {
		return Objects.hash(cast, description, features, id, languageId, length, rating, releaseYear, rentalDuration,
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
		return Objects.equals(cast, other.cast) && Objects.equals(description, other.description)
				&& Objects.equals(features, other.features) && id == other.id && languageId == other.languageId
				&& Objects.equals(length, other.length) && Objects.equals(rating, other.rating)
				&& Objects.equals(releaseYear, other.releaseYear) && rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(title, other.title);
	}
	
	//GETTERS AND SETTERS

	public List<Actor> getCast() {
		return cast;
	}

	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	
	

}