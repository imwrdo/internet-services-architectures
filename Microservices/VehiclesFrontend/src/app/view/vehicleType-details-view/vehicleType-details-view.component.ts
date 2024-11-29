import { Component, OnInit } from '@angular/core';
import { VehicleTypeService } from '../../api/vehicleTypes/service/vehicleType.service';
import { VehicleType } from '../../api/vehicleTypes/model/vehicleType';
import { ActivatedRoute } from '@angular/router';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { RouterLink } from '@angular/router';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { Vehicles } from '../../api/vehicle/model/vehicles';
import { VehicleService } from '../../api/vehicle/service/vehicle.service';
import { ErrorMessageComponent } from '../../component/error-message/error-message.component';

@Component({
  selector: 'app-vehicleType-details-view',
  standalone: true,
  imports: [
    ViewTitleComponent,
    MatCardModule,
    MatButtonModule,
    RouterLink,
    MatListModule,
    MatIconModule,
    ErrorMessageComponent,
  ],
  templateUrl: './vehicleType-details-view.component.html',
  styleUrl: './vehicleType-details-view.component.css',
})
export class VehicleTypeDetailsViewComponent implements OnInit {
  constructor(
    private vehicleTypeService: VehicleTypeService,
    private vehicleService: VehicleService,
    private route: ActivatedRoute
  ) {}

  message: string = '';
  vehicleType: VehicleType | undefined;
  vehicles: Vehicles | undefined;

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.vehicleTypeService.getVehicleTypeById(params['id']).subscribe({
        next: (vehicleType: VehicleType) => {
          this.vehicleType = vehicleType;
          this.fetchVehicles();
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
    });
  }

  fetchVehicles(): void {
    if (this.vehicleType) {
      this.vehicleService.getVehiclesByVehicleTypeId(this.vehicleType.id).subscribe({
        next: (vehicles: Vehicles) => {
          this.vehicles = vehicles;
        },
        error: (error) => {
          this.message = error.error.message;
        },
      });
    }
  }

  deleteVehicle(id: string): void {
    this.vehicleService.deleteVehicle(id).subscribe(() => {
      this.fetchVehicles();
    });
  }
}
