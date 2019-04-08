import { Estado } from '../estado/estado';

export interface Pessoa{
    idpessoa:number;
    cpf:string;
    nome:string;
    dtnascimento:string;
    peso:string;
    estadoDesc:string;
    idEstado:number;
    idRegiao:number;
    estado:Estado;

}