import { Patients } from "./Patients";

export interface InvoiceDetails {
    invoiceId: number;
    invoiceDate: Date;
    invoiceDueDate: Date;
    invoiceTax: number;
    consultationFee: number;
    diagnosticTestsFee: number;
    diagnosticScanFee: number;
    invoiceTotalAmount: number;
    totalBillAmount: number;
    patient:Patients;
}