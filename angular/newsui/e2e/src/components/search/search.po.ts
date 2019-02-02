import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class SearchPage {

   getTitle(){
       return element(by.css('h2'));
   }
   
}
