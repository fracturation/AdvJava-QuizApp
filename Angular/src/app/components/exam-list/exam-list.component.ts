import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Exam } from '../../datamodel/exams'
import { ExamService } from '../../services/exam-services/exam.service'

@Component({
  selector: 'app-exam-list',
  templateUrl: './exam-list.component.html',
  styleUrls: ['./exam-list.component.css']
})
export class ExamListComponent implements OnInit {

  examList : Exam[];

  searchText : string;

  //to the exam display
  @Output()
  private ex: EventEmitter<Exam> = new EventEmitter<Exam>();

  constructor(private examService: ExamService) { }

  ngOnInit() {
  }

  search() : void {
    this.examService.getExamList(this.searchText).subscribe((data) => {
      
      this.examList = data;
      console.log(this.examList);
  });
  }

  addToMCQAnswer(exam: Exam) : void {
    this.ex.emit(exam);
  }

}
