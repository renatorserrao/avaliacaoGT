import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PessoaPorEstado } from './pessoapoestado';
import { environment } from 'src/environments/environment';


@Injectable({ providedIn: 'root' })
export class MapaService {
    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'DELETE, POST, GET, OPTIONS',
            'Access-Control-Allow-Headers': 'Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With'
        })
    };
    constructor(private http: HttpClient){}

    listPessoasEstado(){
       return this.http
            .get<[PessoaPorEstado]>(environment.host + '/pessoa/carregaMap', this.httpOptions);
    }
}