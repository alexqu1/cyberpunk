import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from '../component/home/home.component';
import { AboutComponent } from '../component/about/about.component';
import { CharactersComponent } from '../component/characters/characters.component';
import { TrailerComponent } from '../component/trailer/trailer.component';
import { ContactaComponent } from '../component/contacta/contacta.component';

import { PersonajeComponent } from '../component/personaje/personaje.component';
import { ComprarComponent } from '../component/comprar/comprar.component';


const APP_ROUTES: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'trailer', component: TrailerComponent },
  { path: 'characters', component: CharactersComponent },
  { path: 'characters/:id', component: PersonajeComponent },
  { path: 'contacta', component: ContactaComponent },
  { path: 'comprar', component: ComprarComponent },
  { path: '**', pathMatch: 'full', redirectTo: 'home' }
];

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);
