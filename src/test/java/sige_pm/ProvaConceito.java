package sige_pm;

import br.gov.rn.vandersonfabio.model.PolicialModel;
import br.gov.rn.vandersonfabio.model.UsuarioModel;
import br.gov.rn.vandersonfabio.repository.PolicialRepository;

public class ProvaConceito {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PolicialModel policial = new PolicialModel();
		
		
		//TESTE PARA INSERÇÃO NO BANCO
		/*
		policial.setMatricula("1111111");
		policial.setNomeGuerra("Vanderson teste");
		policial.setAnoPraca(2011);
		policial.setNumPraca(1);
		policial.setEmail("@@@@@@@@@@");
		
		
		UsuarioModel usuario = new UsuarioModel();
		usuario.setCodigo("1");
		usuario.setUsuario("admin");
		usuario.setSenha("suporte");
		
		policial.setUsuarioModel(usuario);
		
		PolicialRepository policialRepository = new PolicialRepository();
		
		policialRepository.SalvarNovoRegistro(policial);
		*/
		
		//TESTE PARA ALTERAR REGISTRO NO BANCO
		policial.setMatricula("1111111");
		policial.setNomeGuerra("Vanderson teste 8");
		policial.setAnoPraca(2015);
		policial.setNumPraca(100);
		policial.setEmail("@@@ggggg@@@");
		
		
		UsuarioModel usuario = new UsuarioModel();
		usuario.setCodigo("1");
		usuario.setUsuario("admin");
		usuario.setSenha("suporte");
		
		policial.setUsuarioModel(usuario);
		
		PolicialRepository policialRepository = new PolicialRepository();
		
		policialRepository.AlterarRegistro(policial);
		
	}

}
