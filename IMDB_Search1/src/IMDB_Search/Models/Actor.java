package IMDB_Search.Models;

/**
 * Created by SACHIN on 12/8/2015.
 */
public class Actor {
    private String name; //Actor's name
    private Movie[] movies=new Movie[3]; //Actor's top 3 movie
    public Actor( ) {
        for(int i=0;i<3;i++) {
            movies[i]=new Movie();
        }
    }

    public Actor(String name, Movie[] movies) {
        this.name = name;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }
}
