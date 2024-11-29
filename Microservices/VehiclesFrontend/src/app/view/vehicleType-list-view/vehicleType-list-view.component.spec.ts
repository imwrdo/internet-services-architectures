import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleTypeListViewComponent } from './vehicleType-list-view.component';

describe('VehicleTypeListViewComponent', () => {
  let component: VehicleTypeListViewComponent;
  let fixture: ComponentFixture<VehicleTypeListViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VehicleTypeListViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(VehicleTypeListViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
