import { Boite } from "./boite";
import { TypeV } from "./typev";
import { User } from "./user";

export interface Vehicule {
  id: number;
  name: string;
  idTypeV: TypeV;
  nbPlace: number;
  idBoite: Boite;
  imageUrl: string;
  immatriculation:string;
  idUser:User; 
  
}
