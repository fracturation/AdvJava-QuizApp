import { Component, OnInit, Input } from '@angular/core';
import { User } from '../../datamodel/user';
import { Exam } from '../../datamodel/exams';
import { MCQAnswer } from '../../datamodel/mcqanswer';
import { Question } from '../../datamodel/questions';
import { QuestionToMCQService } from '../../services/questiontomcq-service/questiontomcq.service';
import { MCQChoice } from '../../datamodel/mcqchoice';
import { MCQAnswerService } from '../../services/mcqanswer-service/mcqanswer.service';
import { AuthService } from '../../services/auth-service/auth.service';

@Component({
  selector: 'app-exam-display',
  templateUrl: './exam-display.component.html',
  styleUrls: ['./exam-display.component.css']
})
export class ExamDisplayComponent implements OnInit {

  private user: User;

  @Input() //may ned to get rid of
  private exam: Exam;

  public questions: Question[];

  public choices: MCQChoice[];

  public answers: MCQChoice[];

  public isSubmitted: boolean = false;

  constructor(private questionToMCQService: QuestionToMCQService, private mcqAnswerService: MCQAnswerService, private authService: AuthService) { }

  ngOnInit() {
    this.getQuestions();
    this.setUser();
  }

  getQuestions() {
    this.questions = this.exam.questions
  }

  setUser() {
    this.user = this.authService.currentUserValue;
  }

  getMCQChoices(question: Question) {
    this.questionToMCQService.getChoiceListFromQuestion(question).subscribe((data) => {
      
      this.choices = data;
      console.log(this.choices);
  });
  }

  addAnswer($event, choice: MCQChoice) {
    if($event.checked()){
      this.answers.push(choice);
    } else {
      var index = this.choices.indexOf(choice);
      this.choices.splice(index, 1);
    }
  }

  saveAnswers() {
    this.choices.forEach(choice => {
      this.isSubmitted = true;
      var answer = new MCQAnswer(this.user, this.exam, choice);
      this.mcqAnswerService.save(answer);
    });
  }

  routeHome() {
    
  }

}
