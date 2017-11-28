package br.gov.rn.vandersonfabio.policial.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.vandersonfabio.model.PolicialModel;
import br.gov.rn.vandersonfabio.repository.PolicialRepository;
import br.gov.rn.vandersonfabio.usuario.controller.UsuarioController;
import br.gov.rn.vandersonfabio.uteis.Uteis;

@Named(value="cadastrarPolicialController")
@RequestScoped
public class CadastrarPolicialController {
	
	@Inject
	PolicialModel policialModel;
 
	@Inject
	UsuarioController usuarioController;
 
	@Inject
	PolicialRepository policialRepository;
 
 
	public PolicialModel getPolicialModel() {
		return policialModel;
	}
 
	public void setPolicialModel(PolicialModel policialModel) {
		this.policialModel = policialModel;
	}

	
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	public void SalvarNovoPolicial(){
 
		policialModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());
 
		policialRepository.SalvarNovoRegistro(this.policialModel);
 
		this.policialModel = null;
 
		Uteis.MensagemInfo("Policial cadastrado com sucesso."); 
	}
 
}
