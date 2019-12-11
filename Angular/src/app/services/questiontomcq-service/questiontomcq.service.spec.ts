import { TestBed } from '@angular/core/testing';

import { QuestiontomcqService } from './questiontomcq.service';

describe('QuestiontomcqService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: QuestiontomcqService = TestBed.get(QuestiontomcqService);
    expect(service).toBeTruthy();
  });
});
