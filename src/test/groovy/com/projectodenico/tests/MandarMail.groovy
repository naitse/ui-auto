package com.projectodenico.tests

import com.globant.projectodenico.ui.model.LoginPage
import geb.Browser
import org.apache.log4j.Logger
import org.openqa.selenium.Keys
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

/**
 * Test Suite. functional test cases for create application
 * <p>
 *
 * @author      adcarabajal
 * @version     1.0
 * @since       1.0
 */
class MandarMail {
    static Logger LOG = Logger.getLogger(MandarMail);


    @BeforeClass(groups = ["smoke"])
    static void setUp(){

    }

   @AfterClass(groups = ["smoke"])
    static void tearDown(){
    }

    @Test(groups = ["smoke"])
    void 'Me mando un mail'() throws Exception {

        Browser.drive {
            to LoginPage
            LOG.info('Starting loging process')
            login()
            LOG.info('EXACTO (?)')

            openComposeView()

            toField << "${com.globant.projectodenico.common.Properties.usuario}@yahoo.com.ar"
            toField << Keys.chord(Keys.ENTER)  //es para los botones que se habilitan cuando cambias de input
            subject << 'mi primer automation de UI'

            saveDraft()

            goToDrafts()

            assert draftBtn.find('.unread-count ').text() == '(1)', 'o hay mas de un draft o no aparecio el indicador'
            assert $('.from').find('span').text() == "${com.globant.projectodenico.common.Properties.usuario}@yahoo.com.ar", 'AVENGE ME!!'
            assert $('.subj').find('span').text() == 'mi primer automation de UI', 'algo paso'

            $('#btn-ml-cbox input').click()

            deleteMails()

            assert draftBtn.find('.unread-count ').isDisplayed() == false, 'no tiene la clase invisible'

        }
    }




}