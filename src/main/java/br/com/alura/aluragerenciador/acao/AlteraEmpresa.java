package br.com.alura.aluragerenciador.acao;

import br.com.alura.aluragerenciador.modelo.Banco;
import br.com.alura.aluragerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AlteraEmpresa implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String nomeEmpresa = request.getParameter("nome");
        String paramDataEmpresa = request.getParameter("data");
        Integer id = Integer.parseInt(request.getParameter("id"));

        System.out.println("Alterando empresa" + id);

        Date dataAbertura;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(paramDataEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        System.out.println("Nome: " + nomeEmpresa);

        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPorId(id);
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        return "redirect:entrada?acao=ListaEmpresas";

    }
}
