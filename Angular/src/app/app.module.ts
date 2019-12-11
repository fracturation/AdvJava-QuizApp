import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { FilterPipe }from './auxilliary/filter.pipe';
import { AppComponent } from './app.component';

import { QuestionFormComponent } from './components/question-form/question-form.component';
import { QuestionListComponent } from './components/question-list/question-list.component';
import { ExamFormComponent } from './components/exam-form/exam-form.component';
import { ExamListComponent } from './components/exam-list/exam-list.component';
import { MCQChoiceFormComponent } from './components/mcqchoice-form/mcqchoice-form.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { ExamDisplayComponent } from './components/exam-display/exam-display.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    QuestionFormComponent,
    QuestionListComponent,
    FilterPipe,
    ExamFormComponent,
    ExamListComponent,
    MCQChoiceFormComponent,
    UserFormComponent,
    ExamDisplayComponent,
    LoginComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
