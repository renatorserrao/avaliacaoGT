import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { EstadoService } from '../estado/estado.service';
import { Estado } from '../estado/estado';

@Component({
  selector: 'gt-estado-list',
  templateUrl: './estado-list.component.html',
  styleUrls: ['./estado-list.component.css']
})
export class EstadoListComponent implements OnInit {

  estado: Estado[] = [];

  constructor(
    private estadoService: EstadoService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.estadoService.listEstado().subscribe(estado => this.estado = estado);
  }

}
