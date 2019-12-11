import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'filter'
  })
  export class FilterPipe implements PipeTransform {
    transform(questions: any[], searchText: string): any[] {
      if(!questions) return [];
      if(!searchText) return questions;
  searchText = searchText.toLowerCase();
  return questions.filter( it => {
        return it.content.toLowerCase().includes(searchText);
      });
     }
  }