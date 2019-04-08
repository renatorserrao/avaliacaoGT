import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pessoa } from './pessoa';
import { error } from '@angular/compiler/src/util';
import { Observable } from 'rxjs';

const API = 'http://localhost:4200/api'

@Injectable({ providedIn: 'root' })
export class PessoaService {
    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'DELETE, POST, GET, OPTIONS',
            'Access-Control-Allow-Headers': 'Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With'
        })
    };
    constructor(private http: HttpClient){}

    listAll(){
       return this.http
            .get<Pessoa[]>(API + '/pessoa/listar');
    }

    findById(id: any): Observable<any>{
        return this.http.get<any[]>(API + '/pessoa/buscar/'+id);
    }

    salvarPessoa(Pessoa: any): Observable<any>{
        return this.http.post<any>(API + '/pessoa/cadastrar', Pessoa, this.httpOptions);
    }
}