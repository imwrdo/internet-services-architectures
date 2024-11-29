import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleTypeDetailsViewComponent } from './vehicleType-details-view.component';

describe('VehicleTypeDetailsViewComponent', () => {
  let component: VehicleTypeDetailsViewComponent;
  let fixture: ComponentFixture<VehicleTypeDetailsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VehicleTypeDetailsViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(VehicleTypeDetailsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
