/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;
import java.util.*;
import java.util.regex.*;
import javax.mail.*;
import javax.mail.internet.*;



/**
 *
 * @author pyszczekk
 */
public class EmailMessage {
private final String from; //required (must be e-mail)
private final LinkedList<String> to; //required at least one (must be e-mail) 
private final String subject; //optional
private final String content; //optional
private final String mimeType; // optional
private final LinkedList<String> cc; //optional
private final LinkedList<String> bcc; // optional
//Przykładowy konstruktor (można założyć, że pola opcjonalne mogą być null) 
private EmailMessage(EmailBuilder builder){
    to = builder.to;
    from = builder.from;
    subject = builder.subject;
    content = builder.content;
    mimeType = builder.mimeType;
    cc = builder.cc;
    bcc = builder.bcc;
}
        public static class EmailBuilder{
            private final String from;
            private final LinkedList<String> to; //required at least one (must be e-mail) 
            private String subject; //optional
            private  String content; //optional
            private  String mimeType; // optional
            private  LinkedList<String> cc; //optional
            private  LinkedList<String> bcc; // optional
            public EmailBuilder( String from, LinkedList<String> _to){
               
                String emailRegex = "[a-zA-Z0-9_.]+@[a-zA-Z0-9]+.[a-zA-Z]{2,3}[.] {0,1}[a-zA-Z]+";
                if(Pattern.matches(emailRegex, from)){
                     this.from = from;
                }else throw new java.lang.Error("bled w twoim mailu");
                    
                 
                for(int i = 0 ; i<_to.size();i++){
                    if(Pattern.matches(emailRegex,_to.get(i))==false){
                        throw new java.lang.Error("bledy w mailach");
                    }
                    
                    }
                this.to=_to;
                
            }
            public void setSubject(String _sub){
                this.subject = _sub;
            }
            public void setContent(String _con){
                this.content = _con;
            }
            public void setMimeType(String mime){
                this.mimeType = mime;
            }
            public void setCC(LinkedList<String> cc){
                this.cc=cc;
            }
            public void setBCC(LinkedList<String> bcc){
                this.bcc=bcc;
            }  
            public EmailMessage build(){
                return new EmailMessage(this);
            }
            
}


public void send(){
 
    Properties props = System.getProperties();
     String host = "localhost";
      // Setup mail server
     
        System.out.println("podaj haslo");
        Scanner odczyt = new Scanner(System.in);
        String password = odczyt.nextLine();
        String SMTP_HOST_NAME = "smtp.poczta.onet.pl";
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
            }
        });
      // Get the default Session object.
     // Session session = Session.getDefaultInstance(props);
     try {
         for(int i =0; i<this.to.size();i++){
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to.get(0)));
         message.setSubject(subject);
         message.setContent(content, "text/html");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
         }
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
}
}
