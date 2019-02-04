import { LoginPage } from './login.po';
import { protractor, browser } from 'protractor';
import { NewsPage } from '../news/news.po';
import { SearchPage } from '../search/search.po';

describe('Login page', () => {
    let page: LoginPage;
    let news = new NewsPage;
    let search = new SearchPage();
  
    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new LoginPage();
        page.navigateToLoginPage();
    });


    it('should be able to login as news analyst', () => {
        page.sendEmailForLogin().sendKeys('a@email.com');
        page.sendPasswordForLogin().sendKeys('111111');
        page.getLoginButton().click();
        browser.wait(EC.visibilityOf(news.getTitle()));
        expect(browser.driver.getCurrentUrl()).toContain('/searchnews');
    });

    it('should be not be able to login as an admin', () => {
        page.sendEmailForLogin().sendKeys('admin@email.com');
        page.sendPasswordForLogin().sendKeys('123456');
        page.getLoginButton().click();
        browser.wait(EC.visibilityOf(search.getTitle()));
        //browser.wait(EC.visibilityOf(page.getErrorMessage()));
        expect(browser.driver.getCurrentUrl()).toContain('/search');
    });

});


// https://trailheadtechnology.com/ui-automation-testing-of-angular-apps-using-protractor-jasmine/
// https://scotch.io/@charlieoduk/angular-end-to-end-testing507


// --- Karma

// https://scotch.io/tutorials/testing-angular-with-jasmine-and-karma-part-1