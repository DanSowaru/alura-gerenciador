package br.com.alura.aluragerenciador.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filtro de monitoramento executado");
        String acao = request.getParameter("acao");
        long antes = System.currentTimeMillis(); // pega o tempo antes de executar o código
        chain.doFilter(request, response); // executa o código
        long depois = System.currentTimeMillis(); // pega o tempo depois de executar o código
        System.out.printf("Tempo de execução da ação %s: %d%n", acao, depois - antes); // mostra o tempo de execução

    }
}

// o HttpServletRequest é um ServletRequest
