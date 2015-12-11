<%--
  Created by IntelliJ IDEA.
  User: SACHIN
  Date: 12/8/2015
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%-- user will see this page if search is successfull this page will show requested actor's top 3 movies with top 3 reviews and other information
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
    <title></title>
</head>
<body>

    ${requestScope['actor'].name}.<br><br>

    <table border="2">
        <tr>

            <th>Movie Display Pic</th>
            <th>Name (along with year,runtime etc.)</th>
            <th>Rating</th>
            <th>Top Reviews</th>

        </tr>

        <tr>
            <td> <img src="${requestScope['actor'].movies[0].mv_img_link}"> </td>
            <td> <a href="${requestScope['actor'].movies[0].mv_link}">${requestScope['actor'].movies[0].name}</a>(${requestScope['actor'].movies[0].year})<br>
            ${requestScope['actor'].movies[0].info}
            </td>
            <td>${requestScope['actor'].movies[0].rating}</td>
            <td>
                <table>
                    <tr><td>${requestScope['actor'].movies[0].reviews[0].heading} <br>(${requestScope['actor'].movies[0].reviews[0].author}):<br>${requestScope['actor'].movies[0].reviews[0].desc} <br><br><br></td></tr>
                    <tr><td>${requestScope['actor'].movies[0].reviews[1].heading} <br>(${requestScope['actor'].movies[0].reviews[1].author}):<br>${requestScope['actor'].movies[0].reviews[1].desc} <br><br><br></td></tr>
                    <tr><td>${requestScope['actor'].movies[0].reviews[2].heading} <br>(${requestScope['actor'].movies[0].reviews[2].author}):<br>${requestScope['actor'].movies[0].reviews[2].desc} <br><br><br></td></tr>
                </table>
            </td>
        </tr>

        <tr>
            <td> <img src="${requestScope['actor'].movies[1].mv_img_link}"> </td>
            <td> <a href="${requestScope['actor'].movies[1].mv_link}">${requestScope['actor'].movies[1].name}</a>(${requestScope['actor'].movies[1].year})<br>
                ${requestScope['actor'].movies[1].info}
            </td>
            <td>${requestScope['actor'].movies[1].rating}</td>
            <td>
                <table>
                    <tr><td>${requestScope['actor'].movies[1].reviews[0].heading} <br>(${requestScope['actor'].movies[1].reviews[0].author}):<br>${requestScope['actor'].movies[1].reviews[0].desc} <br><br><br></td></tr>
                    <tr><td>${requestScope['actor'].movies[1].reviews[1].heading} <br>(${requestScope['actor'].movies[1].reviews[1].author}):<br>${requestScope['actor'].movies[1].reviews[1].desc} <br><br><br></td></tr>
                    <tr><td>${requestScope['actor'].movies[1].reviews[2].heading} <br>(${requestScope['actor'].movies[1].reviews[2].author}):<br>${requestScope['actor'].movies[1].reviews[2].desc} <br><br><br></td></tr>
                </table>
            </td>
        </tr>

        <tr>
            <td> <img src="${requestScope['actor'].movies[2].mv_img_link}"> </td>
            <td> <a href="${requestScope['actor'].movies[2].mv_link}">${requestScope['actor'].movies[2].name}</a>(${requestScope['actor'].movies[2].year})<br>
                ${requestScope['actor'].movies[2].info}
            </td>
            <td>${requestScope['actor'].movies[2].rating}</td>
            <td>
                <table>
                    <tr><td>${requestScope['actor'].movies[2].reviews[0].heading} <br>(${requestScope['actor'].movies[2].reviews[0].author}):<br>${requestScope['actor'].movies[2].reviews[0].desc} <br><br><br></td></tr>
                    <tr><td>${requestScope['actor'].movies[2].reviews[1].heading} <br>(${requestScope['actor'].movies[2].reviews[1].author}):<br>${requestScope['actor'].movies[2].reviews[1].desc} <br><br><br></td></tr>
                    <tr><td>${requestScope['actor'].movies[2].reviews[2].heading} <br>(${requestScope['actor'].movies[2].reviews[2].author}):<br>${requestScope['actor'].movies[2].reviews[2].desc} <br><br><br></td></tr>
                </table>
            </td>
        </tr>

    </table>


</body>
</html>
