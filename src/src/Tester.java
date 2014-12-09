package src;
/*
 * Created on Feb 21, 2005
 *
 */

import java.security.Security;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Tester   {

	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_PORT = "465";
	private static String emailMsgTxt = "Você tem blog, flog, ou algum outro tipo de site e está"
		+ "\nquerendo adicionar ferramentas, estatísticas ou acessórios?"
		+ "\n\nEntão você precisa conhecer o Recursos Web - http://www.recursosweb.net. Criado com"
+ "\no intuito de prover serviços para webmasters e blogueiros que"
+ "\nnão tem acesso ou conhecimento a alguns recursos. Possui"
+ "\nserviços do tipo protetor de link, troca de banner, troca de botão,"
+ "\ncontador, contador de clicks, guest book, estatísticas e rotação"
+ "\nde banner interno."
+ "\n\nUm site totalmente desenvolvido para você adicionar diversos"
+ "\nconteúdos, inteiramente gratuitos, à sua pagina de internet."

+ "\nAcesse nosso site, cadastre-se gratuitamente, e aproveite as"
+ "\nvantagens que o recursos web disponibiliza para você."
+ "\n\n\n----------------------"
+ "\nOBS: Esta mensagem não é um spam, visto que somente estará sendo" 
+ "\nenviado uma única vez, e também contém uma forma de ser removida,"
+ "\né um e-mail normal como tantos outros que você recebe, não estamos"
+ "\ninvadindo sua privacidade e enviar um e-mail não é crime, desde que"
+ "\nnão contenha mensagens que possam causar danos ao usuário. Caso" 
+ "\nqueria remover seu endereço de nossa lista, basta enviar um e-mail"
+ "\n+para excluame@recursosweb.net com o titulo (assunto) remover, que seu"
+ "\ne-mail será removido de nossa lista definitivamente.Desculpe-nos"
+ "\ncaso tenhamos lhe importunado com nosso e-mail de divulgação."
+ "\nObrigado!";
	private static String emailSubjectTxt = "Grátis - Você tem um site/blog/flog???";
	private static String emailFromAddress = "makingsp2@gmail.com";
	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	private String[] sendTo = { "contato@fabricasolucoes.com" };
	private String login;
	private String senha;
	public void setLogin(String x) {
		this.login = x;
	}
	public void setSenha(String x) {
		this.senha = x;
	}
	public void setEmailSubject(String x) {
		emailSubjectTxt = x;
	}
	public void setEmailFromAddress(String x) {
		emailFromAddress = x;
	}
	public void setEnds(String[] ends) {
		sendTo = ends;
	}
	public void setEmailMsgTxt(String x) {
		emailMsgTxt = x;
	}
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}

	public void main(String args[]) throws Exception {

		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		for (String k : sendTo) {
			System.out.println(k);
		}
		new Tester().sendSSLMessage(sendTo, emailSubjectTxt, emailMsgTxt,
				emailFromAddress,login,senha);
		System.out.println("Sucessfully Sent mail to All Users");
	}

	public void sendSSLMessage(String recipients[], String subject,
			String message, String from, final String login, final String senha) throws MessagingException {
		boolean debug = true;

		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(login, senha);
					}
				});

		session.setDebug(debug);

		Message msg = new MimeMessage(session);
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);

		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/plain");
		Transport.send(msg);
	}
	
}
