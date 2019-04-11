package com.capgemini.LoginRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AmazonSESSample {

    static final String FROM = "swagatakundu1995@gmail.com";
    static final String FROMNAME = "On-Call Doctor";
 static final String SMTP_USERNAME = "AKIA45EWSXMDCCLGVM5C";
     static final String SMTP_PASSWORD = "BG5dfic+GE7mDgAOvbSf/XMOyBUAATvhFub5Z0cm0k3q";
  static final String CONFIGSET = "sampleset";
   static final String HOST = "email-smtp.us-east-1.amazonaws.com";
    static final int PORT = 587;
       static final String SUBJECT = "Registration Successsful!!!";
    
    
    public static String sendEmail(String TO,String receiver) throws Exception {

    	
        
    	 final String BODY = String.join(
    	    	    System.getProperty("line.separator"),
    	    	    "Dear ",receiver," ,",
    	    	    "<h1>Welcome to On-Call Doctor Application!</h1>",
    	    	    "<p>This is an auto-generated email. Do not reply to it!</p>",
    	    	    "<p> We look forward to serving you soon.</p>",
    	    	    "<p>Thanks!</p>",
    	    	    "<h3>The On-Call Doctors Team</h3>"
    	    	   
    	    	);
    	Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", PORT); 
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.auth", "true");

        // Create a Session object to represent a mail session with the specified properties. 
    	Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information. 
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM,FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        msg.setSubject(SUBJECT);
        msg.setContent(BODY,"text/html");
        
        // Add a configuration set header. Comment or delete the 
        // next line if you are not using a configuration set
        msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
            
        // Create a transport.
        Transport transport = session.getTransport();
                    
        // Send the message.
        try
        {
            System.out.println("Sending...");
            
            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
        	
            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
            return "Email sent!";
            
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
            return "The email was not sent";
           
        }
        finally
        {
            // Close and terminate the connection.
            transport.close();
        }
    }
}