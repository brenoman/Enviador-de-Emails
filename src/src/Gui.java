package src;

import src.*;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class Gui extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JList listaEmails;
	private JButton btEscolha;
	private JTextArea textArea;
	private JButton enviar;
	private JTextField assunto;
	private JTextArea mensagem;
	private JFileChooser escolhedorArquivo;
	private ArrayList<String> listaPrincipal = new ArrayList();
	private int contador = 0;
	private JScrollBar jScrollBar1;
	private int emailsenviados = 0;
	private JScrollPane scroll;
	private JScrollPane scrollMensagem;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JTextField txtSenha;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JTextField txtDe;
	private JTextField senhaConta2;
	private JTextField loginConta2;
	private JTextField loginConta1;
	private JLabel jLabel1;
	private Container c = getContentPane();

	public synchronized void setContador(int cont) {
		contador = cont;

	}

	public synchronized int getContador() {
		return contador;

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Gui inst = new Gui();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Gui() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Enviador de Emails Tabajara 0.1b");
			{
				scrollMensagem = new JScrollPane();
				getContentPane().add(scrollMensagem);
				scrollMensagem.setBounds(331, 85, 400, 350);
				{
					mensagem = new JTextArea();
					scrollMensagem.setViewportView(mensagem);
				}
			}
			{
				scroll = new JScrollPane();
				getContentPane().add(scroll);
				scroll.setBounds(9, 20, 300, 450);
				{
					ListModel listaEmailsModelx = new DefaultComboBoxModel(
							new String[] {});
					listaEmails = new JList();
					scroll.setViewportView(listaEmails);
					listaEmails.setModel(listaEmailsModelx);
				}
			}
			{
				btEscolha = new JButton();
				getContentPane().add(btEscolha);
				btEscolha.setText("Escolher Arquivo...");
				btEscolha.setBounds(360, 448, 150, 21);
				btEscolha.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						// escolhe o arquivo
						int returnVal = escolhedorArquivo
								.showOpenDialog(getContentPane());
						// passa a lista pra outra classe que vai processar e
						// receber o arraylist
						Leitor c = new Leitor();
						ArrayList<String> lista = new ArrayList(
								(ArrayList<String>) c.leia(escolhedorArquivo
										.getSelectedFile()));
						String[] StringLista = new String[lista.size()];
						int i = 0;
						for (String x : lista) {
							StringLista[i++] = x;
						}
						textArea.append("carregou");
						ListModel listaEmailsModel = new DefaultComboBoxModel(
								StringLista);
						listaEmails.setModel(listaEmailsModel);
						listaPrincipal = lista;

						/*
						 * scroll = new JScrollPane(listaEmails);
						 * getContentPane().add(scroll); scroll.setBounds(148,
						 * 19, 18, 200); setSize(350, 250); setVisible(true);
						 */
					}
				});
			}
			{
				textArea = new JTextArea();
				textArea.setLineWrap(true);
				getContentPane().add(textArea);
				JScrollPane spDescricao = new JScrollPane(textArea); // Adiciona
				// Scroll
				// a
				// TextArea
				this.getContentPane().add(spDescricao); // Adiciona a Scroll ao
				// Frame
				textArea.setBounds(16, 92, 149, 135);
			}
			{
				enviar = new JButton();
				getContentPane().add(enviar);
				enviar.setText("Enviar");
				enviar.setBounds(515, 448, 100, 21);
				enviar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						enviar();
					}
				});
			}
			
			{
				assunto = new JTextField();
				c.add(assunto);
				assunto.setBounds(331, 39, 250, 21);
			}
			{
				escolhedorArquivo = new JFileChooser();
				c.add(escolhedorArquivo);
				escolhedorArquivo.setBounds(-500, -30, 500, 326);
			}
			{
				jLabel1 = new JLabel();
				c.add(jLabel1);
				jLabel1.setText("Assunto");
				jLabel1.setBounds(331, 20, 39, 14);
			}
			{
				jLabel2 = new JLabel();
				c.add(jLabel2);
				jLabel2.setText("Mensagem");
				jLabel2.setBounds(331, 66, 51, 14);
			}
			{
				jLabel3 = new JLabel();
				c.add(jLabel3);
				jLabel3.setText("Contas");
				jLabel3.setBounds(769, 20, 34, 14);
			}
			{
				jLabel4 = new JLabel();
				c.add(jLabel4);
				jLabel4.setText("Conta 1:");
				jLabel4.setBounds(789, 40, 42, 14);
			}
			{
				loginConta1 = new JTextField();
				c.add(loginConta1);
				loginConta1.setBounds(789, 60, 150, 21);
			}
			{
				txtSenha = new JTextField();
				c.add(txtSenha);
				txtSenha.setBounds(789, 87, 150, 21);
			}
			{
				jLabel5 = new JLabel();
				c.add(jLabel5);
				jLabel5.setText("Conta2:");
				jLabel5.setBounds(789, 114, 40, 14);
			}
			{
				loginConta2 = new JTextField();
				c.add(loginConta2);
				loginConta2.setBounds(789, 134, 150, 21);
			}
			{
				senhaConta2 = new JTextField();
				c.add(senhaConta2);
				senhaConta2.setBounds(789, 161, 150, 21);
			}
			{
				txtDe = new JTextField();
				c.add(txtDe);
				txtDe.setBounds(626, 37, 100, 21);
			}
			{
				jLabel6 = new JLabel();
				c.add(jLabel6);
				jLabel6.setText("De:");
				jLabel6.setBounds(626, 18, 17, 14);
			}

			pack();
			this.setSize(1024, 515);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enviar() {
		int x = 0;
		int counter=0;
		String[] to = new String[100];
		System.out.println("ta indo");
		for (String i : listaPrincipal) {
			if (i != null)
				to[x] = i + ",";
			else
				continue;
			if (x++ == 99) {
				x = 0;
				if (getContador() < 1) {
					try {
						Paralelo r = new Paralelo(this);
						r.setEnds(to);
						r.setEmailFromAddress(txtDe.getText());
						r.setEmailMsgTxt(mensagem.getText());
						r.setEmailSubject(assunto.getText());
						if (counter++%2 == 0) {
							System.out.println(counter + "\n\n\n\n\n\n\n");
							r.setLogin(loginConta1.getText());
							r.setSenha(txtSenha.getText());
						}
						else {
							r.setLogin(loginConta2.getText());
							r.setSenha(senhaConta2.getText());
						}
						Thread paral = new Thread(r);
						paral.start();
						setContador(getContador() + 1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {

					synchronized (this) {
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			}
		}
	}

}
