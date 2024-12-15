import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { VehicleTypes } from '../model/vehicleTypes';
import { VehicleType } from '../model/vehicleType';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class VehicleTypeService {
  constructor(private httpClient: HttpClient) {}

  getAllVehicleTypes(): Observable<VehicleTypes> {
    return this.httpClient.get<VehicleTypes>('/api/vehicleTypes');
  }

  getVehicleTypeById(id: string): Observable<VehicleType> {
    return this.httpClient.get<VehicleType>(`/api/vehicleTypes/${id}`);
  }

  createVehicleType(vehicleType: VehicleType): Observable<VehicleType> {
    return this.httpClient.put<VehicleType>('/api/vehicleTypes', vehicleType);
  }

  updateVehicleType(vehicleType: VehicleType): Observable<VehicleType> {
    return this.httpClient.patch<VehicleType>(
      `/api/vehicleTypes/${vehicleType.id}`,
       vehicleType,
    );
  }

  deleteVehicleType(id: string): Observable<void> {
    return this.httpClient.delete<void>(`/api/vehicleTypes/${id}`);
  }
}
