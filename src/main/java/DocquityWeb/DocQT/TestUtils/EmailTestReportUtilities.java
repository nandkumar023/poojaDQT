package DocquityWeb.DocQT.TestUtils;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EmailTestReportUtilities {
	private Session mailSession;
	MimeMessage emailMessage;
	
	private static final Logger LOGGER = LogManager.getLogger(EmailTestReportUtilities.class);
	
	public static void SendMailSSLWithTestReport () {
			 	EmailTestReportUtilities javaEmail = new EmailTestReportUtilities();
		       
		        try {
		        	javaEmail.setMailServerProperties();
					javaEmail.draftEmailMessage();
					javaEmail.sendEmail();
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
		        
		    }
		 
		    private void setMailServerProperties()
		    {
		        Properties emailProperties = System.getProperties();
		        emailProperties.put("mail.smtp.port", "587");
		        emailProperties.put("mail.smtp.auth", "true");
		        emailProperties.put("mail.smtp.starttls.enable", "true");
		        mailSession = Session.getDefaultInstance(emailProperties, null);
		    }
		 
		    private MimeMessage draftEmailMessage() throws AddressException, MessagingException
		    {
		        String[] toEmails = { "mail.singhsarabjit@gmail.com"};
		        String emailSubject = "Test Reports";
		        //String emailBody = "This is an email sent by <b>//howtodoinjava.com</b>.";
		        MimeMessage emailMessage = new MimeMessage(mailSession);
		        // Create object to add multimedia type content
		        BodyPart messageBodyPart1 = new MimeBodyPart();
		     		 
		     	// Set the body of email
		     	messageBodyPart1.setText("Hello Team\n\n"+ "Please find attached the result of the test execution\n\n"
		     	+"Regards,\n"+ "Sarabjit Singh\n"+"Sr. QA Engineer");
		        //MimeBodyPart messageBodyPart2 = new MimeBodyPart();
		        // Mention the file which you want to send
		     	String fileIndexHtml = System.getProperty("user.dir")+"\\test-output\\index.html";
		     	String fileExtentReport=System.getProperty("user.dir")+"\\test-output\\newExtentReport.html";
		     	String logsFile=System.getProperty("user.dir")+"\\logs\\propertieslogs.log";
		     	
		     	 // Create object of MimeMultipart class
		     	Multipart multipart = new MimeMultipart();
		     	
		     	addAttachment(multipart, fileIndexHtml);
		     	addAttachment(multipart, fileExtentReport);
		     	addAttachment(multipart, logsFile);
		     		 
		     	// add body part 1
		     	multipart.addBodyPart(messageBodyPart1);
		     		
		        /**
		         * Set the mail recipients
		         * */
		        for (int i = 0; i < toEmails.length; i++)
		        {
		            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		            System.out.println("Receipients email is -->> "+toEmails[i]);
		        }
		        emailMessage.setSubject(emailSubject);
		        /**
		         * If sending HTML mail
		         * */
		        //emailMessage.setContent(emailBody, "text/html");
		        emailMessage.setContent(multipart);
		        /**
		         * If sending only text mail
		         * */
		        //emailMessage.setText(emailBody);// for a text email
		        
		        return emailMessage;
		    }
		    
		    private void addAttachment(Multipart multipart, String filename) {
		    	// Create data source and pass the filename
		    	DataSource source = new FileDataSource(filename);
		        BodyPart messageBodyPart = new MimeBodyPart();        
		        try {
		        	// set the handler
					messageBodyPart.setDataHandler(new DataHandler(source));
					// set the file
					messageBodyPart.setFileName(filename);
					// add body part to Multiple Part
				    multipart.addBodyPart(messageBodyPart);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		 
		    private void sendEmail() throws AddressException, MessagingException
		    {
		        /**
		         * Sender's credentials
		         * */
		        String fromUser = "sabby210691@gmail.com";
		        String fromUserEmailPassword = "sabby210691";
		 
		        String emailHost = "smtp.gmail.com";
		        Transport transport = mailSession.getTransport("smtp");
		        transport.connect(emailHost, fromUser, fromUserEmailPassword);
		        /**
		         * Draft the message
		         * */
		        MimeMessage emailMessage = draftEmailMessage();
		        /**
		         * Send the mail
		         * */
		        try {
		        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		        transport.close();
		        }
		        catch(Exception e) {
		        	e.printStackTrace();
		        }
		        System.out.println("Email sent successfully.");
		    }
	}

