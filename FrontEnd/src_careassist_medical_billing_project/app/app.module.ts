import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { RegisterPatientsComponent } from './components/Patients/register-patients/register-patients.component';
import { UpdatePatientsComponent } from './components/Patients/update-patients/update-patients.component';
import { GetAllPatientsComponent } from './components/Patients/get-all-patients/get-all-patients.component';
import { RegisterCompanyComponent } from './components/InsuranceCompany/register-company/register-company.component';
import { UpdateCompanyComponent } from './components/InsuranceCompany/update-company/update-company.component';
import { GetAllCompaniesComponent } from './components/InsuranceCompany/get-all-companies/get-all-companies.component';
import { AddInsurancePlanComponent } from './components/InsurancePlans/add-insurance-plan/add-insurance-plan.component';
import { GetAllInsurancePlansComponent } from './components/InsurancePlans/get-all-insurance-plans/get-all-insurance-plans.component';
import { RegisterProviderComponent } from './components/HealthcareProvider/register-provider/register-provider.component';
import { UpdateProviderComponent } from './components/HealthcareProvider/update-provider/update-provider.component';
import { GetAllProvidersComponent } from './components/HealthcareProvider/get-all-providers/get-all-providers.component';
import { UpdateInsuranceClaimComponent } from './components/InsuranceClaims/update-insurance-claim/update-insurance-claim.component';
import { GetAllInsuranceClaimsComponent } from './components/InsuranceClaims/get-all-insurance-claims/get-all-insurance-claims.component';
import { GenerateInvoiceComponent } from './components/InvoiceDetails/generate-invoice/generate-invoice.component';
import { GetAllInvoicesComponent } from './components/InvoiceDetails/get-all-invoices/get-all-invoices.component';

import { AdmindashboardComponent } from './components/Admin/admindashboard.component';
import { LoginAdminComponent } from './components/Admin/login-admin/login-admin.component';
import { LoginPatientComponent } from './components/Patients/login-patient/login-patient.component';
import { PatientDashboardComponent } from './components/Patients/patient-dashboard/patient-dashboard.component';
import { LoginProviderComponent } from './components/HealthcareProvider/login-provider/login-provider.component';
import { ProviderDashboardComponent } from './components/HealthcareProvider/provider-dashboard/provider-dashboard.component';
import { DashboardComponent } from './components/InsuranceCompany/company-dashboard/dashboard.component';
import { HomepageComponent } from './components/Homepage/homepage.component';
import { LoginCompanyComponent } from './components/InsuranceCompany/login-company/login-company.component';
import { AddNewclaimComponent } from './components/InsuranceClaims/add-newclaim/add-newclaim.component';
import { GetplansBytypeComponent } from './components/InsurancePlans/getplans-bytype/getplans-bytype.component';
import { GetbyPatientnameComponent } from './components/Patients/getby-patientname/getby-patientname.component';
import { GetpatientforInvoiceComponent } from './components/Patients/getpatientfor-invoice/getpatientfor-invoice.component';
import { ViewclaimforCompanyComponent } from './components/InsuranceClaims/viewclaimfor-company/viewclaimfor-company.component';
import { GetclaimPatientnameComponent } from './components/Patients/getclaim-patientname/getclaim-patientname.component';
import { GetinvoicePatientnameComponent } from './components/InvoiceDetails/getinvoice-patientname/getinvoice-patientname.component';
import { GetinvoicepdfComponent } from './components/InvoiceDetails/getinvoicepdf/getinvoicepdf.component';
import { AddadminComponent } from './components/Admin/addadmin/addadmin.component';
import { GetplanbycompanynameComponent } from './components/InsurancePlans/getplanbycompanyname/getplanbycompanyname.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterPatientsComponent,
    UpdatePatientsComponent,
    GetAllPatientsComponent,
    RegisterCompanyComponent,
    UpdateCompanyComponent,
    GetAllCompaniesComponent,
    AddInsurancePlanComponent,
    GetAllInsurancePlansComponent,
    RegisterProviderComponent,
    UpdateProviderComponent,
    GetAllProvidersComponent,
    UpdateInsuranceClaimComponent,
    GetAllInsuranceClaimsComponent,
    GenerateInvoiceComponent,
    GetAllInvoicesComponent,
    HomepageComponent,
    AdmindashboardComponent,
      DashboardComponent,
      LoginAdminComponent,
      LoginPatientComponent,
      PatientDashboardComponent,
      PatientDashboardComponent,
      LoginProviderComponent,
      ProviderDashboardComponent,
      LoginCompanyComponent,
      AddNewclaimComponent,
      GetplansBytypeComponent,
      GetbyPatientnameComponent,
      GetpatientforInvoiceComponent,
      ViewclaimforCompanyComponent,
      GetclaimPatientnameComponent,
      GetinvoicePatientnameComponent,
      GetinvoicepdfComponent,
      AddadminComponent,
      GetplanbycompanynameComponent

  ],
  imports: [
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
