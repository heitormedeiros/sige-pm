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

@Named(value="consultarPolicialController")
@ViewScoped
public class ConsultarPolicialController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 
	@Inject transient
	private PolicialModel policialModel;
 
	@Produces 
	private List<PolicialModel> policiais;
 
	@Inject transient
	private PolicialRepository policialRepository;
 
	public List<PolicialModel> getPoliciais() {
		return policiais;
	}
	public void setPoliciais(List<PolicialModel> policiais) {
		this.policiais = policiais;
	}		
	public PolicialModel getPolicialModel() {
		return policialModel;
	}
	public void setPolicialModel(PolicialModel policialModel) {
		this.policialModel = policialModel;
	}
 
	/***
	 * CARREGA AS Policiais NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		//RETORNAR AS Policiais CADASTRADAS
		this.policiais = policialRepository.GetPoliciais();
	}
	
	/*
	 * CARREGA INFORMAÇÕES DE UM POLICIAL PARA SER EDITADO
	 * @param policialModel
	 
	 ## FUNÇÃO PEGAVA APENAS O SEXO, DEIXEI DESABILITADA...
	 */
	public void Editar(PolicialModel policialModel){
 
		/*PEGA APENAS A PRIMEIRA LETRA DO SEXO PARA SETAR NO CAMPO(M OU F)*/
		this.policialModel = policialModel;
 
	}
 	
 	
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
 
		this.policialRepository.AlterarRegistro(this.policialModel);	
 
 
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param pessoaModel
	 */
	public void ExcluirPolicial(PolicialModel policialModel){
 
		//EXCLUI A PESSOA DO BANCO DE DADOS
		this.policialRepository.ExcluirRegistro(policialModel.getId());
 
		//REMOVENDO A PESSOA DA LISTA
		//ASSIM QUE É A PESSOA É REMOVIDA DA LISTA O DATATABLE É ATUALIZADO
		this.policiais.remove(policialModel);
 
	}
}
