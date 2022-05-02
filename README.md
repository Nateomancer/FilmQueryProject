# FilmQueryProject

## Description

This program uses a MySQL database for rental a video store.  The tables used in this project are called, Film, film-actor, actor, and language.
On start up the title is displayed and then a menu where they can select three options.  They can search for a film baed on the filmId, numbered 1-1000, or they can search for a film based on a keyword in either the film's title or description.  The queries used are basic select statements, join statements, and statements with pattern matching. The last option is to exit the program which ends the loop while loop it is contained in. The program connects to the MySQL database using the java JDBC API.

The java classes, are FilmQueryApp(Contains main method), Database Accessor (interface class), DatabaseAccessorObject, film, and actor.

The FilmQuery App contains the main method and user interface. The DatabaseAccessorObject class implements the Database accessor, and makes the connection to the MySQL database. It also contains all the sql queries. When the query returns a result that is not null, a film or actor object is instantiated, and then is output to the console returning the users query results, which can include the requested film and it's fields, a list of the actors in the film, and the language the film is in.

##Technologies used

Mac OS
Eclipse
Java 8
JDBC
Maven
MAMP
MySQL
Mac Terminal
ZSH
