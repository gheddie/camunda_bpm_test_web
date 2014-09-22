package de.gravitex.bpmtest.ejb.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailHelper {

	private static final String SMTP = "bcc-sv005.bcc.intern";
	
	public static void sendEmail(String from, String to, String cc, String bcc, String subject, String body) throws MessagingException {
		
		// (1) Get a mail session.
		Properties props = new Properties();
		props.setProperty("mail.mime.charset", "utf-8");
		Session mx = Session.getInstance(props);

		// (2) Prepare message.
		MimeMessage msg = new MimeMessage(mx);

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
		
		msg.setFrom(new InternetAddress(from));			
		
		if(!(isBlank(cc))) {
			msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc, false));			
		}
		
		if(!(isBlank(bcc))) {
			msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(cc, false));
		}

		msg.setSubject(subject, "UTF-8");
		msg.setText(body, "UTF-8");

		// (3) Send message.
		Transport t = mx.getTransport("smtp");
		t.connect(SMTP, null, null);
		t.sendMessage(msg, msg.getAllRecipients());
		t.close();
	}	
	
	public static boolean isBlank(String s) {
		return s == null || s.length() == 0;
	}	
}
