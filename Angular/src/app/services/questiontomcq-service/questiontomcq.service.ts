import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Question } from '../../datamodel/questions'
import { MCQChoice } from '../../datamodel/mcqchoice'

@Injectable({
  providedIn: 'root'
})
export class QuestionToMCQService {

  url : string = "http://localhost:8080/rest/q2mcq";

  constructor(private httpClient: HttpClient) { }

  getChoiceListFromQuestion(question: Question): Observable<MCQChoice[]>{
    return this.httpClient.get(this.url) as Observable<MCQChoice[]>;
  }
}
