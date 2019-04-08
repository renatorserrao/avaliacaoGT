package br.com.cadastro.daos;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cadastro.models.Pessoa;
import br.com.cadastro.models.PessoaPorEstadoDTO;


@Repository
@Transactional
public class PessoaDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Pessoa> listar() {
		return manager.createQuery("select p from Pessoa p",Pessoa.class).getResultList();
	}
	
	public List<PessoaPorEstadoDTO> count() {
		StringBuilder nativeQuery = new StringBuilder();
		List<PessoaPorEstadoDTO> lista = new ArrayList<PessoaPorEstadoDTO>();
		
		nativeQuery.append(" select distinct(p.id_estado) as id,  ");
		nativeQuery.append(" 		(select count(p1.id_estado)  "); 
		nativeQuery.append(" 			from pessoa p1 where p1.id_estado = p.id_estado) as qtd "); 
		nativeQuery.append(" from pessoa p ");
		
		Query query = manager.createNativeQuery(nativeQuery.toString());
		
		List<Object[]> rows = query.getResultList();
		for (Object[] row : rows) {
			PessoaPorEstadoDTO p = new PessoaPorEstadoDTO();
			p.setId((Integer) row[0]);
			p.setQtd((BigInteger) row[1]);
			lista.add(p);					
		}
		return lista;
			
		
		/*
		 * return manager.createQuery("select distinct(p.idEstado) as id, " +
		 * "		(select count(p1.idEstado) " +
		 * "			from Pessoa p1 where p1.idEstado = p.idEstado) as qtd " +
		 * "from Pessoa p ", PessoaPorEstadoDTO.class).getResultList();
		 */
		
	}
	
	public Pessoa find(Integer id) {
		//return manager.createQuery("select distinct(p) from Pessoa p join fetch p.estado estado join fetch estado.regiao regiao where p.idpessoa = :id", Pessoa.class)
		return manager.createQuery("select distinct(p) from Pessoa p where p.idpessoa = :id", Pessoa.class)
			.setParameter("id", id)
			.getSingleResult();
	}
	
	public Pessoa salvar(Pessoa pessoa) {
		manager.persist(pessoa);
		return pessoa;
	}

	public Pessoa alterar(Pessoa pessoa) {
		manager.merge(pessoa);
		return pessoa;
	}
}
