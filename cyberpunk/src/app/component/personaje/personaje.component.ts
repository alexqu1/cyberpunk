import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Personajes } from '../../services/personaje.service';

import { ConfPersonajesService } from '../../services/confPersonajes.service';


@Component({
  selector: 'app-personaje',
  templateUrl: './personaje.component.html',
  styleUrls: ['./personaje.component.css']
})
export class PersonajeComponent implements OnInit {

  constructor(private confPersonajes: ConfPersonajesService, private activatedRoute: ActivatedRoute) {
  }

  personaje: Personajes;


  ngOnInit(): void {
  const id = this.activatedRoute.snapshot.params['id'];



       this.confPersonajes.getUsuarioById(id).subscribe(personaje => {
       this.personaje = personaje;
console.log('PERSONAJE > ', this.personaje);
    });

  }


}
