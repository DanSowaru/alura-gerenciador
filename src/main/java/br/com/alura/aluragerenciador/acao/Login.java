package br.com.alura.aluragerenciador.acao;

import br.com.alura.aluragerenciador.modelo.Banco;
import br.com.alura.aluragerenciador.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");



        System.out.println("Login: " + login);

        Banco banco = new Banco();
        Usuario usuario = banco.existeUsuario(login, senha);

        if (usuario != null) {
            System.out.println("Usuário logado com sucesso!");
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:entrada?acao=ListaEmpresas";

        } else {
            System.out.println("Usuário não encontrado!");
            return "redirect:entrada?acao=LoginForm";
        }

    }
}
