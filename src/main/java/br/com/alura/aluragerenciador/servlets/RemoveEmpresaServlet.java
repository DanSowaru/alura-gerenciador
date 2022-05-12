package br.com.alura.aluragerenciador.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveEmpresaServlet", value = "/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        System.out.println("id deletado: " + id);
        Banco banco = new Banco();
        banco.removeEmpresa(id);
        response.sendRedirect("listaEmpresas");


    }

}
