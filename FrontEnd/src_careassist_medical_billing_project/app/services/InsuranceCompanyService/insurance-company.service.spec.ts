import { TestBed } from '@angular/core/testing';

import { InsuranceCompanyService } from './insurance-company.service';

describe('InsuranceCompanyService', () => {
  let service: InsuranceCompanyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InsuranceCompanyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
