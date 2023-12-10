import { TestBed } from '@angular/core/testing';

import { JwtPatientService } from './jwt-patient.service';

describe('JwtPatientService', () => {
  let service: JwtPatientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JwtPatientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
