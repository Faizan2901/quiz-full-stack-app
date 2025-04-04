import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { QuizService } from '../../services/quiz.service';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-quiz',
  imports: [FormsModule,CommonModule,RouterLink],
  templateUrl: './quiz.component.html',
  styleUrl: './quiz.component.scss'
})
export class QuizComponent {

  quizService=inject(QuizService);
  authService=inject(AuthService);
  router=inject(Router);
  questions:any[]=[];
  limit:number=0;
  category:string='';
  selectedAnswers: { [key: number]: string } = {};
  answerKeys = ['answer_a', 'answer_b', 'answer_c', 'answer_d'];
  score:number=0;


  getQuizQuestions() {
    const token = this.authService.getToken();
  
    if (!token) {
      console.error("No token found! Please log in.");
      return;
    }
  
    this.quizService.getQuizQuestions(this.limit, this.category, token).subscribe(
      (data) => {
        this.questions = data;
        console.log("Fetched Questions:", this.questions); 
      },
      (error) => {
        console.error("Error fetching quiz questions:", error);
      }
    );
  }
  
  submitQuiz(){
    this.quizService.submitQuiz(this.selectedAnswers,this.questions).subscribe(
      (score)=>{
        this.score=score;
      }
    )
  }

  logout() 
  {
      this.authService.logout();
      this.router.navigate(['/login']);
  }
  

}
