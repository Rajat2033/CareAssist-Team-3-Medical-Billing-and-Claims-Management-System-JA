import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, pipe, throwError } from 'rxjs';
import { InsuranceClaims } from 'src/app/model/InsuranceClaims';
import { JwtAdminService } from '../AdminService/jwt-admin.service';
import { PatientsService } from '../PatientsService/patients.service';
import { JwtPatientService } from '../PatientsService/jwt-patient.service';
import { JwtCompanyService } from '../InsuranceCompanyService/jwt-company.service';

@Injectable({
  providedIn: 'root'
})
export class InsuranceClaimsService {

  adminURL: string = "http://localhost:8080/api/v1/admin";
  claimURL: string = "http://localhost:8080/api/v1/insuranceclaims";
  companyURL: string = 'http://localhost:8080/api/v1/companies';
  constructor(private http: HttpClient, private jwtAdmin: JwtAdminService, private jwtPatient: JwtPatientService,private jwtCompany:JwtCompanyService) { }




  getAllInsuranceClaims(): Observable<InsuranceClaims[]> {
    const token = this.jwtAdmin.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);


      console.log(headers);
      return this.http.get<InsuranceClaims[]>(this.adminURL + '/getallinsuranceclaims', { headers });
    }
    else {
      return new Observable<InsuranceClaims[]>;
    }
  }






  addClaim(claim: InsuranceClaims, patientName: string, planId: number): Observable<InsuranceClaims> {
    const token = this.jwtPatient.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);

      return this.http.post<InsuranceClaims>(this.claimURL + `/add/newclaim/${patientName}/${planId}`, claim, { headers })
        .pipe(
          catchError((error: any) => {
            console.error('Error adding claim:', error);
            return throwError(error); // Re-throw the error to be handled by the caller
          })
        );
    } else {
      // If the token is not available, emit an error
      return throwError('Token not available');
    }
  }






  getClaimForPatient(patientName: string): Observable<InsuranceClaims[]> {
    const token = this.jwtPatient.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);


      console.log(headers);
      return this.http.get<InsuranceClaims[]>(this.claimURL + `/getclaim/${patientName}`, { headers })
        .pipe(
          catchError((error: any) => {
            console.error('Error adding claim:', error);
            return throwError(error); // Re-throw the error to be handled by the caller
          })
        );
    } else {
      // If the token is not available, emit an error
      return throwError('Token not available');
    }

  }





  updateClaimStatus(insuranceClaims:InsuranceClaims,claimId:number):Observable<InsuranceClaims>
  {
    const token = this.jwtCompany.getToken();
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);
      console.log(headers);
      return this.http.put<InsuranceClaims>(this.claimURL + `/update/claim/${claimId}`,insuranceClaims, { headers })
        .pipe(
          catchError((error: any) => {
            console.error('Error Updating claim:', error);
            return throwError(error); 
          })
        );
    } else {
      return throwError('Token not available');
    }
  }






}
