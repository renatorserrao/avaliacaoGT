package br.com.cadastro.valid;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.cadastro.models.Pessoa;

public class PessoaValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
        return Pessoa.class.isAssignableFrom(clazz);
    }

	@Override
	public void validate(Object target, Errors errors) {
		 ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "idEstado", "field.required");

        Pessoa pessoa = (Pessoa) target;    
        if(pessoa.getNome().equalsIgnoreCase("")||pessoa.getNome()==null){
            errors.rejectValue("nome", "field.required");
        }
		
	}

}
