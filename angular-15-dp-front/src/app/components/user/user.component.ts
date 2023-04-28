import { Component, OnInit , Input, Output} from '@angular/core';
import { User } from '../../models/user';
import { UserService } from '../../_services/user.service';
import { Ville } from '../../models/ville';
import { VilleService } from '../../_services/ville.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  public users!: User[];
  public editUser!: User | null| undefined;
  public deleteUser!: User| null| undefined;
  public villes!: Ville[];
  public ville: Ville | null| undefined;
  constructor( private route :ActivatedRoute,  private userService: UserService, 
    private villeService: VilleService ){
  }
  
  ngOnInit() {
    this.getUsers();
    this.getVilles();
    
  }



  public getVilles(): void {
    this.villeService.getVilles().subscribe(
      (response: Ville[]) => {
        this.villes = response;
       // console.log(this.villes);
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

  



  public onAddUser(addForm: NgForm): void {
    document.getElementById('add-user-form')!.click();
    console.log(addForm.value);

    this.userService.addUser(addForm.value).subscribe(
      (response: User) => {
        console.log(response);
        this.getUsers();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateUser(user: User): void {
    console.log(user);

    this.userService.updateUser(user).subscribe(
      (response: User) => {

       console.log(response);
        this.getUsers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteUser(userId: number ): void {
    this.userService.deleteUser(userId).subscribe(
      (response: void) => {
        console.log(response);
        this.getUsers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchUsers(key: string): void {
    console.log(key);
    const results: User[] = [];
    for (const user of this.users) {
      if (user.username.toLowerCase().indexOf(key.toLowerCase()) !== -1
      //|| user.idTypeV.toLowerCase().indexOf(key.toLowerCase()) !== -1
      //|| user.idBoite.toLowerCase().indexOf(key.toLowerCase()) !== -1
     // || user.nbPlace.toLowerCase().indexOf(key.toLowerCase()) !== -1
     ) {
      results.push(user);
      }
    }
    this.users = results;
    if (results.length === 0 || !key) {
      this.getUsers();
    }
  }



  public onOpenAddModal(): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
      button.setAttribute('data-target', '#addUserModal');
    container!.appendChild(button);
    button.click();
}
  public onOpenModal(user: User| null| undefined, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addUserModal');
    }
    if (mode === 'edit') {
      this.editUser = user;
      button.setAttribute('data-target', '#updateUserModal');
    }
    if (mode === 'delete') {
      this.deleteUser = user;
      button.setAttribute('data-target', '#deleteUserModal');
    }
    container!.appendChild(button);
    button.click();
  }
}