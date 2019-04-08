import { Component, OnInit, inject, Input } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { NotifierService } from 'angular-notifier';


import { Estado } from '../estado/estado';
import { EstadoService } from '../estado/estado.service';
import { FormGroup, NgForm, NgModel } from '@angular/forms';
import { PessoaService } from '../pessoa/pessoa.service';
import { DatePipe } from '@angular/common';
import { error } from 'util';
import { Pessoa } from '../pessoa/pessoa';
import { a } from '@angular/core/src/render3';

@Component({
  selector: 'gt-pessoa-form',
  templateUrl: './pessoa-form.component.html',
  styleUrls: ['./pessoa-form.component.css']
})
export class PessoaFormComponent implements OnInit {

  pessoaFormGroup: FormGroup;

  model: any = {};

  private notifier: NotifierService;

  @Input() estados: Estado[] = [];

  pessoa: Pessoa;

  constructor(
    private estadoService: EstadoService,
    private activatedRoute: ActivatedRoute,
    private pessoaService: PessoaService,
    notifier: NotifierService,
    private router: Router
  ) { 
    this.notifier = notifier;
  }

  ngOnInit(): void {
    
    this.estadoService.listEstado().subscribe(estados => this.estados = estados);
    this.estados.sort((a,b) => a.nome.localeCompare(b.nome));
    this.model = {};
    console.log(this.activatedRoute.snapshot.params.id);
    
    
      if(this.activatedRoute.snapshot.params.id){
        const id: number = this.activatedRoute.snapshot.params.id;
        this.pessoaService.findById(id)
        .subscribe(r =>{
            this.pessoa = r.objeto;
            console.log("this.pessoa.cpf "+this.pessoa.cpf)
            this.model = this.pessoa;
            var datePipe = new DatePipe('en-US'); 
            var newDate = new Date(this.parseDate(this.model.dtnascimento));
            this.model.dtnascimento = datePipe.transform(newDate, 'yyyy-MM-dd');
            console.log("this.model.estado-- "+this.model.estado);
           
        });
      }
          
  }

  validarCPF() {
    
    const strCPF = this.model.cpf;
    console.log(this.model.cpf);
    
    let Soma;
    let Resto;
    Soma = 0;

    for (let i = 1; i <= 9; i++) {
      Soma = Soma + parseFloat(strCPF.substring(i - 1, i)) * (11 - i);
    }

    Resto = (Soma * 10) % 11;

    if ((Resto === 10) || (Resto === 11)) { Resto = 0; }
    if (Resto !== parseFloat(strCPF.substring(9, 10)) ) {
      this.erroCPF();
      return false;
    }

    Soma = 0;
    for (let i = 1; i <= 10; i++) { Soma = Soma + parseFloat(strCPF.substring(i - 1, i)) * (12 - i); }
    Resto = (Soma * 10) % 11;

    if ((Resto === 10) || (Resto === 11)) { Resto = 0; }
    if (Resto !== parseFloat(strCPF.substring(10, 11) ) ) {
      this.erroCPF();
      return false;
    }

    if (this.model.invalid) {
      return ;
    }
    return true;
  }

  onSelect(id) {
    console.log(id);
    this.model.idEstado = id.substring(0,2);
    this.model.idRegiao = id.substring(3);
  
  }

  
  salvar(){
    var datePipe = new DatePipe('en-US');
    this.model.dtnascimento = datePipe.transform(this.model.dtnascimento, 'dd/MM/yyyy');
    console.log(this.model.estado);
    this.model.idEstado = this.model.estado.id;
    this.model.idRegiao = this.model.estado.regiao.id;
    console.log(this.model.idEstado);
    console.log(this.model.idRegiao);
    if(!this.validarCPF()){

    }else if(this.model.idEstado==0 || this.model.idEstado == null){
      this.notifier.notify('error','Preencha o Estado.');

    }else{
      this.pessoaService.salvarPessoa(this.model).subscribe(r => {
        if(r.codigo === 0){
          this.notifier.notify('success','Cadastro Realizado com Sucesso!');
          this.model = '';
          this.router.navigate(['pessoa/lista']);
          
        }else if(r.codigo === 6){
          this.notifier.notify('success','Pessoa Alterada com Sucesso!');
          this.model = r.objeto;
          
        }
        else {
          this.notifier.notify('error',r.mensagem);
          console.log(r);
        }
        
      });
    }
  }

  erroCPF() {
    //this.model.cpf.setErrors({'nomatch': true});
    //this.model.cpf.markATouched();
    //this.model.cpf.updateValueAndValidity();
    this.model.cpf = '';
    this.notifier.notify( 'error', 'CPF inválido' );
  }

getFormGroupClass(isValid : boolean, isPristine: boolean) : {} {
    return {
        'form-group' : true,
        'has-danger': !isValid && !isPristine,
        'has-success': isValid && !isPristine
    };
}
getFormControlClass(isValid : boolean, isPristine: boolean) : {} {
    return {
        'form-control' : true,
        'has-danger': !isValid && !isPristine,
        'has-success': isValid && !isPristine
    };
}
parseDate(value: any): Date | null {
  if ((typeof value === 'string') && (value.indexOf('/') > -1)) {
    const str = value.split('/');

    const year = Number(str[2]);
    const month = Number(str[1]) - 1;
    const date = Number(str[0]);

    return new Date(year, month, date);
  } else if((typeof value === 'string') && value === '') {
    return new Date();
  }
  const timestamp = typeof value === 'number' ? value : Date.parse(value);
  return isNaN(timestamp) ? null : new Date(timestamp);
}

}
