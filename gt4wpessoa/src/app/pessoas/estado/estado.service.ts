import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Estado } from './estado';
import { environment } from 'src/environments/environment';



@Injectable({ providedIn: 'root' })
export class EstadoService {
    constructor(private http: HttpClient){}

    listEstado(){
       return this.http
            .get<Estado[]>(environment.host + '/pessoa/carregaCombo');
    }
}