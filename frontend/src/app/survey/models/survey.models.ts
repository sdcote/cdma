export interface UserResponse {
  content: string;
  questionId: number;
}

export interface Subject {
  id: number;
  label: string;
  questions: Question[];
}

export interface Question {
  id: number;
  label: string;
}
