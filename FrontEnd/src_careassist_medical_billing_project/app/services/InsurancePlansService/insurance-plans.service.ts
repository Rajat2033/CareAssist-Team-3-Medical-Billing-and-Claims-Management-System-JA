import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { InsurancePlans } from 'src/app/model/InsurancePlans';
import { JwtAdminService } from '../AdminService/jwt-admin.service';
import { JwtPatientService } from '../PatientsService/jwt-patient.service';
import { JwtCompanyService } from '../InsuranceCompanyService/jwt-company.service';

@Injectable({
  providedIn: 'root'
})
export class InsurancePlansService {
  searchPlansByType(searchTerm: any) {
    throw new Error('Method not implemented.');
  }

  adminURL: string = 'http://localhost:8080/api/v1/admin';

  plansURL: string = 'http://localhost:8080/api/v1/insuranceplans';
  constructor(private http: HttpClient, private jwtAdmin: JwtAdminService, private jwtPatient: JwtPatientService, private jwtCompany: JwtCompanyService) { }





  getAllInsurancePlans(): Observable<InsurancePlans[]> {
    const token = this.jwtAdmin.getToken();
    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);
      return this.http.get<InsurancePlans[]>(this.adminURL + '/getallinsuranceplans', { headers });
    }
    else {
      return new Observable<InsurancePlans[]>;
    }
  }






  searchPlans(planType: string): Observable<InsurancePlans[]> {
    const token = this.jwtPatient.getToken();
    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);
      return this.http.get<InsurancePlans[]>(this.plansURL + `/getplanbytype/${planType}`, { headers });
    }
    else {
      return new Observable<InsurancePlans[]>;
    }
  }







  insertPlan(plans: InsurancePlans,companyName:string): Observable<InsurancePlans> {
    const token = this.jwtPatient.getToken();
    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);
      return this.http.post<InsurancePlans>(this.plansURL + `/add/plan/${companyName}`, plans, { headers })
        .pipe(
          catchError((error: any) => {
            console.error('Error adding plan:', error);
            return throwError(error); // Re-throw the error to be handled by the caller
          })
        );
    } else {
      // If the token is not available, emit an error
      return throwError('Token not available');
    }
  }


  // getPlanByCompanyName(companyName:string):Observable<InsurancePlans[]>
  // {
  //   const token = this.jwtCompany.getToken();
  //   console.log(token);
  //   if (token) {
  //     const tokenString = 'Bearer ' + token;
  //     const headers = new HttpHeaders().set('Authorization', tokenString);
  //     return this.http.get<InsurancePlans[]>(this.plansURL + `/getallplansbycompanyname/${companyName}`, { headers })
  //       .pipe(
  //         catchError((error: any) => {
  //           console.error('Error adding plan:', error);
  //           return throwError(error); // Re-throw the error to be handled by the caller
  //         })
  //       );
  //   } else {
  //     // If the token is not available, emit an error
  //     return throwError('Token not available');
  //   }
  // }


 




  
}
