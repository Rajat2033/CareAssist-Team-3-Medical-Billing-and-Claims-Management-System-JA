import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetclaimPatientnameComponent } from './getclaim-patientname.component';

describe('GetclaimPatientnameComponent', () => {
  let component: GetclaimPatientnameComponent;
  let fixture: ComponentFixture<GetclaimPatientnameComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetclaimPatientnameComponent]
    });
    fixture = TestBed.createComponent(GetclaimPatientnameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
