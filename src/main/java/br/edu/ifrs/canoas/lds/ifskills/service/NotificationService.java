/**
 * @author: Aline G.
 * @date: 05/04/2016
 * @description: This is the service class for sending an Notification (e-mail)
 */
package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.Article;

@Service
public class NotificationService {
	
	private JavaMailSender javaMailSender;

	@Autowired
	public NotificationService(JavaMailSender javaMailSender){
	    this.javaMailSender = javaMailSender;
	}

	public SimpleMailMessage sendNotification(Article article) throws MailException {
	    // send email
		
	    SimpleMailMessage mail = new SimpleMailMessage();

	    if (article != null){
		    mail.setTo(article.getAuthor().getEmail());
		    mail.setFrom("labifrs2016.1@gmail.com");
		    mail.setSubject("Your article was deleted");
		    mail.setText("Dear author " + article.getAuthor().getFullName() + ", \n\n" +
		                  "Your article called '" + article.getTitle() + "' was deleted by one of our Administrators.\n" +
		    		      "If there's any problem with that, feel free to call us any moment.\n" +
		                  "\n\nHere's a copy of your article:\n\n" + article.getTitle() + "\n\n" + article.getTeaser() +
	                      "\n\n" + article.getBody() + "\n\n" +
		    		      "\n\n\nBest Regards, \n" + "IFRS Lab - 2016\n");
		    javaMailSender.send(mail);

		}
	    
	    return mail;
	}
	
	/**
	 * @author Luciane
	 * Date: 17/04/2016
	 * Description: Method that sends an email when a job posting is deleted
	 * @param jobAd
	 * @return
	 * @throws MailException
	 */
	public SimpleMailMessage sendNotification(SimpleMailMessage mail) throws MailException {
		javaMailSender.send(mail);
		return mail;
	}
	
}
