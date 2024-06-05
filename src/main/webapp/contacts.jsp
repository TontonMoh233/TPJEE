<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.internet.Contact" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des contacts</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
    <h1>Liste des contacts</h1>
    <form action="contacts" method="post">
        Nom: <input type="text" name="name">
        Compétence: <input type="text" name="skill">
        <input type="submit" value="Ajouter">
    </form>
    <ul>
        <%
            List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
            if (contacts != null) {
                for (Contact contact : contacts) {
                    out.println("<li>" + contact.getName() + " - " + contact.getSkill() + "</li>");
                }
            }
        %>
    </ul>
    <a href="index.jsp">Retour à l'accueil</a>
</body>
</html>
