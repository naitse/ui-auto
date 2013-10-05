package com.globant.projectodenico.ui.model

import geb.Page
import org.apache.log4j.Logger

/**
 * This class represents the 'MailsPage' page and its elements.
 * <p>
 *
 * @author      sebastiangramano
 * @version     1.0
 * @since       1.0
 */
class MailsPage extends Page {
    private static final Logger LOG = Logger.getLogger(MailsPage)

//    static url = "console.html"
//    static at = { title == "CloudHub" }

    /**
     * Page content elements
     */
    static content = {
        composeBtn {
            waitFor{$("#main-btn-new").isDisplayed()}
            $("#main-btn-new a")
        }

        sendBtn(required:false) {$("#btn-send a")}

        saveDraftBtn(required: false) {$('#btn-save-draft')}

        toField(required:false) {$('#to input')}

        subject(required:false) {$('#subject input')}

        inboxBtn(required: false) {$("#Inbox")}

        draftBtn(required: false) {$('#Draft')}

        deleteBtn(required: false) {$('#btn-delete')}

    }

    void openComposeView(){
        composeBtn.click()
        waitFor{
            toField.isDisplayed()
        }
    }

    void sendMail(){

        sendBtn.click()

        sleep(5000)
    }

    void saveDraft(){
        saveDraftBtn.click()
        sleep(5000)
    }

    void deleteMails(){
        deleteBtn.click()
        sleep(5000)
    }

    void goToDrafts(){
        draftBtn.click()
        sleep(3000)
    }

    Boolean refreshInbox(tries, interval){

        def flag = false
        def i=0
        while(i < tries){

            if($('#empty-folder-msg').size() > 0){
                LOG.info("refreshing inbox... try n ${i} of ${tries}")
                inboxBtn.click()
            }else{
                flag = true
                break
            }

            sleep(interval)
            i++
        }

        return flag

    }

}