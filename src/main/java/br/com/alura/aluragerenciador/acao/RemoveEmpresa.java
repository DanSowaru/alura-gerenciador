package br.com.alura.aluragerenciador.acao;

import br.com.alura.aluragerenciador.modelo.Banco;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveEmpresa implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        System.out.println("id deletado: " + id);
        Banco banco = new Banco();
        banco.removeEmpresa(id);
        System.out.println("Removendo empresa");

        return "redirect:entrada?acao=ListaEmpresas";

    }

}
