import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MapaComponent } from './mapa/mapa.component';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  imports: [
    HttpClientModule,
    CommonModule,

  ],
  declarations: [
    MapaComponent
  ]
})
export class MapsModule { }
