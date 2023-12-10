import { Component } from '@angular/core';
import { Patients } from 'src/app/model/Patients';
import { PatientsService } from 'src/app/services/PatientsService/patients.service';

@Component({
  selector: 'app-getby-patientname',
  templateUrl: './getby-patientname.component.html',
  styleUrls: ['./getby-patientname.component.css']
})
export class GetbyPatientnameComponent {

  searchQuery!: string;
  searchResults: Patients[]=[]; 

  constructor(private patientService: PatientsService) {}

  searchPatients() {
    if (this.searchQuery) {
      this.patientService.getPatientByName(this.searchQuery)
        .subscribe(
          (results) => {
            this.searchResults[0] = results;
          },
          (error) => {
            console.error('Error searching patients:', error);
          }
        );
    } else {
      console.warn('Empty search query');
    }
  }

}
