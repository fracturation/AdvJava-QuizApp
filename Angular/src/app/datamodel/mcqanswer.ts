import { User } from "./user";
import { Exam } from "./exams";
import { MCQChoice } from "./mcqchoice";

export class MCQAnswer {
    user : User;

    exam : Exam;

    choice : MCQChoice;

    constructor(user : User, exam : Exam, choice : MCQChoice) {
        this.user = user;
        this.exam = exam;
        this.choice = choice;
    }
}