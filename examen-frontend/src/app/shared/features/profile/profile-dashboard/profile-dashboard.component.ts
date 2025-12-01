import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileService, ProfileSummary } from '../services/profile.service';

@Component({
  selector: 'app-profile-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './profile-dashboard.component.html',
  styleUrls: ['./profile-dashboard.component.scss']
})
export class ProfileDashboardComponent implements OnInit {
  summary: ProfileSummary | null = null;
  loading = false;

  constructor(private profileService: ProfileService) {}

  ngOnInit(): void {
    this.loading = true;
    this.profileService.getSummaryForLast30Days().subscribe({
      next: (data) => {
        this.summary = data;
        this.loading = false;
      },
      error: () => {
        this.loading = false;
      }
    });
  }
}
