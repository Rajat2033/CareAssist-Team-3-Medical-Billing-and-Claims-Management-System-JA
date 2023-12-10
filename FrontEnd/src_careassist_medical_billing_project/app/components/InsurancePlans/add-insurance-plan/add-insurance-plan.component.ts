import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { InsurancePlansService } from 'src/app/services/InsurancePlansService/insurance-plans.service';

@Component({
  selector: 'app-add-insurance-plan',
  templateUrl: './add-insurance-plan.component.html',
  styleUrls: ['./add-insurance-plan.component.css']
})
export class AddInsurancePlanComponent {

  companyName!:any;
  constructor(private planService: InsurancePlansService,private route:ActivatedRoute) {
   this.companyName=sessionStorage.getItem('companyName');
  }

  addPlan(formData:any) {
    console.log(this.companyName);
    this.planService.insertPlan(formData.form.value,this.companyName).subscribe(
      (response) => {
        alert('New Insurance Plan Added successfully:');

      }
    );
  }
}


