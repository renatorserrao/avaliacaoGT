import { Component, OnChanges, SimpleChanges, Input } from '@angular/core';
import { Pessoa } from '../../pessoa/pessoa';

@Component({
  selector: 'gt-pessoas',
  templateUrl: './pessoas.component.html',
  styleUrls: ['./pessoas.component.css']
})
export class PessoasComponent implements OnChanges {

 @Input() pessoa: Pessoa[] = [];
  
 public paginaAtual = 1;
 
 constructor() { }
  
  ngOnChanges(changes: SimpleChanges){
    if(changes.pessoa)
      this.pessoa = this.pessoa;
  }

  

}
