import { TestBed } from '@angular/core/testing';

import { CategoryService } from './category.service';

describe('VehicleTypeService', () => {
  let service: VehicleTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VehicleTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
