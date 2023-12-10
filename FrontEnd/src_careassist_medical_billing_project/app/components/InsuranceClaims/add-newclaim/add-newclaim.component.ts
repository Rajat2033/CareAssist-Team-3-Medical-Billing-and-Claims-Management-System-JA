import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { InsuranceClaimsService } from 'src/app/services/InsuranceClaimsService/insurance-claims.service';

@Component({
  selector: 'app-add-newclaim',
  templateUrl: './add-newclaim.component.html',
  styleUrls: ['./add-newclaim.component.css']
})
export class AddNewclaimComponent  implements OnInit{

  patientName!: string;
  planId!: number;
  constructor(private claimService: InsuranceClaimsService,private route:ActivatedRoute){


  }
  ngOnInit(): void {
   this.route.params.subscribe(params => {this.patientName=params['patientName'],this.planId=params['planId'];});
  }
 
  addInsuranceClaim(formData: any) {


    console.log(formData);
    const insurnaceClaim=formData.form.value;
    this.claimService.addClaim(insurnaceClaim,this.patientName,this.planId).subscribe(
      (response) => {
       alert('Claim Added successfully:');

      }
    );
  }



}


