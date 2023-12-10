import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { InsuranceClaims } from 'src/app/model/InsuranceClaims';
import { InsuranceClaimsService } from 'src/app/services/InsuranceClaimsService/insurance-claims.service';

@Component({
  selector: 'app-getclaim-patientname',
  templateUrl: './getclaim-patientname.component.html',
  styleUrls: ['./getclaim-patientname.component.css']
})
export class GetclaimPatientnameComponent implements OnInit{
 claimList:InsuranceClaims[]=[];
  patientName!: any;
  constructor(private insuranceClaimService: InsuranceClaimsService) {
    this.patientName = sessionStorage.getItem('patientName');
  }
  ngOnInit(): void {
    this.insuranceClaimService.getClaimForPatient(this.patientName).subscribe((data) =>
    { this.claimList=data}
    );
  }



    

}
