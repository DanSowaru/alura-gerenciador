package br.com.alura.aluragerenciador.servlets;

import br.com.alura.aluragerenciador.acao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UnicaEntradaServlet", value = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramAcao = request.getParameter("acao");
        String nome = null;

        if (paramAcao.equals("ListaEmpresas")) {

            ListaEmpresas acao = new ListaEmpresas();
            nome = acao.executa(request, response);

        } else if (paramAcao.equals("RemoveEmpresa")) {

            RemoveEmpresa acao = new RemoveEmpresa();
            nome = acao.executa(request, response);

        } else if (paramAcao.equals("MostraEmpresa")) {

            System.out.println("Mostrando dados da empresa");
            MostraEmpresa acao = new MostraEmpresa();
            nome = acao.executa(request, response);

        }  else if (paramAcao.equals("AlteraEmpresa")) {

            AlteraEmpresa acao = new AlteraEmpresa();
            nome = acao.executa(request, response);
        } else if (paramAcao.equals("NovaEmpresa")){

            NovaEmpresa acao = new NovaEmpresa();
            nome = acao.executa(request, response);

        }

        String[] tipoEEndereco = nome.split(":");
        if (tipoEEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEEndereco[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect(tipoEEndereco[1]);
        }


    }
}
