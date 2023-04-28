import { Component, OnInit } from '@angular/core';
import { StorageService } from '../_services/storage.service';
import { User } from '../models/user';
import { Ville } from '../models/ville';
import { VilleService } from '../_services/ville.service';
import { Vehicule } from '../models/vehicule';
import { VehiculeService } from '../_services/vehicule.service';
import { TypeV } from '../models/typev';
import { TypevService } from '../_services/typev.service';
import { Boite } from '../models/boite';
import { BoiteService } from '../_services/boite.service';
import { UserService } from '../_services/user.service';
import { Anonce } from '../models/anonce';
import { AnonceService } from '../_services/anonce.service';
import { Reservation } from '../models/reservation';
import { ReservationService } from '../_services/reservation.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';





@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  public utilisateurOne!: User | null| undefined;
  public editUtilisateur!: User | null| undefined;
  public deleteUtilisateur!: User| null| undefined;
  public villes!: Ville[];
  public ville: Ville | null| undefined;

  public vehicule: Vehicule | null| undefined;
  public editVehicule!: Vehicule | null| undefined;
  public deleteVehicule!: Vehicule| null| undefined;

  public typeV!: TypeV| null| undefined; 
  public typeVs!: TypeV[];
  public boite!: Boite | null | undefined;
  public boites!: Boite[];

  public anonce: Anonce | null| undefined;
  public editAnonce!: Anonce | null| undefined;
  public deleteAnonce!: Anonce| null| undefined;


  public reservation: Reservation | null| undefined;
  public deleteReservation!: Reservation| null| undefined;





  constructor(private route :ActivatedRoute,
     private villeService: VilleService, 
     private vehiculeService: VehiculeService , 
     private typevService: TypevService,
    private boiteService: BoiteService, 
    private anonceService: AnonceService,
    private storageService: StorageService,
    private userService: UserService ,
    private reservationService :ReservationService
    ) { }
   
  




  ngOnInit(): void {
    this.getUtilisateurOne();
    this.getVilles();
    this.getTypeVs();
    this.getBoites();
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
    public getBoites(): void {
      this.boiteService.getBoites().subscribe(
        (response: Boite[]) => {
          this.boites = response;
          console.log(this.boites);
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }
  
    public getTypeVs(): void {
      this.typevService.getTypeVs().subscribe(
        (response: TypeV[]) => {
          this.typeVs = response;
          console.log(this.typeVs);
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }




    //section reservations
    public onDeleteReservation(reservationId: number ): void {
      this.reservationService.deleteReservation(reservationId).subscribe(
        (response: void) => {
          console.log(response);
          this.getUtilisateurOne();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }
  
    public onOpenReservationModal(reservation: Reservation | null | undefined, mode: string): void {
      const container = document.getElementById('main-container');
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle', 'modal');
      if (mode === 'delete') {
        this.deleteReservation = reservation;
        button.setAttribute('data-target', '#deleteReservationModal');
      }
      container!.appendChild(button);
      button.click();
    }







  //section Anonces

  public onAddAnonce(addForm: NgForm): void {
    document.getElementById('add-anonce-form')!.click();
    console.log(addForm.value);

    this.anonceService.addAnonce(addForm.value).subscribe(
      (response: Anonce) => {
        
        console.log(response);
        this.getUtilisateurOne();
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
       this.getUtilisateurOne();
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
        this.getUtilisateurOne();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }



  public onOpenAddAnonceModal(): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
      button.setAttribute('data-target', '#addAnonceModal');
    container!.appendChild(button);
    button.click();
  
}




  public onOpenAnonceModal(anonce: Anonce, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
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


  


    public onOpenAddModal(): void {
      const container = document.getElementById('main-container');
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle', 'modal');
        button.setAttribute('data-target', '#addUtilisateurModal');
      container!.appendChild(button);
      button.click();
  }
    public onOpenModal(utilisateur: User | null | undefined, mode: string): void {
      const container = document.getElementById('main-container');
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle', 'modal');
      if (mode === 'add') {
        button.setAttribute('data-target', '#addUtilisateurModal');
      }
      if (mode === 'edit') {
        this.editUtilisateur = utilisateur;
        button.setAttribute('data-target', '#updateUtilisateurModal');
      }
      if (mode === 'delete') {
        this.deleteUtilisateur = utilisateur;
        button.setAttribute('data-target', '#deleteUtilisateurModal');
      }
      container!.appendChild(button);
      button.click();
    }

    public onUpdateUtilisateur(utilisateur: User): void {
      console.log(utilisateur);
  
      this.userService.updateUser(utilisateur).subscribe(
        (response: User) => {
  
         console.log(response);
          this.getUtilisateurOne();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }

///section vehicules

    public onOpenAddVehiculeModal(): void {
      const container = document.getElementById('main-container');
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle', 'modal');
        button.setAttribute('data-target', '#addVehiculeModal');
      container!.appendChild(button);
      button.click();
    
  }

  public onOpenVehiculeModal(vehicule: Vehicule, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addVehiculeModal');
    }
    if (mode === 'edit') {
      this.editVehicule = vehicule;
      button.setAttribute('data-target', '#updateVehiculeModal');
    }
    if (mode === 'delete') {
      this.deleteVehicule = vehicule;
      button.setAttribute('data-target', '#deleteVehiculeModal');
    }
    container!.appendChild(button);
    button.click();
  }

  public onAddVehicule(addForm: NgForm): void {
    document.getElementById('add-vehicule-form')!.click();
    console.log(addForm.value);

    this.vehiculeService.addVehicule(addForm.value).subscribe(
      (response: Vehicule) => {
        
        console.log(response);
        this.getUtilisateurOne();
       addForm.reset();
      },
     (error: HttpErrorResponse) => {
       alert(error.message);
       addForm.reset();
     }
    ); 
  }

  public onUpdateVehicule(vehicule: Vehicule): void {
    console.log(vehicule);

    this.vehiculeService.updateVehicule(vehicule).subscribe(
      (response: Vehicule) => {

       console.log(response);
        this.getUtilisateurOne();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteVehicule(vehiculeId: number ): void {
    this.vehiculeService.deleteVehicule(vehiculeId).subscribe(
      (response: void) => {
        console.log(response);
        this.getUtilisateurOne();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }





}