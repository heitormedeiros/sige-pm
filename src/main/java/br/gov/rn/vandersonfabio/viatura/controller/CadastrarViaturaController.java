package br.gov.rn.vandersonfabio.viatura.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.vandersonfabio.model.ViaturaModel;
import br.gov.rn.vandersonfabio.repository.ViaturaRepository;
import br.gov.rn.vandersonfabio.uteis.Uteis;

@Named(value="cadastrarViaturaController")
@RequestScoped
public class CadastrarViaturaController {
	
	@Inject
	ViaturaModel viaturaModel;
 
	@Inject
	ViaturaRepository viaturaRepository;
 
 
	public ViaturaModel getViaturaModel() {
		return viaturaModel;
	}
 
	public void setViaturaModel(ViaturaModel viaturaModel) {
		this.viaturaModel = viaturaModel;
	}

	
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	public void SalvarNovaViatura(){
 
		viaturaRepository.SalvarNovoRegistro(this.viaturaModel);
 
		this.viaturaModel = null;
 
		Uteis.MensagemInfo("Viatura cadastrada com sucesso."); 
	}
 
}
