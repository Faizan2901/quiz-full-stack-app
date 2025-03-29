import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { QuizService } from '../../services/quiz.service';

@Component({
  selector: 'app-quiz',
  imports: [FormsModule,CommonModule],
  templateUrl: './quiz.component.html',
  styleUrl: './quiz.component.scss'
})
export class QuizComponent {

  quizService=inject(QuizService);
  questions:any[]=[];
  limit:number=0;
  category:string='';
  selectedAnswers: { [key: number]: string } = {};
  answerKeys = ['answer_a', 'answer_b', 'answer_c', 'answer_d'];
  score:number=0;


  getQuizQuestions(){
    this.quizService.getQuizQuestions(this.limit,this.category).subscribe(
      (data)=>{
        this.questions=data;
      }
    )
    console.log(this.questions);
  }
  submitQuiz(){
    this.quizService.submitQuiz(this.selectedAnswers,this.questions).subscribe(
      (score)=>{
        this.score=score;
      }
    )
  }

}
