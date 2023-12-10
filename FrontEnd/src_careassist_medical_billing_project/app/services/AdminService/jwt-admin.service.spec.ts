import { TestBed } from '@angular/core/testing';

import { JwtAdminService } from './jwt-admin.service';

describe('JwtAdminService', () => {
  let service: JwtAdminService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JwtAdminService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
