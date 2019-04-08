import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule} from '@angular/forms';

import { PessoaComponent } from './pessoa/pessoa.component';
import { PessoaFormComponent } from './pessoa-form/pessoa-form.component';
import { EstadoListComponent } from './estado-list/estado-list.component';
import { EstadosComponent } from './estado-list/estados/estados.component';
import { EstadoComponent } from './estado/estado.component';
import { PessoasListComponent } from './pessoas-list/pessoas-list.component';
import { PessoasComponent } from './pessoas-list/pessoas/pessoas.component';
import { PessoasRoutingModlue } from './pessoas.routing.module';
import { NgxMaskModule } from 'ngx-mask';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import {MatSelectModule} from '@angular/material/select';

import {NoopAnimationsModule} from '@angular/platform-browser/animations';



@NgModule({
  imports: [
    HttpClientModule,
    CommonModule,
    FormsModule,
    PessoasRoutingModlue,
    NgxMaskModule.forChild(),
    NgxPaginationModule,
    Ng2SearchPipeModule,
    MatSelectModule,
    NoopAnimationsModule
  ],
  declarations: [
    PessoaComponent, 
    PessoaFormComponent, 
    EstadoListComponent, 
    EstadosComponent,
    EstadoComponent,
    PessoasListComponent,
    PessoasComponent
  ]
})
export class PessoasModule { }
