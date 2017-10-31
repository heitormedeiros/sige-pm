package br.gov.rn.vandersonfabio.policial.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.vandersonfabio.model.PolicialModel;
import br.gov.rn.vandersonfabio.repository.PolicialRepository;


@Named(value="consultarPolicialCarouselController")
@ViewScoped
public class ConsultarPolicialCarouselController implements Serializable {
	private static final long serialVersionUID = 1L;
	 
	@Inject transient
	private PolicialRepository policialRepository;
 
	@Produces 
	private List<PolicialModel> policiais;
 
	public List<PolicialModel> getPoliciais() {
		return policiais;
	}
 
	@PostConstruct
	private void init(){
 
		this.policiais = policialRepository.GetPoliciais();
	}
  
}