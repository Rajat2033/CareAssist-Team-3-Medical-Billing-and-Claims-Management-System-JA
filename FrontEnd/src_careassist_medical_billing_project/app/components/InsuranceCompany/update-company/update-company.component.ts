import { Component, OnInit } from '@angular/core';
import { InsuranceCompany } from 'src/app/model/InsuranceCompany';
import { InsuranceCompanyService } from 'src/app/services/InsuranceCompanyService/insurance-company.service';

@Component({
  selector: 'app-update-company',
  templateUrl: './update-company.component.html',
  styleUrls: ['./update-company.component.css']
})
export class UpdateCompanyComponent {

 company!:InsuranceCompany;

companyId!:number

  constructor(private companyservice:InsuranceCompanyService){}
  


  editCompany(formData:any)
  {
     this.companyservice.updateCompany(formData.form.value,formData.form.value.companyId).subscribe(data=>{
      console.log(data);
      alert("Company Data is updated")})
  }

}
