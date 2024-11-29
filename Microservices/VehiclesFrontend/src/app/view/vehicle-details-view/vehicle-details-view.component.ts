import { Component, OnInit } from '@angular/core';
import { VehicleService } from '../../api/vehicle/service/vehicle.service';
import { Vehicle } from '../../api/vehicle/model/vehicle';
import { ActivatedRoute } from '@angular/router';
import { VehicleType } from '../../api/vehicleTypes/model/vehicleType';
import { VehicleTypeService } from '../../api/vehicleTypes/service/vehicleType.service';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { MatCardModule } from '@angular/material/card';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';

@Component({
  selector: 'app-vehicle-details-view',
  standalone: true,
  imports: [
    ViewTitleComponent,
    MatCardModule,
    RouterLink,
    MatButtonModule,
    ErrorMessageComponent,
  ],
  templateUrl: './vehicle-details-view.component.html',
  styleUrl: './vehicle-details-view.component.css',
})
export class VehicleDetailsViewComponent implements OnInit {
  constructor(
    private vehicleService: VehicleService,
    private vehicleTypeService: VehicleTypeService,
    private route: ActivatedRoute
  ) {}

  message: string = '';
  vehicleType: VehicleType | undefined;
  vehicle: Vehicle | undefined;

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.vehicleService.getVehicleById(params['vehicleId']).subscribe({
        next: (vehicle) => {
          this.vehicle = vehicle;
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
      this.vehicleTypeService.getVehicleTypeById(params['vehicleTypeId']).subscribe({
        next: (vehicleType) => {
          this.vehicleType = vehicleType;
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
    });
  }
}
