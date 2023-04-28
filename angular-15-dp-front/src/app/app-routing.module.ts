import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';

import { AnonceComponent } from './components/anonce/anonce.component';
import { BoiteComponent } from './components/boite/boite.component';
import { ReservationComponent } from './components/reservation/reservation.component';
import { TypeVComponent } from './components/typev/typev.component';
import { UserComponent } from './components/user/user.component';
import { VehiculeComponent } from './components/vehicule/vehicule.component';
import { VilleComponent } from './components/ville/ville.component';

import { AuthGaurdService } from './_services/auth-gaurd.service';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent,canActivate:[AuthGaurdService] },
  { path: 'user', component: BoardUserComponent,canActivate:[AuthGaurdService] },
  { path: 'mod', component: BoardModeratorComponent ,canActivate:[AuthGaurdService]},
  { path: 'admin', component: BoardAdminComponent ,canActivate:[AuthGaurdService]},
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  {path:'', component:AnonceComponent,canActivate:[AuthGaurdService]},
  {path:'boite', component:BoiteComponent,canActivate:[AuthGaurdService]},
  {path:'reservation', component:ReservationComponent,canActivate:[AuthGaurdService]},
  {path:'typev', component:TypeVComponent,canActivate:[AuthGaurdService]},
  {path:'user', component:UserComponent,canActivate:[AuthGaurdService]},
  {path:'vehicule', component:VehiculeComponent,canActivate:[AuthGaurdService]},
  {path:'ville', component:VilleComponent,canActivate:[AuthGaurdService]},
  {path:'anonce', component:AnonceComponent,canActivate:[AuthGaurdService]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
