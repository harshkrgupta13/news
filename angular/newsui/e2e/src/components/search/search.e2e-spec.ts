import { protractor, browser } from 'protractor';
import { SearchPage } from './search.po';

describe('Search page', () => {
    let page: SearchPage;
    let search = new SearchPage();
    const EC = protractor.ExpectedConditions;
    
    beforeEach(() => {
        page = new SearchPage();
        //page.navigateToSearchPage();
    });

    it('admin should be able to search analyst' , () => {
        page.sendEmailForSearch().sendKeys('a@email.com');
        page.getSearchButton().click();
        browser.wait(EC.visibilityOf(search.getTitle()));
        //expect(browser.driver.getCurrentUrl()).toContain('');
    }); 
    
});