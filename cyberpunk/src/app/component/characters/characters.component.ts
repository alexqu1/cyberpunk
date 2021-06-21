import { Component, Input, OnInit } from '@angular/core';
import { Personajes } from '../../services/personaje.service';

import { ConfPersonajesService } from '../../services/confPersonajes.service';


@Component({
  selector: 'app-characters',
  templateUrl: './characters.component.html',
  styleUrls: ['./characters.component.css']
})
export class CharactersComponent implements OnInit {
  link;
  profilePhotoImage;
  personajes: Personajes[] = [];
  // newPersonajes: Personajes;

  valor = '';
  valor2 = '';
  valor3 = '';


  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  imageName: any;

  constructor(private confPersonajes: ConfPersonajesService) {
  }

  ngOnInit(): void {

    this.listarUsuarios();
  }

  public listarUsuarios(): void {
    this.confPersonajes.getAll().subscribe(personajes => {
      this.personajes = personajes;
    });
  }

  public readUrl(eventTarget): void {
    this.selectedFile = eventTarget.files[0];
    // const fileReader = new FileReader();
    // fileReader.readAsDataURL(eventTarget.files[0]);
    // fileReader.onloadend = (event) => {
    //   this.profilePhotoImage = event.target.result;
    //   console.log(this.profilePhotoImage);
    // };
    // console.log(eventTarget.files[0]);
    // const link = 'C:/Users/Usuario/Desktop/Tareas/Acyberpunk/cyberpunk/src/assets/guardadas/' + eventTarget.files[0].name;
    // console.log(link);
    // console.log(this.profilePhotoImage);
  }




  public createPersonaje(valor, valor2): void {

    const personaje = new Personajes();

    personaje.titulo = valor;
    personaje.bio = valor2;
    personaje.img = this.profilePhotoImage;

    console.log(personaje);


    this.confPersonajes.createPersonaje(personaje).subscribe(personajes => {

      const uploadImageData = new FormData();
      uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);
      this.confPersonajes.postImagen(personajes.id, uploadImageData).subscribe(() => {
        this.listarUsuarios();
      });
    });

  }




}
