import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class signupPage {

    navigateToSignupPage() {
        return browser.get('/signup');
    }

    sendNameSignupPage() {
        return element(by.id('signupname'));
    }

    sendEmailSignupPage() {
        return element(by.id('signupemail'));
    }

    sendPasswordForSignup() {
        return element(by.id('signuppassword'));
    }

    sendLanguageId() {
        return element(by.id('languageid'));
    }

    getSignupButton() {
        return element(by.className('btn btn-info'));
    }

}
