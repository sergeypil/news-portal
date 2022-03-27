import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthRequest, AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  tryLogin(form: NgForm) {
    console.log("in login");
    const authRequest: AuthRequest = {
      username: form.value["username"],
      password: form.value["password"],
    };
    console.log(authRequest);
    this.authService.login(authRequest).subscribe(data => {
      console.log("access");
      console.log(JSON.stringify(data))
      localStorage.setItem("user", JSON.stringify(data));
      this.router.navigate(['/'])
        .then(() => {
          window.location.reload();
        });
    })
  }

}
