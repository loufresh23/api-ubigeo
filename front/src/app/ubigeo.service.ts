import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class UbigeoService {

  private url = "http://localhost:8081";

  constructor( private http: HttpClient ) { }

  departamentos() {
    return this.http.get(`${this.url}/departamentos`)
      .pipe(
        map( (resp: any) => resp.data)
      );
  }

  provincias(departamento: string) {

    const params = new HttpParams()
      .set('departamento', departamento);

    return this.http.get(`${this.url}/provincias`, {params})
      .pipe(
        map( (resp: any) => resp.data)
      );
  }

  distritos(departamento: string, provincia: string) {
    const params = new HttpParams()
      .set('departamento', departamento)
      .set('provincia', provincia);

    return this.http.get(`${this.url}/distritos`, {params})
      .pipe(
        map( (resp: any) => resp.data)
      );
  }

}
