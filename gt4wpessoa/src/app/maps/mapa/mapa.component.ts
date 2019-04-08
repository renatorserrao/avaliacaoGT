import { Component, OnInit, Input, SimpleChanges } from '@angular/core';
import L = require('leaflet');
import { MapaService } from './mapa.service';
import { PessoaPorEstado } from './pessoapoestado';
import { Coordenadas } from './coordenadas';
import { COORDENADAS } from './coordenadas.mock';

@Component({
  selector: 'gt-mapa',
  templateUrl: './mapa.component.html',
  styleUrls: ['./mapa.component.css']
})
export class MapaComponent implements OnInit {

 @Input() pesestado: PessoaPorEstado[] = [];
  
 coordenadas: Coordenadas[] = COORDENADAS;

  constructor(
    private mapaService: MapaService
  ) { }

  ngOnChanges(changes: SimpleChanges): void {
    if(changes.pesestado)
    this.carregaMapa();
  }
  
  ngOnInit(): void {
    this.mapaService.listPessoasEstado().subscribe(pes => this.pesestado = pes); 
    
    }
    
    carregaMapa(){
      console.log(this.pesestado.length);
           

    var initialCoordinates: any = [-15.83, -47.86];
    var initialZoomLevel = 4;
 
    var muxiIconProperties: any = {
      iconUrl: "./assets/img/iconfinder-map-marker.png"
    , iconSize: [34, 49]
    , iconAnchor: [22, 59]
    , popupAnchor: [0, -50]
    }; 


    // create a map in the "map" div, set the view to a given place and zoom
    var map = L.map('map').setView(initialCoordinates, initialZoomLevel);
    
    // add an OpenStreetMap tile layer
    L.tileLayer.wms('http://sistemas.gt4w.com.br/geoserver/processo_seletivo/wms',{
      layers:'processo_seletivo:ufs_brasil'
    }
    ).addTo(map); 

    var muxiIcon = L.icon(muxiIconProperties);

     let i = 0;
    for(let p of this.pesestado){
      for(let c of this.coordenadas){
          if(c.id===p.id){
          var muxiMarkerMessage = "Pessoas Cadastradas no Estado "+c.estado+" : "+p.qtd;
          var muxiCoordinates: any = [c.coordenada1,c.coordenada2];
          L.marker(muxiCoordinates, {icon: muxiIcon}).addTo(map).bindPopup(muxiMarkerMessage).openPopup();
          }
        }      
     
    }
  
}

}
