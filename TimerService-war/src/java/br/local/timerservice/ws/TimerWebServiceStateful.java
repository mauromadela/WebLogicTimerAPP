/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.local.timerservice.ws;


import br.local.timerservice.ejb.stateful.EjbTimerServiceRemote;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author msmadela
 */
//@Stateless
@WebService
public class TimerWebServiceStateful {

    @EJB
    EjbTimerServiceRemote ejbTimerServiceRemote;
    
    Long retorno;        
    
    @WebMethod
    public String setTimer(@WebParam(name="tempo") Long time) throws InterruptedException {
        System.out.printf("\nTimerWebService: Tempo requisitado de %d milisegundos...", (time));
        retorno = ejbTimerServiceRemote.start(time);
        System.out.printf("\nTimerWebService: Tempo esperado foi de %d milisegundos...", (retorno));
        return String.valueOf(time);
    }        
}
