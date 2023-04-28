import { Component, OnInit, asNativeElements } from '@angular/core';
import { Anonce } from '../../models/anonce';
import { AnonceService } from '../../_services/anonce.service';
import { Ville } from '../../models/ville';
import { VilleService } from '../../_services/ville.service';
import { Reservation } from '../../models/reservation';
import { ReservationService } from '../../_services/reservation.service';
import { User } from '../../models/user';
import { UserService } from '../../_services/user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { StorageService } from '../../_services/storage.service';
import { AuthGaurdService } from '../../_services/auth-gaurd.service';
@Component({
  selector: 'app-anonce',
  templateUrl: './anonce.component.html',
  styleUrls: ['./anonce.component.css']
})
export class AnonceComponent implements OnInit {
  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  userId?: string;

  public anonces!: Anonce[];
  public editAnonce!: Anonce | null| undefined;
  public deleteAnonce!: Anonce| null| undefined;
  public reserveAnonce!: Anonce| null| undefined;
  public reservation!: Reservation;
  public user!: User | null| undefined;
  public users!: User[];
  public utilisateurOne!: User | null| undefined;
  public ville!: Ville | null | undefined;
  public villes!: Ville[];

  constructor(private authGaurdService: AuthGaurdService,
    private reservationService: ReservationService,
      private storageService: StorageService,
       private anonceService: AnonceService, private villeService: VilleService, private userService: UserService ){
  
  
      }
  
  ngOnInit() {
    this.isLoggedIn = this.storageService.isLoggedIn();
    this.getUtilisateurOne();
    this.getAnonces();
    this.getUsers();
    this.getVilles();
  }

  public getUtilisateurOne(): void {
    this.storageService.getUser().subscribe(
      (response: User) => {
        this.utilisateurOne = response;
        console.log(this.utilisateurOne);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
    }
  public onReserveAnonce(anonce: Anonce, utilisateurOne:User): void {
    let rsv = {} as Reservation;
   rsv.idAnonce=anonce;
   rsv.idReservant=utilisateurOne;
   this.reservationService.addReservation(rsv).subscribe(
    (response: Reservation) => {
      this.getAnonces();    
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );
   }




  public getVilles(): void {
    this.villeService.getVilles().subscribe(
      (response: Ville[]) => {
        this.villes = response;
        console.log(this.villes);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  

  public getUsers(): void {
    this.userService.getUsers().subscribe(
      (response: User[]) => {
        this.users = response;
        console.log(this.users);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getAnonces(): void {
    this.anonceService.getAnonces().subscribe(
      (response: Anonce[]) => {
        this.anonces = response;
        console.log(this.anonces);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  public onDeleteAnonce(anonceId: number ): void {
    this.anonceService.deleteAnonce(anonceId).subscribe(
      (response: void) => {
        console.log(response);
        this.getAnonces();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }




  
  public onAddAnonce(addForm: NgForm): void {
    document.getElementById('add-anonce-form')!.click();
    console.log(addForm.value);

    this.anonceService.addAnonce(addForm.value).subscribe(
      (response: Anonce) => {
        
        console.log(response);
        this.getAnonces();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateAnonce(anonce: Anonce): void {
    console.log(anonce);

    this.anonceService.updateAnonce(anonce).subscribe(
      (response: Anonce) => {

       console.log(response);
        this.getAnonces();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  

  public searchAnonces(key: string): void {
    console.log(key);
    const results: Anonce[] = [];
    for (const anonce of this.anonces) {
      //if (anonce..toLowerCase().indexOf(key.toLowerCase()) !== -1
      //|| anonce.idTypeV.toLowerCase().indexOf(key.toLowerCase()) !== -1
      //|| anonce.idBoite.toLowerCase().indexOf(key.toLowerCase()) !== -1
     // || anonce.nbPlace.toLowerCase().indexOf(key.toLowerCase()) !== -1
     //)
      {
      results.push(anonce);
      }
    }
    this.anonces = results;
    if (results.length === 0 || !key) {
      this.getAnonces();
    }
  }



  public onOpenAddModal(): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
      button.setAttribute('data-target', '#addAnonceModal');
    container!.appendChild(button);
    button.click();
  
}




  public onOpenModal(anonce: Anonce, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(this.authGaurdService.canActivate()){  
    if (mode === 'reserve') {
      if ((anonce.nbPlace)>0){

        this.reserveAnonce = anonce;
        button.setAttribute('data-target', '#reserveAnonceModal');
      }else {
        console.log("il reste plus de place");
        alert("il reste plus des places")}
    }
  }
    if (mode === 'add') {
      button.setAttribute('data-target', '#addAnonceModal');
    }
    if (mode === 'edit') {
      this.editAnonce = anonce;
      button.setAttribute('data-target', '#updateAnonceModal');
    }
    if (mode === 'delete') {
    
      this.deleteAnonce = anonce;
      button.setAttribute('data-target', '#deleteAnonceModal');
    }
    container!.appendChild(button);
    button.click();
  }
}