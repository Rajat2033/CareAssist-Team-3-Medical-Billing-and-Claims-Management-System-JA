import { Component, OnInit } from '@angular/core';
import { InsuranceClaims } from 'src/app/model/InsuranceClaims';
import { Patients } from 'src/app/model/Patients';
import { InsuranceCompanyService } from 'src/app/services/InsuranceCompanyService/insurance-company.service';
import { PatientsService } from 'src/app/services/PatientsService/patients.service';

@Component({
  selector: 'app-viewclaimfor-company',
  templateUrl: './viewclaimfor-company.component.html',
  styleUrls: ['./viewclaimfor-company.component.css']
})
export class ViewclaimforCompanyComponent implements OnInit {
  claimList:InsuranceClaims[]=[];
  companyName!: any;

  
  searchQuery!: string;
  searchResults: Patients[]=[]; 
  constructor(private companyService: InsuranceCompanyService,private patientService:PatientsService){
   this.companyName=sessionStorage.getItem('companyName');
  }



  
  ngOnInit(): void {
   this.companyService.getClaimByCompany(this.companyName).subscribe(data=>{
    this.claimList=data;
   })
  }




  searchPatients() {
    if (this.searchQuery) {
      this.patientService.getPatientForCompanyByName(this.searchQuery)
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
