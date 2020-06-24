package br.com.transportadorasi.teste;

import br.com.transportadorasi.dao.FreteDao;
import br.com.transportadorasi.modelo.Frete;

public class testeCadastroFrete {
	
	public static void main(String[] args) {
		
		Frete frete = new Frete("Paulo","055455",5,5);
		FreteDao.cadastrarFrete(frete);
		
		System.out.println(frete);
	

	}

}
