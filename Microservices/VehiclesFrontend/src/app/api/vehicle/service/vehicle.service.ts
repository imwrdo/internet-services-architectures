import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Vehicles } from '../model/vehicles';
import { Observable } from 'rxjs';
import { Vehicle } from '../model/vehicle';

@Injectable({
  providedIn: 'root',
})
export class VehicleService {
  constructor(private httpClient: HttpClient) {}

  getAllVehicles(): Observable<Vehicles> {
    return this.httpClient.get<Vehicles>('/api/vehicles');
  }

  getVehicleById(id: string): Observable<Vehicle> {
    return this.httpClient.get<Vehicle>(`/api/vehicles/${id}`);
  }

  getVehiclesByVehicleTypeId(vehicleTypeId: string): Observable<Vehicles> {
    return this.httpClient.get<Vehicles>(
      `/api/vehicleTypes/${vehicleTypeId}/vehicles`,
    );
  }

  createVehicle(vehicle: Vehicle, vehicleTypeId: string): Observable<Vehicle> {
    return this.httpClient.post<Vehicle>(
      `/api/vehicleTypes/${vehicleTypeId}/vehicles`,
      vehicle,
    );
  }

  updateVehicle(vehicle: Vehicle): Observable<Vehicle> {
    return this.httpClient.patch<Vehicle>(
      `/api/vehicles/${vehicle.id}`,
      vehicle,
    );
  }

  deleteVehicle(id: string): Observable<void> {
    return this.httpClient.delete<void>(`/api/vehicles/${id}`);
  }
}
