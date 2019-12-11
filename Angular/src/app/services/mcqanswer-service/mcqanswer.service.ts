import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MCQAnswer } from '../../datamodel/mcqanswer';

@Injectable({
  providedIn: 'root'
})
export class MCQAnswerService {

  url : string = "http://localhost:8080/rest/mcqanswer";
  
  constructor(private httpClient: HttpClient) { }

  //all a particular student's answers??
  getAnswerList(searchText : string): Observable<MCQAnswer[]>{
    return this.httpClient.get(this.url + "?aContent=" + searchText) as Observable<MCQAnswer[]>;
  }

  save(answer: MCQAnswer): void {
    this.httpClient.post(this.url, answer);
  }

  
}
