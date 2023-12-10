import { Component } from '@angular/core';
import { InsuranceClaimsService } from 'src/app/services/InsuranceClaimsService/insurance-claims.service';

@Component({
  selector: 'app-update-insurance-claim',
  templateUrl: './update-insurance-claim.component.html',
  styleUrls: ['./update-insurance-claim.component.css']
})
export class UpdateInsuranceClaimComponent {
claimId!:number;
  constructor(private claimService:InsuranceClaimsService){}



  editClaimStatus(formData:any){
    this.claimService.updateClaimStatus(formData.form.value,formData.form.value.claimId).subscribe(res=>{
      alert("Claim Status Updated Successfully")
      console.log(res);
    })
  }

}
