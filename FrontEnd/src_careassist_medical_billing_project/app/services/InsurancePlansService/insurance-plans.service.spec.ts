import { TestBed } from '@angular/core/testing';

import { InsurancePlansService } from './insurance-plans.service';

describe('InsurancePlansService', () => {
  let service: InsurancePlansService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InsurancePlansService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
