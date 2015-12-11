package IMDB_Search.Models;

/**
 * Created by SACHIN on 12/8/2015.
 */
public class Movie {
    private String name; //Movie's name
    private String year; //Movie's release year
    private String info; //Movie's information...contains its runtime,genre's information etc
    private String rating; //Movie's rating
    private String mv_link; //Movie's link to IMDB_page
    private String mv_img_link; //Movie's image link
    private Review[] reviews=new Review[3]; //Movie's top 3 reviews
    public Movie() {
        for(int i=0;i<3;i++) {
            reviews[i]=new Review();
        }
    }

    public Movie(String name, String year, String info, String rating, String mv_link, String mv_img_link, Review[] reviews) {
        this.name = name;
        this.year = year;
        this.info = info;
        this.rating = rating;
        this.mv_link = mv_link;
        this.mv_img_link = mv_img_link;
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getMv_link() {
        return mv_link;
    }

    public void setMv_link(String mv_link) {
        this.mv_link = mv_link;
    }

    public String getMv_img_link() {
        return mv_img_link;
    }

    public void setMv_img_link(String mv_img_link) {
        this.mv_img_link = mv_img_link;
    }

    public Review[] getReviews() {
        return reviews;
    }

    public void setReviews(Review[] reviews) {
        this.reviews = reviews;
    }
}
