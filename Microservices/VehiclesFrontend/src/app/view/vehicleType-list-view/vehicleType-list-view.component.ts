import { Component, OnInit } from '@angular/core';
import { VehicleTypeService } from '../../api/vehicleTypes/service/vehicleType.service';
import { VehicleTypes } from '../../api/vehicleTypes/model/vehicleTypes';
import { MatListModule } from '@angular/material/list';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { ViewTitleComponent } from '../../component/view-title/view-title.component';

@Component({
  selector: 'app-vehicleType-list-view',
  standalone: true,
  imports: [
    MatListModule,
    MatDividerModule,
    MatButtonModule,
    RouterLink,
    MatIconModule,
    ViewTitleComponent,
  ],
  templateUrl: './vehicleType-list-view.component.html',
  styleUrl: './vehicleType-list-view.component.css',
})
export class VehicleTypeListViewComponent implements OnInit {
  constructor(private vehicleTypeService: VehicleTypeService) {}

  vehicleTypes: VehicleTypes | undefined;

  ngOnInit(): void {
    this.fetchVehicleTypes();
  }

  fetchVehicleTypes(): void {
    this.vehicleTypeService.getAllVehicleTypes().subscribe((vehicleTypes) => {
      this.vehicleTypes = vehicleTypes;
    });
  }

  deleteVehicleType(id: string): void {
    this.vehicleTypeService.deleteVehicleType(id).subscribe(() => {
      this.fetchVehicleTypes();
    });
  }
}
