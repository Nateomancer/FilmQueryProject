package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {



	// film table
	private int id;// Primary Key //foreign key in actor and language tables
	private String title;
	private String description;
	private Integer releaseYear;
	private int languageId; // Foreign key in film table. //Primary in language table
	private int rentalDuration;
	private double rentalRate;
	private Integer length;
	private double replacementCost;
	private String rating;
	private String features;
	
	private List<Actor> cast;// holds a list of actors from actor class/table
	private String filmLanguage;// from language table

	// Default constructor
	public Film() {

	}

	// Primary constructor
	public Film(int id, String title, String description, Integer releaseYear, int languageId, int rentalDuration,
			double rentalRate, Integer length, double replacementCost, String rating, String features, List<Actor> cast,
			String filmLanguage) {
		super();
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
		this.cast = cast;
		this.filmLanguage = filmLanguage;
	}

	// filmSearch constructor
	public Film(int id, String title, String description, int year, String rating) {

		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = year;
		this.rating = rating;

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

	public List<Actor> getCast() {
		return cast;
	}

	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}

	public String getFilmLanguage() {
		return filmLanguage;
	}

	public void setFilmLanguage(String filmLanguage) {
		this.filmLanguage = filmLanguage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cast, description, features, filmLanguage, id, languageId, length, rating, releaseYear,
				rentalDuration, rentalRate, replacementCost, title);
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
				&& Objects.equals(features, other.features) && Objects.equals(filmLanguage, other.filmLanguage)
				&& id == other.id && languageId == other.languageId && Objects.equals(length, other.length)
				&& Objects.equals(rating, other.rating) && Objects.equals(releaseYear, other.releaseYear)
				&& rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "[Film ID]" + id + " [Title] " + title + " [Description] " + description + " [ReleaseYear] "
				+ releaseYear + " [Language Id] " + languageId + ", [rentalDuration]" + rentalDuration
				+ ", [Rental Rate] " + rentalRate + " [Length] " + length + " [Replacement Cost]" + replacementCost
				+ ", [Rating] " + rating + " [Features] " + features + " [Cast]" + cast + " [filmLanguage] "
				+ filmLanguage;
	}

}