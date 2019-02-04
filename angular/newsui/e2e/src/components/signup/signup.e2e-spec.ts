import { protractor, browser } from 'protractor';
import { signupPage } from './signup.po';

describe('Signup page', () => {
    let page: signupPage;

    const EC = protractor.ExpectedConditions;
    
    beforeEach(() => {
        page = new signupPage();
        page.navigateToSignupPage();
    });

    it('should be able to signup as a new user' , () => {
        page.sendNameSignupPage().sendKeys('John');
        page.sendEmailSignupPage().sendKeys('john@email.com');
        page.sendPasswordForSignup().sendKeys('654321');
        page.sendLanguageId().sendKeys("English");
        page.getSignupButton().click();
        expect(browser.driver.getCurrentUrl()).toContain('');
    }); 
    
});