package com.lazerycode.selenium.github.tests;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.github.pageobjects.GitHubHomePage;
import com.lazerycode.selenium.github.pageobjects.GitHubLoginPage;


public class GitHubLoginIT extends DriverBase {

	@Test
	public void should_not_login_with_wrong_credentials() throws Exception {
		//given
		GitHubLoginPage loginPage = new GitHubHomePage().open().goToLoginPage();
		//when
		loginPage.login("user", "password");
		//then
	
		assertFalse(loginPage.isLoginError());
	}
}
