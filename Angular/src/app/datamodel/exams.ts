import { Question } from "./questions";

export class Exam {
    title : string;

    questions : Question[] = [];

    constructor(title : string) {
        this.title = title;
    }
}