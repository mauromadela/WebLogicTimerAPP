/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.local.timerservice.ejb.stateful;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;


/**
 *
 * @author msmadela
 */

@Stateful(name = "EjbTimerServiceStateFulBean", mappedName = "ejb/EjbTimerServiceStateFulBean")
public class EjbTimerServiceStateFulBean implements EjbTimerServiceRemote {

    @Override
    public Long start(Long tempo) {
        try {
            System.out.printf("\nEjbTimerServiceBean: Tempo requisitado de %d milisegundos...", (tempo));
            Thread.sleep(tempo);
            System.out.printf("\nEjbTimerServiceBean: Tempo requisitado de %d milisegundos...", (tempo));
           
        } catch (InterruptedException ex) {
            Logger.getLogger(EjbTimerServiceStateFulBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tempo;
    }
}
