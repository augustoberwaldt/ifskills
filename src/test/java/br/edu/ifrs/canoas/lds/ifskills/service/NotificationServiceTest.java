/**
 * @author: Aline G
 * @date: 06/04/2016
 * @description: Test of sendNotification()
 */
package br.edu.ifrs.canoas.lds.ifskills.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;
import br.edu.ifrs.canoas.lds.ifskills.domain.Article;
import br.edu.ifrs.canoas.lds.ifskills.domain.JobAd;
import br.edu.ifrs.canoas.lds.ifskills.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IFSkillsApplication.class)
public class NotificationServiceTest {
	
	@Autowired
	ArticleService articleService;
	@Autowired
	NotificationService notificationService;
	@Autowired
	UserRepository userRepository;


	@Test
	public void testSendNotification() {
		Article article = new Article();
		article.setAuthor(userRepository.findOne(9L));
		article.setTitle("My Title");
		article.setTeaser("This is the article's teaser.");
		article.setBody("This is the article's body!!!");
		
		/**
		 * This test result in a error: "is(notNullValue)".
		 */		
		assertThat(notificationService.sendNotification(article), is(notNullValue()));
		assertThat(notificationService.sendNotification(article), hasProperty("to",is(not(empty()))));
		
	}
	
	/**
	 * @author Luciane
	 * Date: 17/04/2016
	 * Description: Test method SendNotificationJobAd
	 * of the class  NotificationService
	 */
	@Test
	public void testSendNotificationJobAd() {
		JobAd jobAd = new JobAd();
		jobAd.setEmployer(userRepository.findOne(9L));
		jobAd.setDescription("My description job");
		jobAd.setBusinessArea("This is the job's business area.");
		jobAd.setRequirements("This is the job's requirements!!!");
		
		/**
		 * This test result in a error: "is(notNullValue)".
		 */		
		assertThat(notificationService.sendNotificationJobAd(jobAd), is(notNullValue()));
		assertThat(notificationService.sendNotificationJobAd(jobAd), hasProperty("to",is(not(empty()))));
		
	}
	

}
