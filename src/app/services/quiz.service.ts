import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  private backendApiUrl='http://localhost:8080/api/quiz'

  http=inject(HttpClient);

  getQuizQuestions(limit:number,category:string):Observable<any>{
    return this.http.get<any[]>(`${this.backendApiUrl}/questions?&limit=${limit}&category=${category}`);
  }

  submitQuiz(selectedAnswers:{[key:number]:string},questions:any[]){
    const requestBody = {selectedAnswers,questions};
    return this.http.post<any>(`${this.backendApiUrl}/submit`,requestBody);
  }

}
