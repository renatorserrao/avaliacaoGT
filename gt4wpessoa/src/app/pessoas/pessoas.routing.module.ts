import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PessoaFormComponent } from './pessoa-form/pessoa-form.component';
import { PessoasListComponent } from './pessoas-list/pessoas-list.component';
import { EstadoListComponent } from './estado-list/estado-list.component';
import { NotFoundComponent } from '../errors/not-found/not-found.component';

const pessoaRoutes: Routes =[
    { path: 'pessoa/form', component: PessoaFormComponent },
    { path: 'pessoa/form/:id', component: PessoaFormComponent },
    { path: 'pessoa/lista', component: PessoasListComponent },
    { path: 'pessoa/estado', component: EstadoListComponent },
    { path: '**', component: NotFoundComponent },
  ]

  @NgModule({
    imports: [
        RouterModule.forChild(pessoaRoutes)
    ],
    exports : [RouterModule]
})

  export class PessoasRoutingModlue{

  }