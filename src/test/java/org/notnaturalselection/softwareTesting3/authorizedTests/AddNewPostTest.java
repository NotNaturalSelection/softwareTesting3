package org.notnaturalselection.softwareTesting3.authorizedTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.notnaturalselection.softwareTesting3.AuthorizedBrowserTest;
import org.notnaturalselection.softwareTesting3.pageObjects.NewPostPage;
import org.notnaturalselection.softwareTesting3.pageObjects.MainLoggedPage;
import org.notnaturalselection.softwareTesting3.pageObjects.PostPage;

public class AddNewPostTest extends AuthorizedBrowserTest {
    static MainLoggedPage mainLoggedPage;
    static NewPostPage newPostPage;
    static PostPage postPage;

    @BeforeAll
    public static void init() {
        mainLoggedPage = new MainLoggedPage(driver);
        newPostPage = new NewPostPage(driver);
        postPage = new PostPage(driver);
    }

    @Test
    public void addPost() {
        mainLoggedPage.postsSidebarItem.click();
        waitUntilClickable(mainLoggedPage.addPostSidebarItem);
        waitUntilVisible(mainLoggedPage.addPostSidebarItem);
        mainLoggedPage.addPostSidebarItem.click();
        waitUntilDocumentIsLoaded();
        waitUntilVisible(newPostPage.headerTextarea);
        waitUntilClickable(newPostPage.headerTextarea);
        newPostPage.bodyTextarea.click();
        waitUntilClickable(newPostPage.bodyP);
        waitUntilVisible(newPostPage.bodyP);
        String testHeader = "test header";
        newPostPage.headerTextarea.sendKeys(testHeader);
        String testBody = "test body";
        newPostPage.bodyP.sendKeys(testBody);
        newPostPage.postTabButton.click();
        waitUntilVisible(newPostPage.discussionsTab);
        newPostPage.discussionsTab.click();
        newPostPage.forbidCommentsLabel.click();
        waitUntilClickable(newPostPage.submitPostButton);
        newPostPage.submitPostButton.click();
        waitUntilClickable(newPostPage.confirmSubmitPostButton);
        waitUntilVisible(newPostPage.confirmSubmitPostButton);
        newPostPage.confirmSubmitPostButton.click();
        waitUntilVisible(newPostPage.seeSubmittedPost);
        waitUntilClickable(newPostPage.seeSubmittedPost);
        newPostPage.seeSubmittedPost.click();
        waitUntilDocumentIsLoaded();
        waitUntilVisible(postPage.title);
        waitUntilVisible(postPage.contentP);
        assert postPage.title.getText().equals(testHeader);
        assert postPage.contentP.getText().equals(testBody);
    }
}
