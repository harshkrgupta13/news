import { LoginPage } from './login.po';
import { protractor, browser } from 'protractor';
import { SearchPage } from '../search/search.po';

//import { ArticlePage } from '../article/article.po';

describe('Login page', () => {
    let page: LoginPage;
    let search = new SearchPage();
    // tslint:disable-next-line:label-position
    // let article = new ArticlePage();
    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new LoginPage();
        page.navigateToLoginPage();
    });


    it('should be able to login', () => {
        page.sendEmailForLogin().sendKeys('a@email.com');
        page.sendPasswordForLogin().sendKeys('111111');
        page.getLoginButton().click();
        browser.wait(EC.visibilityOf(search.getTitle()));
        // browser.wait(EC.visibilityOf(article.getTitle()));
        //expect(article.getTitle().isPresent()).toBeTruthy();
        expect(browser.driver.getCurrentUrl()).toContain('/search');
    });

    it('should be not be able to login if email is wrong', () => {
        page.sendEmailForLogin().sendKeys('acvhnxc@email.com');
        page.sendPasswordForLogin().sendKeys('11145435111');
        page.getLoginButton().click();
        //browser.wait(EC.visibilityOf(page.getErrorMessage()));
        //expect(page.getErrorMessage().getText()).toBe('Invalid Email Id or Password.');
    });
});



// https://trailheadtechnology.com/ui-automation-testing-of-angular-apps-using-protractor-jasmine/
// https://scotch.io/@charlieoduk/angular-end-to-end-testing507


// --- Karma

// https://scotch.io/tutorials/testing-angular-with-jasmine-and-karma-part-1