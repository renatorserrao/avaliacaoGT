import { Component, Input, SimpleChanges, OnChanges } from '@angular/core';

import { Estado } from '../../estado/estado';

@Component({
  selector: 'gt-estados',
  templateUrl: './estados.component.html',
  styleUrls: ['./estados.component.css']
})
export class EstadosComponent implements OnChanges {

  @Input() estados: Estado[] = [];

  constructor() { }

  ngOnChanges(changes: SimpleChanges){
    if(changes.estados)
      this.estados = this.estados;
  }

}
