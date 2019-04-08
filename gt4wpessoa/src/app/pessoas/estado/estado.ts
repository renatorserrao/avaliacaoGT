import { Regiao } from './regiao';

export interface Estado {
    id:number;
    sigla:string;
    nome:string;
    regiao:Regiao;
    idestadoregiao:string;
}