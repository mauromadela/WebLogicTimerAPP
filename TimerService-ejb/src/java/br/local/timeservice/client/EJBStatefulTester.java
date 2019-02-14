/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.local.timeservice.client;

import br.local.timerservice.ejb.stateful.EjbTimerServiceRemote;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author mmadela
 */
public class EJBStatefulTester {
   BufferedReader brConsoleReader = null; 
   Properties props;
   InitialContext ctx;
   {
      props = new Properties();
      try {
         props.load(new FileInputStream("jndi.properties"));
      } catch (IOException ex) {
         ex.printStackTrace();
      }
      try {
         ctx = new InitialContext(props);            
      } catch (NamingException ex) {
         ex.printStackTrace();
      }
      brConsoleReader = 
      new BufferedReader(new InputStreamReader(System.in));
   }    

   public static void main(String[] args) throws NamingException {
       EJBStatefulTester ejbTester = new EJBStatefulTester();
       ejbTester.start();

   }

   public void start() throws NamingException {
       //String jndi = "java:global/EJBSleep/SleepSessionBean";
       String jndi = "java:global/TimerService/TimerService-ejb/EjbTimerServiceStateFulBean";
       
       EjbTimerServiceRemote bean = (EjbTimerServiceRemote) ctx.lookup(jndi);  
       Long tempo = 1000L;
       int quantidade = 200;
       for (int i = 0; i < quantidade; i++){
          bean.start(tempo);
          System.out.println("Tempo esperado foi de " + tempo + " mili segundos");           
       }
   }
}
