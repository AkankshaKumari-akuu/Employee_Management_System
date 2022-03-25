import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OutputAllEmpComponent } from './output-employee.component';

describe('OutputEmployeeComponent', () => {
  let component: OutputAllEmpComponent;
  let fixture: ComponentFixture<OutputAllEmpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OutputAllEmpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OutputAllEmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
