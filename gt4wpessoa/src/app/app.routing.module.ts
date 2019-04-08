import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'

import { NotFoundComponent } from './errors/not-found/not-found.component';
import { PessoaFormComponent } from './pessoas/pessoa-form/pessoa-form.component';
import { EstadoListComponent } from './pessoas/estado-list/estado-list.component';
import { PessoasListComponent } from './pessoas/pessoas-list/pessoas-list.component';
import { MapaComponent } from './maps/mapa/mapa.component';

const routes: Routes = [
    
    { path: '', redirectTo: '/pessoa/lista',pathMatch: 'full' },
    { path: 'maps', component: MapaComponent }
];

@NgModule({
    imports: [ 
        RouterModule.forRoot(routes) 
    ],
    exports: [ RouterModule ]
})
export class AppRoutingModule { }