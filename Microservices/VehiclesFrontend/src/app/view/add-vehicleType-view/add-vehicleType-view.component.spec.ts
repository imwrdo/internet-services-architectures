import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddVehicleTypeViewComponent } from './add-vehicleType-view.component';

describe('AddVehicleTypeViewComponent', () => {
  let component: AddVehicleTypeViewComponent;
  let fixture: ComponentFixture<AddVehicleTypeViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddVehicleTypeViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(AddVehicleTypeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
