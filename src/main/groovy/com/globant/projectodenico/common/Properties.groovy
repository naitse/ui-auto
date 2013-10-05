package com.globant.projectodenico.common

import org.apache.log4j.Logger

/**
 * Created with IntelliJ IDEA.
 * User: sebastiangramano
 * Date: 6/13/13
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
class Properties {

    final Logger LOG = Logger.getLogger(Properties);

    //System.getProperty() es para obtener las properties que pasas como parametros cuando mandas a ejecutar

    static  usuario = resolveProp(System.getProperty("user"),'nicoautomation')
    static  password = resolveProp(System.getProperty("pass"),'Aut0m4T10n')

    def static private resolveProp(String toResolve, String defaultValue){
        return (toResolve != null) ? toResolve :defaultValue;
    }

}
