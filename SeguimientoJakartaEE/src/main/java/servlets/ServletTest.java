package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;


@WebServlet(value="/test")
    public class ServletTest extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
                IOException {
            resp.setContentType("text/html");
            String metodoHttp = req.getMethod();
            String requestUri = req.getRequestURI();
            String requestUrl = req.getRequestURL().toString();
            String contexPath = req.getContextPath();
            String servletPath=req.getServletPath();
            String ipCliente=req.getRemoteAddr();
            String ip=req.getLocalAddr();
            int port=req.getLocalPort();
            String scheme=req.getScheme();
            String host=req.getHeader("host");
            String url=scheme+"://"+host+contexPath+servletPath;
            String url2=scheme+"://"+ip+":"+port+contexPath+servletPath;
            try(PrintWriter out=resp.getWriter()){
                out.println("<!DOCTYPEhtml>");
                out.println("<html>");
                out.println(" <head>");
                out.println(" <metacharset=\"UTF-8\">");
                out.println(" <title>CabecerasHTTPRequest</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println(" <h1>CabecerasHTTPRequest!</h1>");
                out.println("<ul>");
                out.println("<li>metodohttp:"+metodoHttp+"</li>");
                out.println("<li>requesturi:"+requestUri+"</li>");
                out.println("<li>requesturl:"+requestUrl+"</li>");
                out.println("<li>contextpath:"+contexPath+"</li>");
                out.println("<li>servletpath:"+servletPath+"</li>");
                out.println("<li>iplocal:"+ip+"</li>");
                out.println("<li>ipcliente:"+ipCliente+"</li>");
                out.println("<li>puertolocal:"+port+"</li>");
                out.println("<li>scheme:"+scheme+"</li>");
                out.println("<li>host:"+host+"</li>");
                out.println("<li>url:"+url+"</li>");
                out.println("<li>url2:"+url2+"</li>");
                Enumeration<String> headerNames=req.getHeaderNames();
                while(headerNames.hasMoreElements()){
                    String cabecera=headerNames.nextElement();
                    out.println("<li>"+cabecera+":"+req.getHeader(cabecera)+"</li>");
                }
                out.println("</ul>");
                out.println(" </body>");
                out.println("</html>");
            }
        }
    }