import { Vehicule } from "./vehicule"
import { Ville } from "./ville";
import { Anonce } from "./anonce";
import { Role } from "./role";
import { Reservation} from "./reservation";
export interface User {
    id: number;
    username:String;
    email:String;
    password:String;
    tel:String;
    idVille:Ville;
    adresse:String;
    imageUrl:String;
    vehicules:Vehicule[];
    anonces:Anonce[];
    roles:Role[];
    reservations:Reservation[]
}
