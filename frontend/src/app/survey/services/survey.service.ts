import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { UserResponse, Question, Subject } from '../models/survey.models';

@Injectable()
export class SurveyService {

  SUBJECT_API = 'http://localhost:8080/api/v1/subjects';
  QUESTION_API = 'http://localhost:8080/api/v1/questions';

  constructor(private httpClient: HttpClient) { }

  /**
   * Get all the subjects and their questions
   *
   * @returns {Observable<Question[]>} all the found subjects and their questions
   */
  getAllSubjectsAndQuestions(): Observable<Subject[]> {
    return this.httpClient.get<Subject[]>(this.SUBJECT_API);
  }

  /**
   * Get all responses of the connected user for the questions
   *
   * @param {number[]} questions ids of the questions that the user may respond
   * @returns {Observable<UserResponse[]>} the found responses of the connected user for the provided questions
   */
  getResponsesOfConnectedUserForQuestions(questions: number[]): Observable<UserResponse[]> {
    return this.httpClient.get<UserResponse[]>(this.QUESTION_API + '/' + questions.toString() + '/responses/me');
  }

  /**
   * Add and update the responses of the connected user for the provided questions
   *
   * @param {UserResponse[]} userResponses new responses of the user
   * @returns {Observable<UserResponse[]>} the list of the saved responses of the user
   */
  saveResponsesOfConnectedUserForQuestions(userResponses: UserResponse[]): Observable<UserResponse[]> {
    return this.httpClient.post<UserResponse[]>(this.QUESTION_API + '/responses/me', userResponses);
  }

}
