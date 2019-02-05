import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class SearchPage {

   getTitle(){
       return element(by.css('h2'));
   }
   
    sendEmailForSearch() {
        return element(by.id('searchAnalyst'));
    }

    getSearchButton() {
        return element(by.className('btn btn-primary bt'));
    }

}
