import { Component } from '@angular/core';
import { RouterOutlet, Router } from '@angular/router';
import { LocalStorageService } from './core/services/local-storage.service';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrls: ['./app.scss']
})
export class App {

  constructor(private router: Router, private storage: LocalStorageService) {}

  logout() {
    this.storage.clear();
    this.router.navigate(['/auth/login']);
  }

}
