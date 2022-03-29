import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isAdmin: boolean;
  user: any;

  constructor(private translateService: TranslateService) { }

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem("user") || "{}");
    this.isAdmin = this.user.roles.some((el: { name: string; }) => el.name == "ROLE_ADMIN");
  }

  public selectLanguage(event: any) {
    console.log(event.target.value)
    this.translateService.use(event.target.value)

  }

  logout() {
    localStorage.removeItem("user");
    window.location.reload();
  }
}
