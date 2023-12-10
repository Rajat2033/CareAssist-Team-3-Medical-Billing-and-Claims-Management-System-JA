import { TestBed } from '@angular/core/testing';

import { InsuranceClaimsService } from './insurance-claims.service';

describe('InsuranceClaimsService', () => {
  let service: InsuranceClaimsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InsuranceClaimsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
