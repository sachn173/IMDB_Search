package IMDB_Search.Models;

/**
 * Created by SACHIN on 12/8/2015.
 */
public class Review {
    private String heading; //Review heading..stores title of the review
    private String author; //Review author...stores author_name with the place from where author belongs
    private String desc; //Review description.... a large text representing a review
    public Review() {

    }

    public Review(String heading, String author, String desc) {
        this.heading = heading;
        this.author = author;
        this.desc = desc;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
