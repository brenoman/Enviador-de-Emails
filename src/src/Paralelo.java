package src;

public class Paralelo implements Runnable {
	private String[] ends;
	private Gui monitor;
	private String emailSubjectTxt;
	private String emailFromAddress;
	private String emailMsgTxt;
	private String login;
	private String senha;
	
	public void setLogin(String login) {
		this.login = login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Paralelo(Gui monitor) {
		this.monitor = monitor;
	}
	public void setEmailSubject(String x) {
		emailSubjectTxt = x;
	}
	public void setEmailFromAddress(String x) {
		emailFromAddress = x;
	}
	public void setEnds(String[] ends) {
		this.ends = ends;
	}
	public void setEmailMsgTxt(String x) {
		emailMsgTxt = x;
	}
	public void run() {
		Tester c = new Tester();
		c.setEnds(ends);
		c.setEmailFromAddress(emailFromAddress);
		c.setEmailMsgTxt(emailMsgTxt);
		c.setLogin(login);
		c.setSenha(senha);
		c.setEmailSubject(emailSubjectTxt);
		try {
			c.main(ends);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (monitor) {
			monitor.setContador(monitor.getContador()-1);
			monitor.notifyAll();
			
		}
	}

}
