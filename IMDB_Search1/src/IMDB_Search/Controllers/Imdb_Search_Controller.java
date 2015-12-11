package IMDB_Search.Controllers;

import IMDB_Search.Models.Actor;
import IMDB_Search.Models.IMDB_Search_performer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SACHIN on 12/8/2015.
 */
@WebServlet(name = "Imdb_Search_Controller")
public class Imdb_Search_Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search_name");
        RequestDispatcher rd = null;
        //Preparing to contact IMDB_Search_Performer module to perform search for requested actor name
        IMDB_Search_performer search_performer = new IMDB_Search_performer();
        //searching requested actor's top 3 movies with top 3 reviews and pushing the search results in actor object
        Actor actor = search_performer.search(name);

        if (actor != null) { //if search is success then it will redirect to search_result.jsp which will show that actor's top 3 movies with top 3 reviews
            rd = request.getRequestDispatcher("/search_result.jsp");
            request.setAttribute("actor", actor);
        } else { //if search was unsuccessfull due to invalid actor_name then it will redirect to error.jsp
            rd = request.getRequestDispatcher("/error.jsp");
        }
        rd.forward(request, response);
    }

}
