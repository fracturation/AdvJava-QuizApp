import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MCQChoice } from '../../datamodel/mcqchoice';

@Injectable({
  providedIn: 'root'
})
export class MCQChoiceService {

  url : string = "http://localhost:8080/rest/mcqchoice";
  
  constructor(private httpClient: HttpClient) { }

  getChoiceList(searchText : string): Observable<MCQChoice[]>{
    return this.httpClient.get(this.url + "?cContent=" + searchText) as Observable<MCQChoice[]>;
  }

  save(choice: MCQChoice): void {
    this.httpClient.post(this.url, choice);
  }
}
