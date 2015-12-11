<%--
  Created by IntelliJ IDEA.
  User: SACHIN
  Date: 12/8/2015
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- First page where user lands and see a search_box with search_button --%>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <form action="Imdb_Search_Controller" method="post">
      Enter actor name : <input type="text" name="search_name"> <BR>
      <input type="submit" />
    </form>
  </body>
</html>
<%-- when user enters an actor name and click on search_button then it will go to IMDB_Search_Controller which will process the request and will give search_result in turn--%>
