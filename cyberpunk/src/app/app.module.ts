import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { APP_ROUTING } from './app.routes.ts/app.routes';

import { FormsModule } from '@angular/forms';
import { AboutComponent } from './component/about/about.component';
import { TrailerComponent } from './component/trailer/trailer.component';
import { CharactersComponent } from './component/characters/characters.component';

import { RouterModule } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { PersonajeComponent } from './component/personaje/personaje.component';

import { ContactaComponent } from './component/contacta/contacta.component';
import { HttpClientModule } from '@angular/common/http';
import { SafePipe } from './pipes/safe.pipe';
import { ComprarComponent } from './component/comprar/comprar.component';


@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    TrailerComponent,
    CharactersComponent,
    HomeComponent,
    PersonajeComponent,
    ContactaComponent,
    SafePipe,
    ComprarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    APP_ROUTING,
    HttpClientModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
