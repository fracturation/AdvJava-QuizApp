import { TestBed } from '@angular/core/testing';

import { McqchoiceService } from './mcqchoice.service';

describe('McqchoiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: McqchoiceService = TestBed.get(McqchoiceService);
    expect(service).toBeTruthy();
  });
});
