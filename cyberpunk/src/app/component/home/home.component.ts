import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() {
  }

  play = false;
  xbox = false;
  computadora = false;

  ngOnInit(): void {
  }

  fondo: boolean;
  public changeFondo(): void {
    this.fondo = !this.fondo;
  }



  togglePlayStation(): void {
    this.play = !this.play;
    this.xbox = false;
    this.computadora = false;
  }

  toggleXbox(): void {
    this.xbox = !this.xbox;
    this.play = false;
    this.computadora = false;
  }

  togglePc(): void {
    this.computadora = !this.play;
    this.xbox = false;
    this.play = false;
  }

}
