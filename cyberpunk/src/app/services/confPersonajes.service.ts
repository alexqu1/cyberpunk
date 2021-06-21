import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Personajes } from './personaje.service';
import { Email } from './email.service';

@Injectable({
  providedIn: 'root'
})
export class ConfPersonajesService {

  constructor(public http: HttpClient) { }

  public getAll(): Observable<Personajes[]> {
    return this.http.get<Personajes[]>('http://localhost:8081/personaje');
  }

  public createPersonaje(personaje): Observable<Personajes> {
    return this.http.post<Personajes>('http://localhost:8081/personaje', personaje);
  }

  public getUsuarioById(id : number): Observable<Personajes> {
    return this.http.get<Personajes>('http://localhost:8081/personaje/' + id );
  }

  public postEmail(email): Observable<Email[]> {
    return this.http.post<Email[]>('http://localhost:8081/guardarEmail/' , email );
  }

  public postImagen(id, uploadImageData): Observable<any> {
    return this.http.post('http://localhost:8081/personaje/' + id + '/image/upload/', uploadImageData);
  }


}
