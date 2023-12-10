import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterPatientsComponent } from './components/Patients/register-patients/register-patients.component';
import { UpdatePatientsComponent } from './components/Patients/update-patients/update-patients.component';
import { RegisterCompanyComponent } from './components/InsuranceCompany/register-company/register-company.component';
import { UpdateCompanyComponent } from './components/InsuranceCompany/update-company/update-company.component';
import { AddInsurancePlanComponent } from './components/InsurancePlans/add-insurance-plan/add-insurance-plan.component';
import { RegisterProviderComponent } from './components/HealthcareProvider/register-provider/register-provider.component';
import { GetAllPatientsComponent } from './components/Patients/get-all-patients/get-all-patients.component';
import { GetAllCompaniesComponent } from './components/InsuranceCompany/get-all-companies/get-all-companies.component';
import { GetAllInsurancePlansComponent } from './components/InsurancePlans/get-all-insurance-plans/get-all-insurance-plans.component';
import { GenerateInvoiceComponent } from './components/InvoiceDetails/generate-invoice/generate-invoice.component';
import { GetAllInvoicesComponent } from './components/InvoiceDetails/get-all-invoices/get-all-invoices.component';
import { UpdateProviderComponent } from './components/HealthcareProvider/update-provider/update-provider.component';
import { GetAllProvidersComponent } from './components/HealthcareProvider/get-all-providers/get-all-providers.component';
import { GetAllInsuranceClaimsComponent } from './components/InsuranceClaims/get-all-insurance-claims/get-all-insurance-claims.component';
import { UpdateInsuranceClaimComponent } from './components/InsuranceClaims/update-insurance-claim/update-insurance-claim.component';
import { AdmindashboardComponent } from './components/Admin/admindashboard.component';
import { LoginAdminComponent } from './components/Admin/login-admin/login-admin.component';
import { ProviderDashboardComponent } from './components/HealthcareProvider/provider-dashboard/provider-dashboard.component';
import { HomepageComponent } from './components/Homepage/homepage.component';
import { LoginProviderComponent } from './components/HealthcareProvider/login-provider/login-provider.component';
import { LoginPatientComponent } from './components/Patients/login-patient/login-patient.component';
import { LoginCompanyComponent } from './components/InsuranceCompany/login-company/login-company.component';
import { DashboardComponent } from './components/InsuranceCompany/company-dashboard/dashboard.component';
import { PatientDashboardComponent } from './components/Patients/patient-dashboard/patient-dashboard.component';
import { AddNewclaimComponent } from './components/InsuranceClaims/add-newclaim/add-newclaim.component';
import { GetplansBytypeComponent } from './components/InsurancePlans/getplans-bytype/getplans-bytype.component';
import { GetbyPatientnameComponent } from './components/Patients/getby-patientname/getby-patientname.component';
import { GetpatientforInvoiceComponent } from './components/Patients/getpatientfor-invoice/getpatientfor-invoice.component';
import { GetclaimPatientnameComponent } from './components/Patients/getclaim-patientname/getclaim-patientname.component';
import { GetinvoicePatientnameComponent } from './components/InvoiceDetails/getinvoice-patientname/getinvoice-patientname.component';
import { ViewclaimforCompanyComponent } from './components/InsuranceClaims/viewclaimfor-company/viewclaimfor-company.component';
import { GetinvoicepdfComponent } from './components/InvoiceDetails/getinvoicepdf/getinvoicepdf.component';
import { AddadminComponent } from './components/Admin/addadmin/addadmin.component';
import { GetplanbycompanynameComponent } from './components/InsurancePlans/getplanbycompanyname/getplanbycompanyname.component';


const routes: Routes = [
  // { path: '', redirectTo: '/app', pathMatch: 'full' },
  { path: '', component: HomepageComponent },
  { path: 'login/admin', component: LoginAdminComponent },
  { path: 'login/provider', component: LoginProviderComponent },
  { path: 'login/patient', component: LoginPatientComponent },
  { path: 'login/company', component: LoginCompanyComponent },
  { path: 'registerpatient', component: RegisterPatientsComponent },
  { path: 'registercompany', component: RegisterCompanyComponent },
  { path: 'registerprovider', component: RegisterProviderComponent },

  { path: 'updatepatients/:id', component: UpdatePatientsComponent },


  { path: 'admin/dashboard', component: AdmindashboardComponent, children: [ {path:'addadmin',component:AddadminComponent},{ path: 'getallcompanies', component: GetAllCompaniesComponent }, { path: 'getallpatients', component: GetAllPatientsComponent }, { path: 'getallclaims', component: GetAllInsuranceClaimsComponent }, { path: 'getallproviders', component: GetAllProvidersComponent }, { path: 'getallplans', component: GetAllInsurancePlansComponent }, { path: 'getallinvoices', component: GetAllInvoicesComponent }] },
  { path: 'provider/dashboard', component: ProviderDashboardComponent, children: [{ path: 'update/provider', component: UpdateProviderComponent }, { path: "getpatients", component: GetpatientforInvoiceComponent }, { path: 'generateinvoice/:patientId', component: GenerateInvoiceComponent }, { path: 'get/patientname', component: GetbyPatientnameComponent }, { path: 'getallpatients', component: GetAllPatientsComponent }] },
  { path: 'company/dashboard', component: DashboardComponent, children: [{path:'getplan/companyname' ,component:GetplanbycompanynameComponent},{ path: 'update/:claimId', component: UpdateInsuranceClaimComponent }, { path: 'updatecompany', component: UpdateCompanyComponent }, { path: 'getclaim/:companyName', component: ViewclaimforCompanyComponent }, { path: 'add/plan/:companyName', component: AddInsurancePlanComponent },] },
  { path: 'patient/dashboard', component: PatientDashboardComponent, children: [{ path: 'getclaim/:patientName', component: GetclaimPatientnameComponent }, { path: 'getinvoice/:patientName', component: GetinvoicePatientnameComponent }, { path: 'update/patient', component: UpdatePatientsComponent }, { path: 'get/planbytype', component: GetplansBytypeComponent }, { path: 'add/newclaim', component: AddNewclaimComponent }] },

  { path: 'generateinvoice/:patientId', component: GenerateInvoiceComponent },
  { path: 'addclaim/:patientName/:planId', component: AddNewclaimComponent },
  { path: 'getpdf/:invoiceId', component: GetinvoicepdfComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
