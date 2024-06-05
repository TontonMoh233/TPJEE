package com.internet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/contacts")
public class ContactServlet extends HttpServlet {
    private List<Contact> contacts = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("contacts", contacts);
        request.getRequestDispatcher("/contacts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String skill = request.getParameter("skill");
        if (name != null && skill != null && !name.isEmpty() && !skill.isEmpty()) {
            contacts.add(new Contact(name, skill));
        }
        response.sendRedirect("contacts");
    }
}
