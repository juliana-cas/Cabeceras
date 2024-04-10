package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;

@WebServlet(value="/test") // Anotación que mapea esta clase como un servlet con la URL "/test"
public class ServletTest extends HttpServlet { // Declaración de la clase ServletTest que extiende HttpServlet

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        resp.setContentType("text/html"); // Establece el tipo de contenido de la respuesta como HTML
        String metodoHttp = req.getMethod(); // Obtiene el método HTTP de la solicitud
        String requestUri = req.getRequestURI(); // Obtiene la URI de la solicitud
        String requestUrl = req.getRequestURL().toString(); // Obtiene la URL de la solicitud
        String contexPath = req.getContextPath(); // Obtiene el contexto de la aplicación
        String servletPath=req.getServletPath(); // Obtiene el path del servlet
        String ipCliente=req.getRemoteAddr(); // Obtiene la dirección IP del cliente
        String ip=req.getLocalAddr(); // Obtiene la dirección IP local
        int port=req.getLocalPort(); // Obtiene el puerto local
        String scheme=req.getScheme(); // Obtiene el esquema (HTTP/HTTPS) de la solicitud
        String host=req.getHeader("host"); // Obtiene el host de la solicitud
        String url=scheme+"://"+host+contexPath+servletPath; // Construye una URL completa
        String url2=scheme+"://"+ip+":"+port+contexPath+servletPath; // Construye otra URL completa

        try(PrintWriter out=resp.getWriter()){ // Se prepara para escribir la respuesta HTML
            out.println("<!DOCTYPEhtml>"); // Inicia la declaración del tipo de documento HTML
            out.println("<html>"); // Inicia el elemento HTML
            out.println(" <head>"); // Inicia la sección de encabezado
            out.println(" <metacharset=\"UTF-8\">"); // Define la codificación de caracteres
            out.println(" <title>CabecerasHTTPRequest</title>"); // Establece el título de la página
            out.println(" </head>"); // Finaliza la sección de encabezado
            out.println(" <body>"); // Inicia el cuerpo de la página
            out.println(" <h1>CabecerasHTTPRequest!</h1>"); // Muestra un título
            out.println("<ul>"); // Inicia una lista desordenada
            out.println("<li>metodohttp:"+metodoHttp+"</li>"); // Muestra el método HTTP
            out.println("<li>requesturi:"+requestUri+"</li>"); // Muestra la URI de la solicitud
            out.println("<li>requesturl:"+requestUrl+"</li>"); // Muestra la URL de la solicitud
            out.println("<li>contextpath:"+contexPath+"</li>"); // Muestra el contexto de la aplicación
            out.println("<li>servletpath:"+servletPath+"</li>"); // Muestra el path del servlet
            out.println("<li>iplocal:"+ip+"</li>"); // Muestra la dirección IP local
            out.println("<li>ipcliente:"+ipCliente+"</li>"); // Muestra la dirección IP del cliente
            out.println("<li>puertolocal:"+port+"</li>"); // Muestra el puerto local
            out.println("<li>scheme:"+scheme+"</li>"); // Muestra el esquema de la solicitud
            out.println("<li>host:"+host+"</li>"); // Muestra el host de la solicitud
            out.println("<li>url:"+url+"</li>"); // Muestra la URL completa
            out.println("<li>url2:"+url2+"</li>"); // Muestra otra URL completa
            Enumeration<String> headerNames=req.getHeaderNames(); // Obtiene los nombres de las cabeceras de la solicitud
            while(headerNames.hasMoreElements()){ // Itera sobre las cabeceras
                String cabecera=headerNames.nextElement(); // Obtiene el nombre de una cabecera
                out.println("<li>"+cabecera+":"+req.getHeader(cabecera)+"</li>"); // Muestra la cabecera y su valor
            }
            out.println("</ul>"); // Finaliza la lista desordenada
            out.println(" </body>"); // Finaliza el cuerpo de la página
            out.println("</html>"); // Finaliza el elemento HTML
        }
    }
}
