import { Routes } from '@angular/router';
import { VehicleTypeListViewComponent } from './view/vehicleType-list-view/vehicleType-list-view.component';
import { AddVehicleTypeViewComponent } from './view/add-vehicleType-view/add-vehicleType-view.component';
import { EditVehicleTypeViewComponent } from './view/edit-vehicleType-view/edit-vehicleType-view.component';
import { VehicleTypeDetailsViewComponent } from './view/vehicleType-details-view/vehicleType-details-view.component';
import { VehicleDetailsViewComponent } from './view/vehicle-details-view/vehicle-details-view.component';
import { AddVehicleViewComponent } from './view/add-vehicle-view/add-vehicle-view.component';
import { EditVehicleViewComponent } from './view/edit-vehicle-view/edit-vehicle-view.component';


export const routes: Routes = [
  {
      component: VehicleTypeListViewComponent,
      path: 'vehicleTypes',
    },
    {
      component: AddVehicleTypeViewComponent,
      path: 'vehicleTypes/new',
    },
    {
      component: VehicleTypeDetailsViewComponent,
      path: 'vehicleTypes/:id',
    },
    {
      component: EditVehicleTypeViewComponent,
      path: 'vehicleTypes/:id/edit',
    },
    {
      component: AddVehicleViewComponent,
      path: 'vehicleTypes/:vehicleTypeId/vehicles/new',
    },
    {
      component: VehicleDetailsViewComponent,
      path: 'vehicleTypes/:vehicleTypeId/vehicles/:vehicleId',
    },
    {
      component: EditVehicleViewComponent,
      path: 'vehicleTypes/:vehicleTypeId/vehicles/:vehicleId/edit',
    },
    {
      component: VehicleTypeListViewComponent,
      path: '**',
    },
];
