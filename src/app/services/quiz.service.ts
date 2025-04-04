import { HttpClient, HttpHeaders } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  private backendApiUrl='http://localhost:8080/api/quiz'

  http=inject(HttpClient);

  getQuizQuestions(limit:number,category:string,token:string):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<any[]>(`${this.backendApiUrl}/questions?&limit=${limit}&category=${category}`,{headers});
  }

  submitQuiz(selectedAnswers:{[key:number]:string},questions:any[]){
    const requestBody = {selectedAnswers,questions};
    return this.http.post<any>(`${this.backendApiUrl}/submit`,requestBody);
  }

}
