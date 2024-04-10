package servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(value="/student.json")
public class StudentJson extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws
            ServletException, IOException {
        ServletInputStream jsonStream=req.getInputStream();
        ObjectMapper mapper=new ObjectMapper();
        Student student=mapper.readValue(jsonStream,Student.class);
        resp.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out=resp.getWriter()){
            out.println("<!DOCTYPEhtml>");
            out.println("<html>");
            out.println(" <head>");
            out.println(" <metacharset=\"UTF-8\">");
            out.println(" <title>Detalledeproductodesdejson</title>");
            out.println(" </head>");
            out.println(" <body>");
            out.println(" <h1>Detalledeproductodesdejson!</h1>");
            out.println("<ul>");
            out.println("<li>Id:"+student.getId()+"</li>");
            out.println("<li>Nombre:"+student.getNombre()+"</li>");
            out.println("<li>Tipo:"+student.getTipo()+"</li>");
            out.println("<li>Precio: " + student.getPrecio() + "</li>");
            out.println("</ul>");
            out.println(" </body>");
            out.println("</html>");
        }
    }
}
