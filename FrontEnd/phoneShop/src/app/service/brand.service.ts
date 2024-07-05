import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const baseUrl = "http://localhost:8080/brands?_limit=42&_page=1"; // Ensure correct URL with protocol

@Injectable({
  providedIn: 'root'
})
export class BrandService {
  constructor(private http : HttpClient) {}

  saveBrand(brand: any):Observable <any>{
     return this.http.post(baseUrl,brand); // Return the observable
  }
  getBrands(){
    return this.http.get<any>(baseUrl);
  }
}
