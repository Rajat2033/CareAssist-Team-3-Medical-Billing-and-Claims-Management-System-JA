import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetbyPatientnameComponent } from './getby-patientname.component';

describe('GetbyPatientnameComponent', () => {
  let component: GetbyPatientnameComponent;
  let fixture: ComponentFixture<GetbyPatientnameComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetbyPatientnameComponent]
    });
    fixture = TestBed.createComponent(GetbyPatientnameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
