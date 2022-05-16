package br.com.alura.aluragerenciador.acao;

import br.com.alura.aluragerenciador.modelo.Banco;
import br.com.alura.aluragerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostraEmpresa {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPorId(id);
        System.out.println("empresa editada: " + empresa.getNome());
        request.setAttribute("empresa", empresa);

        return "forward:formAlteraEmpresa.jsp";

    }
}
