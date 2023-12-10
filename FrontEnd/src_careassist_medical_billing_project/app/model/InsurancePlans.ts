import { InsuranceCompany } from "./InsuranceCompany";

export interface InsurancePlans {
    planId: number;
    planName: string;
    planType: string;
    planCoverAmount: number;
    planEmi: number;
    planDetails: string;
    company:InsuranceCompany;

}