import { Question } from "./questions";

export class MCQChoice {
    choice : string;

    valid : boolean = false;

    question : Question;

    constructor(choice : string, question : Question) {
        this.choice = choice;
        this.question = question;
    }
}