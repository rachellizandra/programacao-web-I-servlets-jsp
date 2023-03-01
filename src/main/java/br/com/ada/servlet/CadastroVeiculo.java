package br.com.ada.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastro")
public class CadastroVeiculo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         *     String modelo;
         *     String marca;
         *     String ano;
         *     String placa;
         */

        //seleciona os parâmetros do index.jsp
        String modelo = req.getParameter("modelo");
        String marca = req.getParameter("marca");
        String ano = req.getParameter("ano");
        String placa = req.getParameter("placa");

        if (modelo.equals("") || marca.equals("") || ano.equals("")|| placa.equals("")) {
            resp.setContentType("text/html");
            resp.getWriter().println("<h3>Dados obrigatórios não preenchidos!</h3>");
        } else {
            //cria os atributos
            req.setAttribute("modelo", modelo);
            req.setAttribute("marca", marca);
            req.setAttribute("ano", marca);
            req.setAttribute("placa", placa);

            //redireciona os dados cadastrados e envia para o data.jsp
            RequestDispatcher rd = req.getRequestDispatcher("data.jsp");

            rd.forward(req, resp);
        }
    }
}
