package br.com.cadastro.resources;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.cadastro.daos.PessoaDAO;
import br.com.cadastro.models.Estado;
import br.com.cadastro.models.EstadoDTO;
import br.com.cadastro.models.Pessoa;
import br.com.cadastro.models.PessoaDTO;
import br.com.cadastro.models.PessoaPorEstadoDTO;
import br.com.cadastro.util.Mensagem;
import br.com.cadastro.util.RespostaGeneric;
import br.com.cadastro.util.URL;
import br.com.cadastro.util.Util;
import br.com.cadastro.ws.EstadoWS;

	
@RestController
@RequestMapping(value="/pessoa")
public class PessoaResource {
	
	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Autowired
	private EstadoWS estadoWS;
	 
	  @RequestMapping(value = "/listar", method = RequestMethod.GET)
	  public ResponseEntity<List<PessoaDTO>> listar() throws Exception {
		  List<Pessoa> pessoas = pessoaDAO.listar();
		  Type listType = new TypeToken<List<Estado>>(){}.getType();
		  String jsonGET = estadoWS.GET(URL.BUSCAR.ESTADOS.getURL());
		  List<Estado> estados = new Gson().fromJson(jsonGET,listType);
		  List<PessoaDTO> listPessoaDTO = new ArrayList<PessoaDTO>();
		  for (Pessoa p : pessoas) {
			  PessoaDTO pessoaDTO = new PessoaDTO();
				for (Estado estado : estados) {
					if(p.getIdEstado() == estado.getId().intValue()) {
						pessoaDTO.setEstadoDesc(estado.getNome()+" - "+estado.getSigla());
						pessoaDTO.setEstado(estado);
						break;
					}
						
				}
			pessoaDTO.setIdpessoa(p.getIdpessoa());	
			pessoaDTO.setNome(p.getNome()!=null?p.getNome():"");
			pessoaDTO.setCpf(p.getCpf()!=null?p.getCpf():"");
			pessoaDTO.setDtnascimento(p.getdtnascimento()!=null? Util.Date2String(p.getdtnascimento()):"");
			pessoaDTO.setPeso(p.getPeso()!=null?p.getPeso().toString():"");
			listPessoaDTO.add(pessoaDTO);
			
		}
		  
		  
	    return new ResponseEntity<List<PessoaDTO>>(listPessoaDTO, HttpStatus.OK);
	  }
	  
	
		 
	  
	  @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
	  public RespostaGeneric<PessoaDTO> buscar(@PathVariable("id") Integer id) throws Exception {
	    Pessoa p = pessoaDAO.find(id);
	    
	    Type listType = new TypeToken<List<Estado>>(){}.getType();
		String jsonGET = estadoWS.GET(URL.BUSCAR.ESTADOS.getURL());
		List<Estado> estados = new Gson().fromJson(jsonGET,listType);
		
		PessoaDTO pessoaDTO = new PessoaDTO();
		for (Estado estado : estados) {
			if(p.getIdEstado() == estado.getId().intValue()) {
				pessoaDTO.setEstadoDesc(estado.getNome()+" - "+estado.getSigla());
				pessoaDTO.setIdpessoa(p.getIdpessoa());	
				pessoaDTO.setNome(p.getNome()!=null?p.getNome():"");
				pessoaDTO.setCpf(p.getCpf()!=null?p.getCpf():"");
				pessoaDTO.setDtnascimento(p.getdtnascimento()!=null? Util.Date2String(p.getdtnascimento()):"");
				pessoaDTO.setPeso(p.getPeso()!=null?p.getPeso().toString():"");
				pessoaDTO.setIdEstado(p.getIdEstado());
				pessoaDTO.setIdRegiao(p.getIdRegiao());
				pessoaDTO.setEstado(estado);
				break;
			}
		}
	    
		
	    if (p == null) {
	      return new RespostaGeneric<PessoaDTO>(4, Mensagem.ERRO_NAO_ENCONTRADA.getMsg(), pessoaDTO);
	    }
	   
	    return new RespostaGeneric<PessoaDTO>(0, Mensagem.SUCESSO.getMsg(), pessoaDTO);
	  }
	  
	  @RequestMapping(value="/cadastrar",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	  @GetMapping(produces="application/json")
	  public RespostaGeneric<Pessoa> cadastrar(@RequestBody @Valid Pessoa pessoa, BindingResult result) {
		  Pessoa pessoaPersist = null;
	  if(result.hasErrors())
		  //return result.getFieldError().getDefaultMessage();
		  return new RespostaGeneric<Pessoa>(1, Mensagem.ERRO.getMsg(), pessoaPersist);
	
		try {
			if(pessoa.getIdpessoa()!=0) {
				pessoaPersist = pessoaDAO.alterar(pessoa);
				return new RespostaGeneric<Pessoa>(6, Mensagem.ALTERADO.getMsg(), pessoaPersist);
			}
			else {
				pessoaPersist = pessoaDAO.salvar(pessoa);
			}
		 
		} catch (Exception e) { 
			if(e.getCause().getClass().equals(ConstraintViolationException.class)) {
				return new RespostaGeneric<Pessoa>(3, Mensagem.ERRO_CPF_CADASTRADO.getMsg(), pessoaPersist);
			}
		}
				  
		  return new RespostaGeneric<Pessoa>(0, Mensagem.SUCESSO.getMsg(), pessoaPersist);
	  }
	  
	  @RequestMapping(value="/carregaCombo")
	  public ResponseEntity<List<Estado>> carregaEstado() throws Exception{
		  Type listType = new TypeToken<List<Estado>>(){}.getType();
		  String jsonGET = estadoWS.GET(URL.BUSCAR.ESTADOS.getURL());
		  List<Estado> estado = new Gson().fromJson(jsonGET,listType);
		/*
		 * List<EstadoDTO> listEstadoDTO = new ArrayList<EstadoDTO>(); for (Estado est :
		 * estado) { EstadoDTO estadoDTO = new EstadoDTO();
		 * estadoDTO.setId(est.getId()); estadoDTO.setNome(est.getNome());
		 * estadoDTO.setSigla(est.getSigla());
		 * estadoDTO.setIdestadoregiao(est.getId()+"/"+est.getRegiao().getId());
		 * listEstadoDTO.add(estadoDTO);
		 * 
		 * }
		 */
		  if(estado == null)
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  return new ResponseEntity<List<Estado>>(estado, HttpStatus.OK);
	  }
	  
	  @RequestMapping(value="/carregaMap", method = RequestMethod.GET)
	  public  ResponseEntity<List<PessoaPorEstadoDTO>> countCadastros() {
		  List<PessoaPorEstadoDTO> listPessoaEstado = pessoaDAO.count();
			  System.out.println("tamanho-- "+listPessoaEstado.size());
		  return new ResponseEntity<List<PessoaPorEstadoDTO>>(listPessoaEstado, HttpStatus.OK);
	}
	  
}
