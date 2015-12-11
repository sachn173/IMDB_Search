package IMDB_Search.Models;

import com.jaunt.*;
import com.jaunt.component.*;
import java.io.*;
/**
 * Created by SACHIN on 12/8/2015.
 */
public class IMDB_Search_performer {
    public Actor search(String search_name) {
        Actor actor=new Actor();
        actor.setName(search_name);
        //replacing all the spaces in requested_search_name with "%20"
        String mod_search_name=search_name.replaceAll(" ","%20");
        try{
            //creating a headless browser
            UserAgent userAgent = new UserAgent();
            //browsing the imdb_url with modified_search_name(all the spaces replaced with "%20") to perform actor_search
            userAgent.visit("http://www.imdb.com/find?ref_=nv_sr_fn&q="+mod_search_name+"&s=all");
            //Extracting the first search_result for actor_name
            Element ref_str_el=userAgent.doc.findFirst("<tr class=\"findResult odd\"").findFirst("<td class=\"result_text\"").findFirst("<a>");
            if(ref_str_el.innerHTML().compareToIgnoreCase(search_name.trim())!=0) { //if first search_result for actor_name didn't mach with requested actor_name then it will return null...representing no actor found with that name
                return null;
            }
            // actor_search is successfull and now we are searching for its top 3 movie(it doesn't include tv series..etc) according to ratings
            //extracting unique_reference_id for current actor...to form url for visiting its movie page
            String id=extractId(ref_str_el.getAt("href"));
            //visiting current actor movie's page
            userAgent.visit("http://www.imdb.com/filmosearch?explore=title_type&role="+id+"&ref_=filmo_ref_typ&sort=user_rating,desc&mode=detail&page=1&title_type=movie");
            //Extracting current_actor movie's list sorted in descending order of rating
            Elements movies_el=userAgent.doc.findFirst("<div class=\"lister-list\">").findEvery("<div class=\"lister-item mode-detail\"");

            //Extracting top 3 movies from movies_el list
            int cnt=0;

            Movie[] movies_list=new Movie[3]; //stores current actor top 3 movies

            for(Element el : movies_el) {
                movies_list[cnt]=new Movie();
                Element ell=el.findFirst("<a>");
                //storing movie name
                movies_list[cnt].setName(ell.findFirst("<img>").getAt("alt"));
                //storing movie link
                movies_list[cnt].setMv_link(ell.getAt("href"));
                //visiting movie_link to get its rating,year of release and etc
                userAgent.visit(movies_list[cnt].getMv_link());
                //storing rating,year,movie_image_link and its information bar(which contains runtime and etc)
                movies_list[cnt].setRating(formatRating(userAgent.doc.findFirst("<div class=\"star-box-details\">").findFirst("<a>").getAt("title")));
                movies_list[cnt].setYear(userAgent.doc.findFirst("<h1>").findFirst("<a>").innerHTML());
                movies_list[cnt].setMv_img_link(userAgent.doc.findFirst("<td id=\"img_primary\">").findFirst("<div class=\"image\">").findFirst("<img>").getAt("src"));
                movies_list[cnt].setInfo(userAgent.doc.findFirst("<div class=\"infobar\"").innerText().replaceAll("\\s+","").replaceAll("&nbsp;"," "));
                cnt++;
                if(cnt==3) {
                    break;
                }
            }

            for(int i=0;i<3;i++) { //for each movie in top 3 movie list
                //forming movie reviews link from movie_link and visiting that
                userAgent.visit(movies_list[i].getMv_link().replace("?ref_=filmo_li_i", "reviews?ref_=tt_urv"));
                //Extracting list of reviews for current movie sorted in decreasing order of people votes
                Elements rev_el=userAgent.doc.findEvery("<h2>");

                Review[] movie_reviews=new Review[3]; //stores top 3 review of current movie
                //extracting top 3 reviews from list of reviews
                for(int j=0;j<3;j++) {
                    movie_reviews[j]=new Review();
                    //storing review's title,its author and actual review text
                    movie_reviews[j].setHeading(rev_el.getElement(j).innerHTML());
                    Element auth_element=rev_el.getElement(j).getParent().findEvery("<a>").getElement(1);
                    movie_reviews[j].setAuthor("by "+auth_element.innerHTML()+" "+auth_element.nextSiblingElement().innerHTML());
                    String desc_str=rev_el.getElement(j).getParent().nextSiblingElement().innerHTML();
                    String mod_desc_str=desc_str.replaceAll("<br>","\n").replaceAll("</br>", "").replaceAll("&quot;","\"").replaceAll("&#x22;","\"").replaceAll("&#x27;","'").replaceAll("&#39;","'");

                    movie_reviews[j].setDesc(mod_desc_str);

                }

                movies_list[i].setReviews(movie_reviews);

            }

            actor.setMovies(movies_list);



        }
        catch(JauntException e){
            System.err.println(e);
        }
        return actor;
    }

    public String extractId(String text) { // extracts id from text like: (http://www.imdb.com/name/nm0000158/?ref_=fn_al_nm_1) here id is nm0000158
        StringBuffer id=new StringBuffer("");
        int cnt=0;
        for(int i=0;i<text.length()&&cnt<5;i++) {
            if(text.charAt(i)=='/') {
                cnt++;
            }
            else {
                if(cnt==4) {
                    id.append(text.charAt(i));
                }
            }
        }
        return id.toString();
    }
    public String formatRating(String str) {  //format extracted rating information in desired form..like(8.8/10 from 996,725 users)
        StringBuffer movie_rating=new StringBuffer("");
        String[] splitted_str=str.split(" ");
        movie_rating.append(splitted_str[splitted_str.length-1]);
        movie_rating.append(" from ");
        movie_rating.append(splitted_str[0]);
        movie_rating.append(" users");
        return movie_rating.toString();
    }
}
