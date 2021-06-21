import { TestBed } from '@angular/core/testing';

import { ConfPersonajesService } from './confPersonajes.service';

describe('ConfPersonajesService', () => {
  let service: ConfPersonajesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConfPersonajesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
