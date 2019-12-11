import { Injectable } from '@angular/core';
import { Exam } from '../../datamodel/exams';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExamService {

  url : string = "http://localhost:8080/rest/exams";
  
  constructor(private httpClient: HttpClient) { }

  getExamList(searchText : string): Observable<Exam[]>{
    return this.httpClient.get(this.url + "?eTitle=" + searchText) as Observable<Exam[]>;
  }

  save(exam: Exam): void {
    this.httpClient.post(this.url, exam);
  }

}
