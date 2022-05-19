package br.com.alura.aluragerenciador.servlets;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuotizacaoFilter", urlPatterns = "/entrada")
public class AuotizacaoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("acao");

        HttpSession session = request.getSession();
        boolean usuarioNaoLogado = session.getAttribute("usuarioLogado") == null;
        boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));

        if (usuarioNaoLogado && ehUmaAcaoProtegida) {
            response.sendRedirect("entrada?acao=LoginForm");
            return;
        }


        chain.doFilter(servletRequest, servletResponse);

    }
}
