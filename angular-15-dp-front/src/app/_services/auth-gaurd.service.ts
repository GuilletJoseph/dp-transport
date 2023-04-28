import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { StorageService } from './storage.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGaurdService implements CanActivate {

  constructor(private router: Router,
    private storageService: StorageService) { }

  canActivate() {
    if (this.storageService.isLoggedIn())
      return true;

    this.router.navigate(['login']);
    return false;

  }

}