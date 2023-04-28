
import { User } from "./user"
import { Anonce } from "./anonce"
export interface Reservation {
    id: number;
    idReservant: User;
    idAnonce: Anonce;
}
