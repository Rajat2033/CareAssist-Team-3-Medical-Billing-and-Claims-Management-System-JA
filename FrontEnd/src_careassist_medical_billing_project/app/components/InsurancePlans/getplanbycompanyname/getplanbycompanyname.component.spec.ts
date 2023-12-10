import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetplanbycompanynameComponent } from './getplanbycompanyname.component';

describe('GetplanbycompanynameComponent', () => {
  let component: GetplanbycompanynameComponent;
  let fixture: ComponentFixture<GetplanbycompanynameComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetplanbycompanynameComponent]
    });
    fixture = TestBed.createComponent(GetplanbycompanynameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
