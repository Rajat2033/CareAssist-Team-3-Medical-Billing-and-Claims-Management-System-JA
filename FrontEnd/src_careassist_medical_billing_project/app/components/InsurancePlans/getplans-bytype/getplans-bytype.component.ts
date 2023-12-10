import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { InsurancePlans } from 'src/app/model/InsurancePlans';
import { Patients } from 'src/app/model/Patients';
import { InsurancePlansService } from 'src/app/services/InsurancePlansService/insurance-plans.service';
import { PatientsService } from 'src/app/services/PatientsService/patients.service';

@Component({
  selector: 'app-getplans-bytype',
  templateUrl: './getplans-bytype.component.html',
  styleUrls: ['./getplans-bytype.component.css']
})
export class GetplansBytypeComponent {

  insurancePlanList!:InsurancePlans[];
  patientName!:any;

  constructor(private planService:InsurancePlansService,private route:ActivatedRoute,private router:Router,private patientService:PatientsService){

   
  }
  
 
  searchInput:string = '';



  onSearch() {
    if (this.searchInput.trim() !== '') {
      this.planService.searchPlans(this.searchInput).subscribe(list => {
        this.insurancePlanList = list ;
        console.log(this.insurancePlanList)
      });
    }
  }
  generateClaim(planId:number)
  {
 
   this.patientName=sessionStorage.getItem('patientName');
    this.router.navigate(['/addclaim/',this.patientName , planId ]);
  }

}

