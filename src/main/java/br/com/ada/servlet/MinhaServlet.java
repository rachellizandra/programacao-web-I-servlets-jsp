package br.com.ada.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/minhaServlet")
public class MinhaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html"); //seta para a escritura web ser escrita em HTML (tipo de resposta que será retornado no response)

        req.getSession().setAttribute("nome", "Rachel Lizandra"); //adiciona na sessão um atributo nome com um valor dentro

        PrintWriter out = resp.getWriter(); //responsável por escrever na página web
        out.println("<h1>Dado gravado com sucesso</h1>");

        resp.sendRedirect("/programacao-web-I-jee/consultaServlet"); //redirecionar o caminho da minhaServlet para consultaServlet
    }
}
