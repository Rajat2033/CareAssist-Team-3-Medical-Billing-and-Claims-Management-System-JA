import { TestBed } from '@angular/core/testing';

import { JwtCompanyService } from './jwt-company.service';

describe('JwtCompanyService', () => {
  let service: JwtCompanyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JwtCompanyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
