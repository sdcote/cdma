import { FieldError } from './field-error.model';

export interface RestError {
  code: string;
  message: string;
  fieldsErrors?: FieldError[];
}
