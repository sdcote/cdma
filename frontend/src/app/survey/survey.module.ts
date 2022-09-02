import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { SurveyContainerComponent } from './containers/survey-container/survey-container.component';
import { SurveyFormComponent } from './components/survey-form/survey-form.component';
import { SurveyService } from './services/survey.service';
import { MaterialModule } from '../material.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule
  ],
  declarations: [SurveyContainerComponent, SurveyFormComponent],
  providers: [SurveyService],
  exports: [SurveyContainerComponent]
})
export class SurveyModule { }
