package com.globant.utils

import geb.Browser
import javax.mail.Flags
import javax.mail.Folder
import javax.mail.Message
import javax.mail.MessagingException
import javax.mail.NoSuchProviderException
import javax.mail.Session
import javax.mail.Store



/**
* Created with IntelliJ IDEA.
* User: sebastiangramano
* Date: 2/27/13
* Time: 6:26 PM
* To change this template use File | Settings | File Templates.
*/


class InvitationIdReader {

    Browser browser = new Browser();
    String email_address = "cloudhubautomation@gmail.com";
    String password = "mulemanishere";
    Properties props = System.getProperties();

     String getId() {

         props.setProperty("mail.store.protocol", "imaps");

         def env = 'qa'

         if (!"${browser.config.baseUrl}".contains("qa.cloudhub")){
            env = 'qa2'
         }

        try {


            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", email_address, password);
            System.out.println(store);

            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_ONLY);
            //FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            //def messages = inbox.search(ft);

            def messages = inbox.getMessages()

            Message message = messages[messages.length - 1];

            String message_content = ((String) message.getContent()).find(/(https:\/\/${env}.cloudhub.io\/signup.html.*)/);

            String invitation_id = message_content.minus("${browser.config.baseUrl}signup.html?inviteId=")

            inbox.close(true)
            store.close()

            return invitation_id;

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.exit(2);
        }
     }

    void clearInbox() {

        props.setProperty("mail.store.protocol", "imaps");

        try {
            System.out.print("Clearing Inbox")

            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", email_address, password);

            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);

            def messages = inbox.getMessages()

            for(Message message in messages){
                message.setFlag(Flags.Flag.DELETED, true)
            }



            inbox.close(true)
            store.close()
            sleep(10000)
            System.out.print("END")

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.exit(2);
        }

    }

}