import { TestBed } from '@angular/core/testing';

import { HealthcareProviderService } from './healthcare-provider.service';

describe('HealthcareProviderService', () => {
  let service: HealthcareProviderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HealthcareProviderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
