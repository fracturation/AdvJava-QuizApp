import { TestBed } from '@angular/core/testing';

import { McqanswerService } from './mcqanswer.service';

describe('McqanswerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: McqanswerService = TestBed.get(McqanswerService);
    expect(service).toBeTruthy();
  });
});
