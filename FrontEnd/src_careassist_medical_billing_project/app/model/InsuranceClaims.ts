import { InsurancePlans } from "./InsurancePlans";
import { Patients } from "./Patients";

export interface InsuranceClaims {
    claimId: number;
    claimAmount: number;
    claimStatus: string;
    invoiceAmount: number;
    patient:Patients;
    plans:InsurancePlans;
}