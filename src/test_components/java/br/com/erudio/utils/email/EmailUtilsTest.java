package br.com.erudio.utils.email;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class EmailUtilsTest {
	
	EMailConfigs configs = new EMailConfigs();
	EmailUtils emailUtils = new EmailUtils();
	
	@Before
	public void setup() {
		configs.setHostname("smtp.mail.yahoo.com");
		configs.setFrom("from@yahoo.com.br");
		configs.setPassword("password");
		configs.setPort(587);
		configs.setSsl(true);
		configs.setUsername("from@yahoo.com.br");
		configs.setSubject("LETS GROOVY");
		configs.setMessage("LETS GROOVY");
	}
	
	@Test
	public void sendEMailTest() {
		try {
			emailUtils.sendSimpleMail(configs, "to@gmail.com");
			emailUtils.sendEmailWithAttachment(configs, "to@gmail.com", "C://Users//LEANDRO//Desktop//teste.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
