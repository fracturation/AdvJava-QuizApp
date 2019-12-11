  
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ExamDisplayComponent } from './components/exam-display/exam-display.component';
import { ExamListComponent } from './components/exam-list/exam-list.component';
import { ExamFormComponent } from './components/exam-form/exam-form.component';
import { UserFormComponent } from './components/user-form/user-form.component'
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './auxilliary/auth.guard';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'sign-up', component: UserFormComponent },
  { path: 'create-exam', component: ExamFormComponent, /* canActivate: [AuthGuard], */ data: {isAdmin: true} },
  { path: 'examination-center', component: ExamListComponent, canActivate: [AuthGuard] },
  { path: 'exam', component: ExamDisplayComponent, canActivate: [AuthGuard] },
  { path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }