import { Component, inject } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  imports: [FormsModule,RouterLink,CommonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {

  username: string='';
  password: string='';

  authService=inject(AuthService);
  router=inject(Router);

  register(){
    const user={username:this.username,password:this.password};
    console.log('User Object:', user);
    this.authService.register(user).subscribe(
      (message)=>{
        alert(message);
        this.router.navigate(['/login']);
      },
      (error)=>{
        alert('Error Registering!')
      }
    )
  }

}
