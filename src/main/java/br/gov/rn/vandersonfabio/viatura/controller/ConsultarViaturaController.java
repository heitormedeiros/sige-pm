package br.gov.rn.vandersonfabio.viatura.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.vandersonfabio.model.ViaturaModel;
import br.gov.rn.vandersonfabio.repository.ViaturaRepository;


@Named(value="consultarViaturaController")
@ViewScoped
public class ConsultarViaturaController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 
	@Inject transient
	private ViaturaModel viaturaModel;
 
	@Produces 
	private List<ViaturaModel> viaturas;
 
	@Inject transient
	private ViaturaRepository viaturaRepository;
 
	public List<ViaturaModel> getViaturas() {
		return viaturas;
	}
	public void setViaturas(List<ViaturaModel> viaturas) {
		this.viaturas = viaturas;
	}		
	public ViaturaModel getViaturaModel() {
		return viaturaModel;
	}
	public void setViaturaModel(ViaturaModel viaturaModel) {
		this.viaturaModel = viaturaModel;
	}
 
	/***
	 * CARREGA AS Policiais NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		//RETORNAR AS Policiais CADASTRADAS
		this.viaturas = viaturaRepository.GetViaturas();
	}
	
	/*
	 * CARREGA INFORMAÇÕES DE UM POLICIAL PARA SER EDITADO
	 * @param policialModel
	 
	 ## FUNÇÃO PEGAVA APENAS O SEXO, DEIXEI DESABILITADA...
	 */
	public void Editar(ViaturaModel viaturaModel){
 
		/*PEGA APENAS A PRIMEIRA LETRA DO SEXO PARA SETAR NO CAMPO(M OU F)*/
		this.viaturaModel = viaturaModel;
 
	}
 	
 	
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
 
		this.viaturaRepository.AlterarRegistro(this.viaturaModel);	
 
 
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param pessoaModel
	 */
	public void ExcluirViatura(ViaturaModel viaturaModel){
 
		//EXCLUI A PESSOA DO BANCO DE DADOS
		this.viaturaRepository.ExcluirRegistro(viaturaModel.getId());
 
		//REMOVENDO A PESSOA DA LISTA
		//ASSIM QUE É A PESSOA É REMOVIDA DA LISTA O DATATABLE É ATUALIZADO
		this.viaturas.remove(viaturaModel);
 
	}
}
