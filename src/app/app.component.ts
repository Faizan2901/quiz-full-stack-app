import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { QuizComponent } from "./components/quiz/quiz.component";
import { LoginComponent } from "./components/login/login.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, QuizComponent, LoginComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'quiz-frontened';
}
