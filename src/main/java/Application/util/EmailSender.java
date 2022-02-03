package Application.util;
import java.util.Properties;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Classe per la generazione e l'invio di un email
 */
public class EmailSender {

    /**
     * Rappresenta l'unica istanza di EmailSender
     */
    private static EmailSender instance;

    /**
     * Costruttore di EmailSender
     */
    private EmailSender(){
        this(EmailSender.EMAIL, EmailSender.PASSWORD);
    }

    /**
     * Metodo per ottenere un'istanza di EmailSender.
     * @return l'istanza di EmailSender.
     */
    public static EmailSender GetInstance(){
        if(instance == null)
            instance = new EmailSender();

        return instance;
    }

    /**
     * Costruttore di EmailSender
     * @param email email del account di UniNotes.
     * @param password password del account di UniNotes.
     */
    private EmailSender(String email, String password){
        this.email = email;
        this.password = password;

        this.emailProperties = System.getProperties();
        this.emailProperties.setProperty("mail.smtp.starttls.enable", "true");
        this.emailProperties.setProperty("mail.smtp.host", SMTP_HOST);
        this.emailProperties.setProperty("mail.smtp.user", this.email);
        this.emailProperties.setProperty("mail.smtp.password", this.password);
        this.emailProperties.setProperty("mail.smtp.port", SMTP_PORT);
        this.emailProperties.setProperty("mail.smtp.auth", "true");
    }

    /**
     * Metodo per mandare un'email.
     * @param email_subject Oggetto dell'email.
     * @param email_message Messaggio da inviare.
     * @param addressList Indirizzo email dove inviare l'email.
     * @return true se l'email è stata inviata, false altrimenti.
     */
    public boolean SendEmail(String email_subject, String email_message, String addressList)
    {
        try {
            InternetAddress[] mailAddress = InternetAddress.parse(addressList);
            return SendEmail(email_subject, email_message, mailAddress);
        } catch (AddressException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo per mandare un'email.
     * @param email_subject Oggetto dell'email.
     * @param email_message Messaggio da inviare.
     * @param address Lista di indirizzi email dove inviare l'email.
     * @return true se l'email è stata inviata, false altrimenti.
     */
    public boolean SendEmail(String email_subject, String email_message, InternetAddress[] address){
        Session session = Session.getInstance(this.emailProperties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(this.email));
            message.addRecipients(Message.RecipientType.TO, address);
            message.setSubject(email_subject);
            message.setText(email_message);

            Transport transport = session.getTransport("smtp");
            transport.connect(SMTP_HOST, this.email, this.password);
            transport.sendMessage(message, message.getAllRecipients());

            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String email;
    private String password;

    private Properties emailProperties;

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";
    private static final String EMAIL = "email@email.com";
    private static final String PASSWORD = "pss";
}