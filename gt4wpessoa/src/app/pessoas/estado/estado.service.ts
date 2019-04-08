import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Estado } from './estado';

const API = 'http://localhost:4200/api'

@Injectable({ providedIn: 'root' })
export class EstadoService {
    constructor(private http: HttpClient){}

    listEstado(){
       return this.http
            .get<Estado[]>(API + '/pessoa/carregaCombo');
    }
}