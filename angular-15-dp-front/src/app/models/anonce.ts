import { User } from "./user";
import { Ville } from "./ville";
import { Vehicule} from "./vehicule";
import { Reservation} from "./reservation";
export interface Anonce {
    id: number;
    idUser: User;
    date: string;
    hDebut: string;
    nbPlace: number;
    idVilleDepart:Ville;
    idVilleArrive:Ville;
    idVehicule:Vehicule;
    reservations:Reservation[]
}
