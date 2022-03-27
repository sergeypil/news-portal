import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

export interface AuthRequest {
  username: string;
  password: string
}


@Injectable()
export class AuthService {

  constructor(private httpClient: HttpClient) { }



  login(request: AuthRequest) {
    return this.httpClient.post("http://localhost:8080/news_portal_war/apiauth/login", request);
  }


}
