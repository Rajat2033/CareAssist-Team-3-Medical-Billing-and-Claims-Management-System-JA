import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllProvidersComponent } from './get-all-providers.component';

describe('GetAllProvidersComponent', () => {
  let component: GetAllProvidersComponent;
  let fixture: ComponentFixture<GetAllProvidersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetAllProvidersComponent]
    });
    fixture = TestBed.createComponent(GetAllProvidersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
