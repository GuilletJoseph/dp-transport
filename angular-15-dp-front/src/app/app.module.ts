import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AnonceComponent } from './components/anonce/anonce.component';
import { BoiteComponent } from './components/boite/boite.component';
import { ReservationComponent } from './components/reservation/reservation.component';
import { TypeVComponent } from './components/typev/typev.component';
import { UserComponent } from './components/user/user.component';
import { VehiculeComponent } from './components/vehicule/vehicule.component';
import { VilleComponent } from './components/ville/ville.component';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { httpInterceptorProviders } from './_helpers/http.interceptor';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    AnonceComponent,
    BoiteComponent,
    ReservationComponent,
    TypeVComponent,
    UserComponent,
    VehiculeComponent,
    VilleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
