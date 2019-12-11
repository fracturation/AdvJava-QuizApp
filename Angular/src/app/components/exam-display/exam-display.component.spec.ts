import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamDisplayComponent } from './exam-display.component';

describe('ExamDisplayComponent', () => {
  let component: ExamDisplayComponent;
  let fixture: ComponentFixture<ExamDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamDisplayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
