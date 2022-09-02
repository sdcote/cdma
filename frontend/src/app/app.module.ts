import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MaterialModule } from './material.module';

import { AppComponent } from './app.component';
import { SurveyModule } from './survey/survey.module';

@NgModule({
  imports: [
    BrowserModule,
    MaterialModule,
    SurveyModule
  ],
  declarations: [AppComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
