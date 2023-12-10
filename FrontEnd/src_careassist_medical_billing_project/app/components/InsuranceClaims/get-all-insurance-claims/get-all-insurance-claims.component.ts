import { Component, OnInit } from '@angular/core';
import { InsuranceClaims } from 'src/app/model/InsuranceClaims';
import { InsuranceClaimsService } from 'src/app/services/InsuranceClaimsService/insurance-claims.service';

@Component({
  selector: 'app-get-all-insurance-claims',
  templateUrl: './get-all-insurance-claims.component.html',
  styleUrls: ['./get-all-insurance-claims.component.css']
})
export class GetAllInsuranceClaimsComponent implements OnInit {

  claimsList: InsuranceClaims[] = [];

  constructor(private claimService: InsuranceClaimsService) { }
  ngOnInit(): void {
    this.claimService.getAllInsuranceClaims().subscribe(data => {
      this.claimsList = data;
    }
    )
  }

}
