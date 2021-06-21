import { Component, OnInit } from '@angular/core';
import { Personajes } from '../../services/personaje.service';
import { ConfPersonajesService } from '../../services/confPersonajes.service';
import { Email } from '../../services/email.service';

@Component({
  selector: 'app-contacta',
  templateUrl: './contacta.component.html',
  styleUrls: ['./contacta.component.css']
})
export class ContactaComponent implements OnInit {

  constructor(private confPersonajes: ConfPersonajesService) { }

  newEmail: Email[];
  valor = '';

  ngOnInit(): void {
  }

  public getEmail(valor): void {

    const email = new Email();
    email.email = valor;
    console.log(email);

    this.confPersonajes.postEmail(email).subscribe(emails => {
      this.newEmail = emails;
    });

  }

}
