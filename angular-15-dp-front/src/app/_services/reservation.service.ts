import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reservation } from '../models/reservation';
import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class ReservationService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public getReservations(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(`${this.apiServerUrl}/api/reservation/all`);
  }

  public addReservation(reservation: Reservation): Observable<Reservation> {
    return this.http.post<Reservation>(`${this.apiServerUrl}/api/reservation/add`, reservation);
  }

  public updateReservation(reservation: Reservation): Observable<Reservation> {
    return this.http.put<Reservation>(`${this.apiServerUrl}/api/reservation/update`, reservation);
  }

  public deleteReservation(reservationId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/api/reservation/delete/${reservationId}`);
  }
}
