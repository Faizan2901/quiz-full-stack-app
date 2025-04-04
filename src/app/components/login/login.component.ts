import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [FormsModule,RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  username: string='';
  password: string='';

  authService=inject(AuthService);
  router=inject(Router);

  login(){
    const credentials={username:this.username,password:this.password};
    this.authService.login(credentials).subscribe(
      (token)=>{
        this.authService.saveToken(token);
        alert('Login Successful!');
        this.router.navigate(['/quiz']);
      },(error)=>{
        alert("Invalid Credentials!")
      }
    )
  }

}
