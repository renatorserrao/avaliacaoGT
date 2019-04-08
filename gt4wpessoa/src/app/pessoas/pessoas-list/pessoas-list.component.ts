import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

import { Pessoa } from '../pessoa/pessoa';
import { PessoaService } from '../pessoa/pessoa.service';

@Component({
  selector: 'gt-pessoas-list',
  templateUrl: './pessoas-list.component.html',
  styleUrls: ['./pessoas-list.component.css']
})
export class PessoasListComponent implements OnInit {

  pessoa: Pessoa[] = [];

  constructor(
    private pessoaService: PessoaService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.pessoaService.listAll().subscribe(pessoa => this.pessoa = pessoa);
  }

}
