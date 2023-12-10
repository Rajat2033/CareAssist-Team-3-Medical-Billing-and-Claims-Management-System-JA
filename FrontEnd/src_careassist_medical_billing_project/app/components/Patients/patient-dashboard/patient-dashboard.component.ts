import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Patients } from 'src/app/model/Patients';
import { JwtPatientService } from 'src/app/services/PatientsService/jwt-patient.service';
import { PatientsService } from 'src/app/services/PatientsService/patients.service';

@Component({
  selector: 'app-patient-dashboard',
  templateUrl: './patient-dashboard.component.html',
  styleUrls: ['./patient-dashboard.component.css']
})
export class PatientDashboardComponent {
  patientName:any;
  constructor(private router: Router,private jwtPatientService:JwtPatientService,private patientService:PatientsService){


this.patientName =sessionStorage.getItem('patientName');
  }


  getClaimHistory()
  {
    
  }

  logout() {
    
    this.jwtPatientService.clearToken();

    this.router.navigate(['/login/patient']);
  }

}
