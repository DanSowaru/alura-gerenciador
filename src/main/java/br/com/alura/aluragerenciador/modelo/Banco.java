package br.com.alura.aluragerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;

	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setId(chaveSequencial++);
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setId(chaveSequencial++);
		lista.add(empresa);
		lista.add(empresa2);

		Usuario u1 = new Usuario();
		u1.setLogin("nico");
		u1.setSenha("12345");
		Usuario u2 = new Usuario();
		u1.setLogin("ana");
		u1.setSenha("12345");
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {

		Iterator<Empresa> it = lista.iterator();
		while (it.hasNext()) {
			Empresa empresa = it.next();
			if (empresa.getId().equals(id)) {
				it.remove();
			}
		}

		// OU
//
//		for (int i=0; i < Banco.lista.size(); i++) {
//			if (Banco.lista.get(i).getId().equals(id)) {
//				Banco.lista.remove(i);
//			}
//		}


	}

	public Empresa buscaEmpresaPorId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId().equals(id)) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
}
