import { Component, OnInit } from '@angular/core';
import { InsurancePlans } from 'src/app/model/InsurancePlans';
import { InsuranceCompanyService } from 'src/app/services/InsuranceCompanyService/insurance-company.service';
import { InsurancePlansService } from 'src/app/services/InsurancePlansService/insurance-plans.service';

@Component({
  selector: 'app-getplanbycompanyname',
  templateUrl: './getplanbycompanyname.component.html',
  styleUrls: ['./getplanbycompanyname.component.css']
})
export class GetplanbycompanynameComponent {

  insurancePlanList:InsurancePlans[]=[];
  companyName!:any;

  constructor(private planService:InsurancePlansService){


    // this.companyName=sessionStorage.getItem('companyName');
    // this.planService.getPlanByCompanyName(this.companyName).subscribe(result=>{this.insurancePlanList=result});
  }
 
 

 


}
