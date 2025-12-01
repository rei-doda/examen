export interface ExaminationAnswer {
  questionId: number;
  answerValue: boolean;
}

export interface DailyExamination {
  id: number;
  date: string;
  answers: ExaminationAnswer[];
}
