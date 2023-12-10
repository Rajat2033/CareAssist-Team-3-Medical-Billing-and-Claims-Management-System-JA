import { TestBed } from '@angular/core/testing';

import { JwtProviderService } from './jwt-provider.service';

describe('JwtProviderService', () => {
  let service: JwtProviderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JwtProviderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
