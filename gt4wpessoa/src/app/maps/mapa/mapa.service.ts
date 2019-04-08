import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PessoaPorEstado } from './pessoapoestado';

const API = 'http://localhost:4200/api'

@Injectable({ providedIn: 'root' })
export class MapaService {
    constructor(private http: HttpClient){}

    listPessoasEstado(){
       return this.http
            .get<[PessoaPorEstado]>(API + '/pessoa/carregaMap');
    }
}