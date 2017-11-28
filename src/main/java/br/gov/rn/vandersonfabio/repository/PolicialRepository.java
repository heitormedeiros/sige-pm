package br.gov.rn.vandersonfabio.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.gov.rn.vandersonfabio.model.PolicialModel;
import br.gov.rn.vandersonfabio.model.UsuarioModel;
import br.gov.rn.vandersonfabio.repository.entity.PolicialEntity;
import br.gov.rn.vandersonfabio.repository.entity.UsuarioEntity;
import br.gov.rn.vandersonfabio.uteis.Uteis;

public class PolicialRepository {
	
	@Inject
	PolicialEntity policialEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UM NOVO POLICIAL
	 * @param policialModel
	 */
	public void SalvarNovoRegistro(PolicialModel policialModel){
 
		entityManager =  Uteis.EMF.createEntityManager();
				
		
		policialEntity = new PolicialEntity();
		
		policialEntity.setMatricula(policialModel.getMatricula());
		policialEntity.setGraduacao(policialModel.getGraduacao());
		policialEntity.setNomeGuerra(policialModel.getNomeGuerra().toUpperCase());
		policialEntity.setAnoPraca(policialModel.getAnoPraca());
		policialEntity.setNumPraca(policialModel.getNumPraca());
		policialEntity.setEmail(policialModel.getEmail().toLowerCase());
		policialEntity.setDataCadastro(LocalDateTime.now());
		
		entityManager.getTransaction().begin();
		
		UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, policialModel.getUsuarioModel().getCodigo()); 
 
		policialEntity.setUsuarioEntity(usuarioEntity);
 
		entityManager.persist(policialEntity);
		entityManager.flush();
		entityManager.getTransaction().commit();
		

	}
	
	/***
	 * MÉTODO PARA CONSULTAR O PM
	 * @return
	 */
	public List<PolicialModel> GetPoliciais(){
 
		List<PolicialModel> policiaisModel = new ArrayList<PolicialModel>();
 
		entityManager =  Uteis.JpaEntityManager();
		
		
		Query query = entityManager.createNamedQuery("PolicialEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<PolicialEntity> policiaisEntity = (Collection<PolicialEntity>)query.getResultList();
 
		PolicialModel policialModel = null;
 
		for (PolicialEntity policialEntity : policiaisEntity) {
 
			policialModel = new PolicialModel();
			policialModel.setId(policialEntity.getCodigo());
			policialModel.setMatricula(policialEntity.getMatricula());
			policialModel.setGraduacao(policialEntity.getGraduacao());
			policialModel.setNomeGuerra(policialEntity.getNomeGuerra());
			policialModel.setAnoPraca(policialEntity.getAnoPraca());
			policialModel.setNumPraca(policialEntity.getNumPraca());
			policialModel.setEmail(policialEntity.getEmail());
			policialModel.setDataCadastro(policialEntity.getDataCadastro());
			 
			 
			UsuarioEntity usuarioEntity =  policialEntity.getUsuarioEntity();			
 
			UsuarioModel usuarioModel = new UsuarioModel();
			usuarioModel.setUsuario(usuarioEntity.getUsuario());
 
			policialModel.setUsuarioModel(usuarioModel);
 
			policiaisModel.add(policialModel);
		}
 
		return policiaisModel; 
	}
	
	/***
	 * CONSULTA UM POLICIAL CADASTRADO PELO CÓDIGO
	 * @param matricula
	 * @return
	 */
	private PolicialEntity GetPolicial(long id){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(PolicialEntity.class, id);
	}
 
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param policialModel
	 */
	public void AlterarRegistro(PolicialModel policialModel){
 
		//entityManager =  Uteis.JpaEntityManager();
 		
		entityManager =  Uteis.JpaEntityManager();
		
		PolicialEntity policialEntity = this.GetPolicial(policialModel.getId());
		
		policialEntity.setMatricula(policialModel.getMatricula());
		policialEntity.setGraduacao(policialModel.getGraduacao());
		policialEntity.setNomeGuerra(policialModel.getNomeGuerra().toUpperCase());
		policialEntity.setAnoPraca(policialModel.getAnoPraca());
		policialEntity.setNumPraca(policialModel.getNumPraca());
		policialEntity.setEmail(policialModel.getEmail().toLowerCase());		
		 
		entityManager.merge(policialEntity);
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	public void ExcluirRegistro(long codigo){

		//entityManager =  Uteis.JpaEntityManager();		

		entityManager = Uteis.JpaEntityManager();
		
		
		PolicialEntity policialEntity = this.GetPolicial(codigo);
				
		entityManager.remove(policialEntity);

		
		//entityManager.remove(policialEntity);
	}
	
	
}