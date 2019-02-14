/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.local.timerservice.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 *
 * @author msmadela
 */

@Stateless//(name = "EjbTimerServiceBean", mappedName = "ejb/EjbTimerServiceBean")
public class EjbTimerServiceBean implements EjbTimerServiceRemote {

    @Override
    public Long start(Long tempo) {
        try {
            System.out.printf("\nEjbTimerServiceBean: Tempo requisitado de %d milisegundos...", (tempo));
            Thread.sleep(tempo);
            System.out.printf("\nEjbTimerServiceBean: Tempo requisitado de %d milisegundos...", (tempo));
           
        } catch (InterruptedException ex) {
            Logger.getLogger(EjbTimerServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tempo;
    }
}
