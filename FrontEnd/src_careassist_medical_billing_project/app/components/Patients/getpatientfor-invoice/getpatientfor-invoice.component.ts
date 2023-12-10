import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patients } from 'src/app/model/Patients';
import { JwtAdminService } from 'src/app/services/AdminService/jwt-admin.service';
import { PatientsService } from 'src/app/services/PatientsService/patients.service';

@Component({
  selector: 'app-getpatientfor-invoice',
  templateUrl: './getpatientfor-invoice.component.html',
  styleUrls: ['./getpatientfor-invoice.component.css']
})
export class GetpatientforInvoiceComponent implements OnInit{
  patientList: Patients[] = [];

  constructor(private patientService:PatientsService,private jwtAdminService:JwtAdminService,private router:Router){}
  ngOnInit(): void {
    this.patientService.getPatientforInvoice().subscribe(data=>{
      this.patientList = data;
    })
  }

 

  generateInvoice(patientId: number) {
    // Navigate to the invoice generation page with the patient ID
    this.router.navigate(['/generateinvoice', patientId]);
  }
}
