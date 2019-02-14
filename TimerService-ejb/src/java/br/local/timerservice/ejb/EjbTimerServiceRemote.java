/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.local.timerservice.ejb;

import javax.ejb.Remote;

/**
 *
 * @author msmadela
 */
@Remote
public interface EjbTimerServiceRemote {
    public Long start(Long tempo);    

}
