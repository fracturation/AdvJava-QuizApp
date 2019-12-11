import { Component, OnInit, Input } from '@angular/core';
import { MCQChoice } from '../../datamodel/mcqchoice';
import { MCQChoiceService } from '../../services/mcqchoice-service/mcqchoice.service'
import { Question } from '../../datamodel/questions';

@Component({
  selector: 'app-mcqchoice-form',
  templateUrl: './mcqchoice-form.component.html',
  styleUrls: ['./mcqchoice-form.component.css']
})
export class MCQChoiceFormComponent implements OnInit {

  //from the question form
  @Input()
  private quFromParent : Question;

  public choicesList : MCQChoice[] = [];

  public choice : MCQChoice = new MCQChoice('', this.quFromParent);

  constructor(private mcqChoiceService : MCQChoiceService ) { }

  ngOnInit() {
  }

  onSelection(entry): void {
    this.choice.valid = entry;
  }

  // delete(choice: MCQChoice) : void {
  //   var index = this.choicesList.indexOf(choice);
  //   this.choicesList.splice(index, 1);
  //   }

  save() : void {
    this.choice.question = this.quFromParent;
    this.mcqChoiceService.save(this.choice);
    this.choicesList.push(this.choice);
    this.choice = new MCQChoice('', this.quFromParent);
  }

}
