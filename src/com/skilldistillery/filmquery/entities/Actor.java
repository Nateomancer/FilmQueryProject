package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Actor {

	private List<Film> films;

	private int id;// PRIMARY KEY IN ACTOR TABLE
	private String firstName;
	private String lastName;

	public Actor() {

	};

	public Actor(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Actor Id " + id + " First Name " + firstName + "  Last Name " + lastName;
	}

}
