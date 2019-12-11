import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Question } from '../../datamodel/questions';
import { QuestionService } from '../../services/question-service/question.service';


@Component({
  selector: 'app-question-form',
  templateUrl: './question-form.component.html',
  styleUrls: ['./question-form.component.css']
})
export class QuestionFormComponent implements OnInit {

  //to the exam form
  @Output()
  private qu: EventEmitter<Question> = new EventEmitter<Question>();

  public question: Question = new Question('');

  public isQuSaved: boolean = false;

  constructor(private questionService : QuestionService) { }

  ngOnInit() {
  }

  save() : void {
    this.questionService.save(this.question);
    this.isQuSaved = true;
  }

  addToExam() : void {
    this.qu.emit(this.question); //to exam
    this.question = new Question('');
    this.isQuSaved = false;
  }

}
