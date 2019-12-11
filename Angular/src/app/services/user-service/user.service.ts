import { Injectable } from '@angular/core';
import { User } from '../../datamodel/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url : string = "http://localhost:8080/rest/users/";
  
  constructor(private httpClient: HttpClient) { }

  getStudentList(searchText : string): Observable<User[]>{
    return this.httpClient.get(this.url + "?uName=" + searchText) as Observable<User[]>;
  }

  save(user: User): void {
    this.httpClient.post(this.url, user).subscribe((data) =>
    console.log(data)
    );
  }
}
