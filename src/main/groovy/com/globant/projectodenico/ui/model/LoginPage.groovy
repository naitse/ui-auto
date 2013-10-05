package com.globant.projectodenico.ui.model

import geb.Page

/**
 * This class represents the Login page and its elements.
 * <p>
 *
 * @author      sebastiangramano
 * @version     1.0
 * @since       1.0
 */
class LoginPage extends Page{
	
	static at = { title == "Google Accounts" }
    private static final String DEFAULT_USERNAME = com.globant.projectodenico.common.Properties.usuario
    private static final String DEFAULT_PASSWORD = com.globant.projectodenico.common.Properties.password

    /**
     * Page content elements
     */
	static content = {

		signinBox(required:false){ $("#yreglg") }
        username(required: false){ signinBox.find("#username")}
        password(required: false){ signinBox.find("#passwd")}
        loginBtn(to: MailsPage) {signinBox.find("#submit button")}

	}

    /**
     * Types user and password data and clicks login button
     */
    void login(Map credentials)
    {
        browser.clearCookiesQuietly()
        //por si le queres pasar credenciales en los tests pero no esta bueno
        String user = credentials?.username ?: configValue('username', DEFAULT_USERNAME)
        String passwd = credentials?.password ?: configValue('password', DEFAULT_PASSWORD)

        username << user
        password << passwd

        loginBtn.click()

        waitFor('slow') {
            $('#main-btn-new').isDisplayed()
        }

    }

    private String configValue(String name, String defaultValue) {
        browser.config.readValue name, defaultValue
    }
}
