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

public class NovaEmpresaForm implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        return "forward:formNovaEmpresa.jsp";
    }
}
