import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewclaimforCompanyComponent } from './viewclaimfor-company.component';

describe('ViewclaimforCompanyComponent', () => {
  let component: ViewclaimforCompanyComponent;
  let fixture: ComponentFixture<ViewclaimforCompanyComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewclaimforCompanyComponent]
    });
    fixture = TestBed.createComponent(ViewclaimforCompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
