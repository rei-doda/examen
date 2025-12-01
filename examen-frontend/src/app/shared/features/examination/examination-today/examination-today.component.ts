import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ExaminationService } from '../services/examination.service';
import { DailyExamination, ExaminationAnswer } from '../models/examination.model';

@Component({
  selector: 'app-examination-today',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './examination-today.component.html',
  styleUrls: ['./examination-today.component.scss']
})
export class ExaminationTodayComponent implements OnInit {

  exam: DailyExamination | null = null;
  loading = true;
  errorMessage = '';

  constructor(private examService: ExaminationService) {}

  ngOnInit(): void {
    this.examService.getToday().subscribe({
      next: (data: DailyExamination) => {
        this.exam = data;
        this.loading = false;
      },
      error: () => {
        this.errorMessage = 'Failed to load today\'s examination.';
        this.loading = false;
      }
    });
  }

  /**
   * Handles checkbox toggle using safe HTMLInputElement casting.
   */
  onToggle(questionId: number, event: Event): void {
    if (!this.exam) return;

    const input = event.target as HTMLInputElement | null;
    if (!input) return;

    const ans = this.exam.answers.find(
      (a: ExaminationAnswer) => a.questionId === questionId
    );

    if (ans) {
      ans.answerValue = input.checked;
    }
  }

  /**
   * Saves the examination to backend.
   */
  save(): void {
    if (!this.exam) return;

    this.examService.save(this.exam).subscribe({
      next: () => {},
      error: () => {
        this.errorMessage = 'Failed to save examination.';
      }
    });
  }

  /**
   * trackBy function for efficient rendering.
   */
  trackByQuestionId(index: number, item: ExaminationAnswer): number {
    return item?.questionId ?? index;
  }
}
