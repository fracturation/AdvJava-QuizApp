import { Component, OnInit, Input } from '@angular/core';
import { Exam } from '../../datamodel/exams'
import { ExamService } from '../../services/exam-services/exam.service';
import { Question } from '../../datamodel/questions';

@Component({
  selector: 'app-exam-form',
  templateUrl: './exam-form.component.html',
  styleUrls: ['./exam-form.component.css']
})
export class ExamFormComponent implements OnInit {

  //from question-list component
  // @Input()
  private qu: Question;

  public exam: Exam = new Exam('');
  public isSaved: boolean = false;

  constructor(private examService: ExamService) { }

  ngOnInit() {
  }

  save() : void {
    this.isSaved = true;
  }

  addQuestion(): void {
    this.exam.questions.push(this.qu);
  }

  questionEventHandler($event): void {
    this.qu = $event;
    this.addQuestion();
  }

  onSubmit(): void {
    this.examService.save(this.exam);
    this.isSaved = false;
    this.exam = new Exam('');
  }

}
