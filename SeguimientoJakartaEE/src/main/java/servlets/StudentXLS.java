package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet({"/students.xls","/students.html","/students"})
 public class StudentXLS extends HttpServlet {

}