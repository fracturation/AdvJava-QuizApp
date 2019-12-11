import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Question } from '../../datamodel/questions';
import { QuestionService } from '../../services/question-service/question.service';

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.css']
})
export class QuestionListComponent implements OnInit {

  questionList : Question[];
  searchText : string;
  
  //to the exam form
  @Output()
  private qu: EventEmitter<Question> = new EventEmitter<Question>();

  constructor(private questionService : QuestionService) { }

  ngOnInit() {
    this.search();
  }

  // delete(question: Question) : void {
  //   this.questionService.delete(question);
  // }

  search() : void {
    this.questionService.getQuestionList(this.searchText).subscribe((data) => {
      
      this.questionList = data;
      console.log(this.questionList);
  });
  }

  addToExam(question: Question) : void {
    this.qu.emit(question);
    var index = this.questionList.indexOf(question);
    this.questionList.splice(index, 1);
  }

}
