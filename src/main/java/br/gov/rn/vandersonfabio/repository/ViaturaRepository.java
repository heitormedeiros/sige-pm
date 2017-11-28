package br.gov.rn.vandersonfabio.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.gov.rn.vandersonfabio.model.ViaturaModel;
import br.gov.rn.vandersonfabio.repository.entity.ViaturaEntity;
import br.gov.rn.vandersonfabio.uteis.Uteis;

public class ViaturaRepository {
	
	@Inject
	ViaturaEntity viaturaEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVA VIATURA
	 * @param policialModel
	 */
	public void SalvarNovoRegistro(ViaturaModel viaturaModel){
 
		entityManager =  Uteis.JpaEntityManager();
				
		
		viaturaEntity = new ViaturaEntity();
		
		viaturaEntity.setPlaca(viaturaModel.getPlaca().toUpperCase());
		viaturaEntity.setPrefixo(viaturaModel.getPrefixo().toUpperCase());
		viaturaEntity.setMarca(viaturaModel.getMarca().toUpperCase());
		viaturaEntity.setModelo(viaturaModel.getModelo().toUpperCase());
		viaturaEntity.setAno(viaturaModel.getAno());
 
		entityManager.persist(viaturaEntity);
		
	}
	
	
	/***
	 * MÉTODO PARA CONSULTAR A VIATURA
	 * @return
	 */
	public List<ViaturaModel> GetViaturas(){
 
		List<ViaturaModel> viaturasModel = new ArrayList<ViaturaModel>();
 
		entityManager =  Uteis.JpaEntityManager();
		
		
		Query query = entityManager.createNamedQuery("ViaturaEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<ViaturaEntity> viaturasEntity = (Collection<ViaturaEntity>)query.getResultList();
 
		ViaturaModel viaturaModel = null;
 
		for (ViaturaEntity viaturaEntity : viaturasEntity) {
 
			
			viaturaModel = new ViaturaModel();
			
			viaturaModel.setId(viaturaEntity.getCodigo());
			viaturaModel.setPlaca(viaturaEntity.getPlaca());
			viaturaModel.setPrefixo(viaturaEntity.getPrefixo());
			viaturaModel.setMarca(viaturaEntity.getMarca());
			viaturaModel.setModelo(viaturaEntity.getModelo());
			viaturaModel.setAno(viaturaEntity.getAno());
			
			
			viaturasModel.add(viaturaModel);
		}
 
		return viaturasModel; 
	}
	
	/***
	 * CONSULTA UMA VIATURA PELO CÓDIGO
	 * @param COD
	 * @return
	 */
	private ViaturaEntity GetViatura(int id){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(ViaturaEntity.class, id);
	}
 
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param policialModel
	 */
	public void AlterarRegistro(ViaturaModel viaturaModel){
 
		//entityManager =  Uteis.JpaEntityManager();
 		
		entityManager =  Uteis.JpaEntityManager();
		
		ViaturaEntity viaturaEntity = this.GetViatura(viaturaModel.getId());
		
		viaturaEntity.setPlaca(viaturaModel.getPlaca().toUpperCase());
		viaturaEntity.setPrefixo(viaturaModel.getPrefixo().toUpperCase());
		viaturaEntity.setMarca(viaturaModel.getMarca().toUpperCase());
		viaturaEntity.setModelo(viaturaModel.getModelo().toUpperCase());
		viaturaEntity.setAno(viaturaModel.getAno());
			 
		entityManager.merge(viaturaEntity);
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	public void ExcluirRegistro(int codigo){

		//entityManager =  Uteis.JpaEntityManager();		

		entityManager = Uteis.JpaEntityManager();
		
		ViaturaEntity viaturaEntity = this.GetViatura(codigo);
				
		entityManager.remove(viaturaEntity);

		
		//entityManager.remove(policialEntity);
	}
	
}
