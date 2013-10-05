package com.globant.projectodenico.common

import org.openqa.selenium.remote.RemoteWebDriver

/**
 * Created with IntelliJ IDEA.
 * User: sebastiangramano
 * Date: 6/13/13
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
class Utils{

    //solo funca en cloud
    static void stopMonitoring(RemoteWebDriver driver){
        driver.executeScript("require('utils/monitors').stopAll()")
        sleep(3000)
    }

    static void reloadPage(RemoteWebDriver driver){
        driver.executeScript("window.location.reload()")
        sleep(3000)
    }


}
