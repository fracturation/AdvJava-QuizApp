import { Injectable } from '@angular/core';
import { Question } from '../../datamodel/questions';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MCQChoice } from '../../datamodel/mcqchoice';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  url : string = "http://localhost:8080/rest/questions";
  
  constructor(private httpClient: HttpClient) { }

  getQuestionList(searchText : string): Observable<Question[]>{
    return this.httpClient.get(this.url + "?qContent=" + searchText) as Observable<Question[]>;
  }

  save(question: Question): void {
    this.httpClient.post(this.url, question);
  }

  // delete(question: Question): void{
  //   var index = this.questionList.indexOf(question);
  //   this.questionList.splice(index, 1);
  // }
}
