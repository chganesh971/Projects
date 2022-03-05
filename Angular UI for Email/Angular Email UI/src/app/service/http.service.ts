import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  _URL:string = "http://localhost:8082/email/post/";

  constructor(private http:HttpClient) {
  }


  sendEmail(content:string):Observable<string> {
    return this.http.get<string>(this._URL+content);
  }


}
