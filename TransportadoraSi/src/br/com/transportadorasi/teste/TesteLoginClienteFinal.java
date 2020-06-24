package br.com.transportadorasi.teste;

import br.com.transportadorasi.dao.ClienteFinalDao;

public class TesteLoginClienteFinal {

	public static void main(String[] args) {
		
		var result = ClienteFinalDao.loginClienteFinal("plindao", "1234");
		System.out.println(result);
	}

}
