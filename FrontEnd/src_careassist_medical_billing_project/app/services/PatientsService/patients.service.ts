import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, switchMap } from 'rxjs';
import { Patients } from 'src/app/model/Patients';
import { JwtPatientService } from './jwt-patient.service';
import { JwtAdminService } from '../AdminService/jwt-admin.service';
import { JwtProviderService } from '../HealthcareProviderService/jwt-provider.service';
import { InsuranceClaims } from 'src/app/model/InsuranceClaims';
import { JwtCompanyService } from '../InsuranceCompanyService/jwt-company.service';

@Injectable({
  providedIn: 'root'
})
export class PatientsService {

  patientId!: number;
  patientName!: string;

  private patientNameKey = 'patientName';

  patientURL: string = 'http://localhost:8080/api/v1/patients';

  constructor(private http: HttpClient, private jwtPatient: JwtPatientService, private jwtAdmin: JwtAdminService, private jwtProvider: JwtProviderService, private jwtCompany: JwtCompanyService) { }


  registerPatients(patients: Patients): Observable<Patients> {
    return this.http.post<Patients>(this.patientURL + "/add/new", patients);
  }






  getAllPatients(): Observable<Patients[]> {
    const token = this.jwtAdmin.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);


      console.log(headers);
      return this.http.get<Patients[]>(this.patientURL + '/get/allPatients', { headers });
    }
    else {
      return new Observable<Patients[]>;
    }
  }






  getPatientforInvoice(): Observable<Patients[]> {
    const token = this.jwtProvider.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);


      console.log(headers);
      return this.http.get<Patients[]>(this.patientURL + '/getpatients', { headers });
    }
    else {
      return new Observable<Patients[]>;
    }
  }






  deletePatientById(patientId: number): Observable<string> {
    const token = this.jwtAdmin.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);
      return this.http.delete<string>(this.patientURL + `/delete/patient/${patientId}`, { headers,responseType:'text' as 'json'})
    }
    else {
      return new Observable<string>();
    }
  }






  getPatientByName(patientName: string): Observable<Patients> {
    const token = this.jwtProvider.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);


      return this.http.get<Patients>(this.patientURL + `/getbyname/${patientName}`, { headers });
    }
    else {
      return new Observable<Patients>;
    }
  }






  getPatientForCompanyByName(patientName: string): Observable<Patients> {
    const token = this.jwtCompany.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);


      return this.http.get<Patients>(this.patientURL + `/getbypatientname/${patientName}`, { headers });
    }
    else {
      return new Observable<Patients>;
    }
  }






  updatePatient(patient: Patients): Observable<Patients> {
    const token = this.jwtPatient.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);


      console.log(headers);
      return this.http.put<Patients>(this.patientURL + '/update/patient/' + patient.patientId, patient, { headers });
    }
    else {
      return new Observable<Patients>;
    }
  }



  setPatientInfo(name: string) {

    this.patientName = name;

  }

  getPatientName() {
    return this.patientName;
  }
}





