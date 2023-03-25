package br.edu.fatec.Tela;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import br.edu.fatec.Candidatos.Candidato;

public class Tela {
		
    //DEFININDO TODAS AS VARIAVEIS QUE VAO SER UTILIZADAS
	private JFrame tela;
	
	private File dir;
	private File arq;

	private JLabel txtNulo, txtBranco;
	private JLabel candi1, candi2, candi3, candi4, candi5, candi6, candi7, candi8, candi9, candi10;
	private JLabel nCandi1, nCandi2, nCandi3, nCandi4, nCandi5, nCandi6, nCandi7, nCandi8, nCandi9, nCandi10;	
	private JLabel partido1, partido2, partido3, partido4, partido5, partido6, partido7, partido8, partido9, partido10;
	private JLabel nome1, nome2, nome3, nome4, nome5, nome6, nome7, nome8, nome9, nome10;
	private JLabel img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, simbolo;
	private JLabel n1, n2, n3, n4, n5, n6, n7, n8, n9, n10;	
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, corrige, branco, confirmar;
	private JPanel painel1;
	public JTextField num, num2;

	public int votosHomAra = 0, votosCapAme = 0, votosDead = 0, votosDouEstr = 0, votosFeiti = 0, votosHomFer = 0,
			votosHulk = 0, votosPanNeg = 0, votosThor = 0, votosViuva = 0, VotosTotais = 0, VotosBrancos = 0;
	
	public int vencedor = 0;
	
	//GETTERS DOS VOTOS TOTAIS E BRANCOS
	public int getVotosTotais() {
		return VotosTotais;
	}
	
	public int getVotosBrancos() {
		return VotosBrancos;
	}
		
	 public JLabel getSimbolo() {
		simbolo = new JLabel(Simbolo);			
		simbolo.setBounds(650, 0, 450, 150);
		simbolo.setVisible(true);
		return simbolo;
	}

	void AudioAcerto() {
	        try {
	        	URL url =(getClass().getResource("/Sons/barulho urna.wav"));
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
	            Clip clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	            clip.start();
	            clip.loop(0); 
	        } catch (Exception ex) {
	            System.out.println("Erro ao executar SOM!");
	            ex.printStackTrace();
	        }
	    }
			
	public JLabel getTxtNulo() {
		txtNulo = new JLabel();
		txtNulo.setText("Voto Nulo");		
		txtNulo.setBounds(270, 410, 250, 100);
		txtNulo.setFont(new Font("", Font.PLAIN, 45));
		txtNulo.setVisible(false);
		return txtNulo;
	}

	public JLabel getTxtBranco() {
		txtBranco = new JLabel();
		txtBranco.setText("Voto em Branco");		
		txtBranco.setBounds(130, 460, 500, 100);
		txtBranco.setFont(new Font("", Font.PLAIN, 55));
		txtBranco.setVisible(false);

		return txtBranco;
	}

	//ADD TODOS OBJETOS QUE VAO SER UTILIZADOS
	Candidato Homem_Aranha = new Candidato("Homem-Aranha", "PT", 13);
	Candidato Capitao_America = new Candidato("Capitão-America", "MDB", 15);
	Candidato deadpool = new Candidato("Deadpool", "PCB", 21);
	Candidato Dr_Estranho = new Candidato("Doutor-Estranho", "PSB", 40);
	Candidato Feiticeira_Escarlate = new Candidato("Feiticeira-Escarlate", "PMB", 35);
	Candidato Homem_De_Ferro = new Candidato("Homem-De-Ferro", "PL", 22);
	Candidato Hulk = new Candidato("Hulk", "PSDB", 45);
	Candidato Pantera_Negra = new Candidato("Pantera-Negra", "UNIÃO", 44);
	Candidato Thor = new Candidato("Thor", "DC", 27);
	Candidato Viuva_Negra = new Candidato("Viuva-Negra", "PSOL", 50);
	
	//ADD OS OBJETOS EM UM VETOR
	Candidato candidatos[] = { Homem_Aranha,Capitao_America,deadpool,Dr_Estranho,Feiticeira_Escarlate,Homem_De_Ferro,Hulk,Pantera_Negra,Thor,Viuva_Negra };

	//DEFININDO AS IMAGENS QUE SERAO VISIVEIS NA TELA
	ImageIcon image1 = new ImageIcon(getClass().getResource("/Imagens/homem-aranha (2).jpg"));
	ImageIcon image2 = new ImageIcon(getClass().getResource("/Imagens/capitao-america (2).jpg"));
	ImageIcon image3 = new ImageIcon(getClass().getResource("/Imagens/deadpool (2).jpg"));
	ImageIcon image4 = new ImageIcon(getClass().getResource("/Imagens/doutor-estranho (2).jpg"));
	ImageIcon image5 = new ImageIcon(getClass().getResource("/Imagens/feiticeira escarlate (2).jpg"));
	ImageIcon image6 = new ImageIcon(getClass().getResource("/Imagens/homem-de-ferro (2).jpg"));
	ImageIcon image7 = new ImageIcon(getClass().getResource("/Imagens/hulk (2).jpg"));
	ImageIcon image8 = new ImageIcon(getClass().getResource("/Imagens/pantera-negra (2).jpg"));
	ImageIcon image9 = new ImageIcon(getClass().getResource("/Imagens/thor (2).jpg"));
	ImageIcon image10 = new ImageIcon(getClass().getResource("/Imagens/viuva-negra (2).jpg"));
	ImageIcon Simbolo = new ImageIcon(getClass().getResource("/Imagens/Simbolo.jpg"));
	
	//DEFINIDO AS IMAGENS QUE APARECERÃO DEPOIS DO DIGITO
	ImageIcon ImgCand1 = new ImageIcon(getClass().getResource("/Imagens/homem-aranha.jpg"));
	ImageIcon ImgCand2 = new ImageIcon(getClass().getResource("/Imagens/capAme.jpg"));
	ImageIcon ImgCand3 = new ImageIcon(getClass().getResource("/Imagens/deadpool.jpg"));
	ImageIcon ImgCand4 = new ImageIcon(getClass().getResource("/Imagens/doutor-estranho.jpg"));
	ImageIcon ImgCand5 = new ImageIcon(getClass().getResource("/Imagens/feiticeira escarlate.jpg"));
	ImageIcon ImgCand6 = new ImageIcon(getClass().getResource("/Imagens/homem-de-ferro.jpg"));
	ImageIcon ImgCand7 = new ImageIcon(getClass().getResource("/Imagens/hulk.jpg"));
	ImageIcon ImgCand8 = new ImageIcon(getClass().getResource("/Imagens/pantera-negra.jpg"));
	ImageIcon ImgCand9 = new ImageIcon(getClass().getResource("/Imagens/thor.jpg"));
	ImageIcon ImgCand10 = new ImageIcon(getClass().getResource("/Imagens/viuva-negra.jpg"));
	
    //METODO PARA ADICIONAR AS IMAGENS QUE SERAO VISIVEIS
	public JLabel getImg(JLabel label, ImageIcon image, int x, int y) {
		label = new JLabel(image);
		label.setBounds(x, y, 100, 100);
		label.setVisible(true);
		return label;
	}

	//METODOS PARA AS IMAGENS QUE APARECERÃO DEPOIS DO DIGITO
	public JLabel getCandi1(int x, int y) {
		candi1 = new JLabel(ImgCand1);
		Border border = BorderFactory.createLineBorder(Color.black, 5);
		candi1.setBorder(border);
		candi1.setBounds(472, 400, x, y);
		candi1.setVisible(false);
		return candi1;
	}

	public JLabel getCandi2(int x, int y) {
		candi2= new JLabel(ImgCand2);
		Border border = BorderFactory.createLineBorder(Color.black, 5);
		candi2.setBorder(border);
		candi2.setBounds(472, 400, x, y);
		candi2.setVisible(false);
		return candi2;
	}

	public JLabel getCandi3(int x, int y) {
		candi3 = new JLabel(ImgCand3);
		Border border = BorderFactory.createLineBorder(Color.black, 5);
		candi3.setBorder(border);
		candi3.setBounds(472, 400, x, y);
		candi3.setVisible(false);
		return candi3;
	}

	public JLabel getCandi4(int x, int y) {
		candi4 = new JLabel(ImgCand4);
		Border border = BorderFactory.createLineBorder(Color.black, 5);
		candi4.setBorder(border);
		candi4.setBounds(472, 400, x, y);
		candi4.setVisible(false);
		return candi4;
	}

	public JLabel getCandi5(int x, int y) {
		candi5 = new JLabel(ImgCand5);
		Border border = BorderFactory.createLineBorder(Color.black, 5);
		candi5.setBorder(border);
		candi5.setBounds(472, 400, x, y);
		candi5.setVisible(false);
		return candi5;
	}

	public JLabel getCandi6(int x, int y) {
		candi6 = new JLabel(ImgCand6);
		Border border = BorderFactory.createLineBorder(Color.black, 5);
		candi6.setBorder(border);
		candi6.setBounds(472, 400, x, y);
		candi6.setVisible(false);
		return candi6;
	}

	public JLabel getCandi7(int x, int y) {
		candi7 = new JLabel(ImgCand7);
		Border border = BorderFactory.createLineBorder(Color.black, 5);
		candi7.setBorder(border);
		candi7.setBounds(472, 400, x, y);
		candi7.setVisible(false);
		return candi7;
	}

	public JLabel getCandi8(int x, int y) {
		candi8 = new JLabel(ImgCand8);
		Border border = BorderFactory.createLineBorder(Color.black, 5);
		candi8.setBorder(border);
		candi8.setBounds(472, 400, x, y);
		candi8.setVisible(false);
		return candi8;
	}

	public JLabel getCandi9(int x, int y) {
		candi9 = new JLabel(ImgCand9);
		Border border = BorderFactory.createLineBorder(Color.black, 5);
		candi9.setBorder(border);
		candi9.setBounds(472, 400, x, y);
		candi9.setVisible(false);
		return candi9;
	}

	public JLabel getCandi10(int x, int y) {
		candi10 = new JLabel(ImgCand10);
		Border border = BorderFactory.createLineBorder(Color.black, 5);
		candi10.setBorder(border);
		candi10.setBounds(472, 400, x, y);
		candi10.setVisible(false);
		return candi10;
	}

	//METODO PARA ADICIONAR OS NUMEROS QUE SERAO VISIVEIS
	public JLabel getN1(JLabel label, int i, int x, int y) {
		label = new JLabel();
		label.setText("" + candidatos[i].getNumero());		
		label.setBounds(x, y, 70, 70);
		label.setFont(new Font("", Font.PLAIN, 25));
		return label;
	}

	//METODOS PARA ADICIONAR OS NUMEROS QUE SERAO VISIVEIS APOS O DIGITO
	public JLabel getnCandi1() {
		nCandi1 = new JLabel();
		nCandi1.setText("Número: " + candidatos[0].getNumero());		
		nCandi1.setBounds(200, 370, 160, 100);
		nCandi1.setFont(new Font("", Font.PLAIN, 30));
		nCandi1.setVisible(false);
		return nCandi1;
	}

	public JLabel getnCandi2() {
		nCandi2 = new JLabel();
		nCandi2.setText("Número: " + candidatos[1].getNumero());		
		nCandi2.setBounds(200, 370, 160, 100);
		nCandi2.setFont(new Font("", Font.PLAIN, 30));
		nCandi2.setVisible(false);
		return nCandi2;
	}

	public JLabel getnCandi3() {
		nCandi3 = new JLabel();
		nCandi3.setText("Número: " + candidatos[2].getNumero());		
		nCandi3.setBounds(200, 370, 160, 100);
		nCandi3.setFont(new Font("", Font.PLAIN, 30));
		nCandi3.setVisible(false);
		return nCandi3;
	}

	public JLabel getnCandi4() {
		nCandi4 = new JLabel();
		nCandi4.setText("Número: " + candidatos[3].getNumero());		
		nCandi4.setBounds(200, 370, 160, 100);
		nCandi4.setFont(new Font("", Font.PLAIN, 30));
		nCandi4.setVisible(false);
		return nCandi4;
	}

	public JLabel getnCandi5() {
		nCandi5 = new JLabel();
		nCandi5.setText("Número: " + candidatos[4].getNumero());		
		nCandi5.setBounds(200, 370, 160, 100);
		nCandi5.setFont(new Font("", Font.PLAIN, 30));
		nCandi5.setVisible(false);
		return nCandi5;
	}

	public JLabel getnCandi6() {
		nCandi6 = new JLabel();
		nCandi6.setText("Número: " + candidatos[5].getNumero());		
		nCandi6.setBounds(200, 370, 160, 100);
		nCandi6.setFont(new Font("", Font.PLAIN, 30));
		nCandi6.setVisible(false);
		return nCandi6;
	}

	public JLabel getnCandi7() {
		nCandi7 = new JLabel();
		nCandi7.setText("Número: " + candidatos[6].getNumero());		
		nCandi7.setBounds(200, 370, 160, 100);
		nCandi7.setFont(new Font("", Font.PLAIN, 30));
		nCandi7.setVisible(false);
		return nCandi7;
	}

	public JLabel getnCandi8() {
		nCandi8 = new JLabel();
		nCandi8.setText("Número: " + candidatos[7].getNumero());		
		nCandi8.setBounds(200, 370, 160, 100);
		nCandi8.setFont(new Font("", Font.PLAIN, 30));
		nCandi8.setVisible(false);
		return nCandi8;
	}

	public JLabel getnCandi9() {
		nCandi9 = new JLabel();
		nCandi9.setText("Número: " + candidatos[8].getNumero());		
		nCandi9.setBounds(200, 370, 160, 100);
		nCandi9.setFont(new Font("", Font.PLAIN, 30));
		nCandi9.setVisible(false);
		return nCandi9;
	}

	public JLabel getnCandi10() {
		nCandi10 = new JLabel();
		nCandi10.setText("Número: " + candidatos[9].getNumero());		
		nCandi10.setBounds(200, 370, 160, 100);
		nCandi10.setFont(new Font("", Font.PLAIN, 30));
		nCandi10.setVisible(false);
		return nCandi10;
	}

	//METODOS PARA ADICIONAR OS NOMES DOS PARTIDOS QUE SERAO VISIVEIS APOS O DIGITO
	public JLabel getPartido1() {
		partido1 = new JLabel();
		partido1.setText("Partido: " + candidatos[0].getPartido());		
		partido1.setBounds(200, 410, 190, 100);
		partido1.setFont(new Font("", Font.PLAIN, 30));
		partido1.setVisible(false);
		
		return partido1;
	}

	public JLabel getPartido2() {
		partido2 = new JLabel();
		partido2.setText("Partido: " + candidatos[1].getPartido());		
		partido2.setBounds(200, 410, 190, 100);
		partido2.setFont(new Font("", Font.PLAIN, 30));
		partido2.setVisible(false);
		return partido2;
	}

	public JLabel getPartido3() {
		partido3 = new JLabel();
		partido3.setText("Partido: " + candidatos[2].getPartido());		
		partido3.setBounds(200, 410, 190, 100);
		partido3.setFont(new Font("", Font.PLAIN, 30));
		partido3.setVisible(false);
		return partido3;
	}

	public JLabel getPartido4() {
		partido4 = new JLabel();
		partido4.setText("Partido: " + candidatos[3].getPartido());		
		partido4.setBounds(200, 410, 190, 100);
		partido4.setFont(new Font("", Font.PLAIN, 30));
		partido4.setVisible(false);
		return partido4;
	}

	public JLabel getPartido5() {
		partido5 = new JLabel();
		partido5.setText("Partido: " + candidatos[4].getPartido());		
		partido5.setBounds(200, 410, 190, 100);
		partido5.setFont(new Font("", Font.PLAIN, 30));
		partido5.setVisible(false);
		return partido5;
	}

	public JLabel getPartido6() {
		partido6 = new JLabel();
		partido6.setText("Partido: " + candidatos[5].getPartido());		
		partido6.setBounds(200, 410, 190, 100);
		partido6.setFont(new Font("", Font.PLAIN, 30));
		partido6.setVisible(false);
		return partido6;
	}

	public JLabel getPartido7() {
		partido7 = new JLabel();
		partido7.setText("Partido: " + candidatos[6].getPartido());		
		partido7.setBounds(200, 410, 210, 100);
		partido7.setFont(new Font("", Font.PLAIN, 30));
		partido7.setVisible(false);
		return partido7;
	}

	public JLabel getPartido8() {
		partido8 = new JLabel();
		partido8.setText("Partido: " + candidatos[7].getPartido());		
		partido8.setBounds(200, 410, 210, 100);
		partido8.setFont(new Font("", Font.PLAIN, 30));
		partido8.setVisible(false);
		return partido8;
	}

	public JLabel getPartido9() {
		partido9 = new JLabel();
		partido9.setText("Partido: " + candidatos[8].getPartido());		
		partido9.setBounds(200, 410, 190, 100);
		partido9.setFont(new Font("", Font.PLAIN, 30));
		partido9.setVisible(false);
		return partido9;
	}

	public JLabel getPartido10() {
		partido10 = new JLabel();
		partido10.setText("Partido: " + candidatos[9].getPartido());		
		partido10.setBounds(200, 410, 190, 100);
		partido10.setFont(new Font("", Font.PLAIN, 30));
		partido10.setVisible(false);
		return partido10;
	}

	//METODOS PARA ADICIONAR OS NOMES DOS CANDIDATOS QUE SERAO VISIVEIS APOS O DIGITO
	public JLabel getNome1() {
        nome1 = new JLabel();
        nome1.setText("Nome: " + candidatos[0].getNome());		
        nome1.setBounds(200, 450, 300, 100);
		nome1.setFont(new Font("", Font.PLAIN, 25));
		nome1.setVisible(false);
		return nome1;
	}

	public JLabel getNome2() {
		nome2 = new JLabel();
        nome2.setText("Nome: " + candidatos[1].getNome());		
        nome2.setBounds(200, 450, 300, 100);
		nome2.setFont(new Font("", Font.PLAIN, 25));
		nome2.setVisible(false);
		
		return nome2;
	}

	public JLabel getNome3() {
		nome3 = new JLabel();
        nome3.setText("Nome: " + candidatos[2].getNome());		
        nome3.setBounds(200, 450, 300, 100);
		nome3.setFont(new Font("", Font.PLAIN, 25));
		nome3.setVisible(false);
		return nome3;
	}

	public JLabel getNome4() {
		nome4 = new JLabel();
        nome4.setText("Nome: " + candidatos[3].getNome());		
        nome4.setBounds(200, 450, 300, 100);
		nome4.setFont(new Font("", Font.PLAIN, 25));
		nome4.setVisible(false);
		return nome4;
	}

	public JLabel getNome5() {
		nome5 = new JLabel();
        nome5.setText("Nome: " + candidatos[4].getNome());		
        nome5.setBounds(200, 450, 300, 100);
		nome5.setFont(new Font("", Font.PLAIN, 20));
		nome5.setVisible(false);
		return nome5;
	}

	public JLabel getNome6() {
		nome6 = new JLabel();
        nome6.setText("Nome: " + candidatos[5].getNome());		
        nome6.setBounds(200, 450, 300, 100);
		nome6.setFont(new Font("", Font.PLAIN, 20));
		nome6.setVisible(false);
		return nome6;
	}

	public JLabel getNome7() {
		nome7 = new JLabel();
        nome7.setText("Nome: " + candidatos[6].getNome());		
        nome7.setBounds(200, 450, 300, 100);
		nome7.setFont(new Font("", Font.PLAIN, 25));
		nome7.setVisible(false);
		return nome7;
	}

	public JLabel getNome8() {
		nome8 = new JLabel();
        nome8.setText("Nome: " + candidatos[7].getNome());		
        nome8.setBounds(200, 450, 300, 100);
		nome8.setFont(new Font("", Font.PLAIN, 25));
		nome8.setVisible(false);
		return nome8;
	}

	public JLabel getNome9() {
		nome9 = new JLabel();
        nome9.setText("Nome: " + candidatos[8].getNome());		
        nome9.setBounds(200, 450, 300, 100);
		nome9.setFont(new Font("", Font.PLAIN, 25));
		nome9.setVisible(false);
		return nome9;
	}

	public JLabel getNome10() {
		nome10 = new JLabel();
        nome10.setText("Nome: " + candidatos[9].getNome());		
        nome10.setBounds(200, 450, 300, 100);
		nome10.setFont(new Font("", Font.PLAIN, 25));
		nome10.setVisible(false);
		return nome10;
	}

	
	
	//ADD OS BOTOES DO TECLADOS E ALGUMAS AÇOES DOS MESMO
	// B0
	public JButton getB0() {
		b0 = new JButton("0");
		b0.setBounds(840, 402, 70, 60);
		b0.setBackground(Color.black);
		b0.setForeground(Color.WHITE);
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.getText().length() == 2) {
					return;
				} else
					num.setText(num.getText() + "0");				
				int a = Integer.parseInt(num.getText());
				if (a == 40) {
					candi4.setVisible(true);
					nCandi4.setVisible(true);
					nome4.setVisible(true);
					partido4.setVisible(true);
					
				}
				else if (a == 50) {
					candi10.setVisible(true);
					nCandi10.setVisible(true);
					nome10.setVisible(true);
					partido10.setVisible(true);					
				}
				else if(a == 0) {
					txtNulo.setVisible(true);
				}
				else if(a == 10) {
					txtNulo.setVisible(true);
				}else if(a==20) {
					txtNulo.setVisible(true);
				}else if(a == 30) {
					txtNulo.setVisible(true);
				}else if(a == 60) {
					txtNulo.setVisible(true);
				}else if(a == 70) {
					txtNulo.setVisible(true);
				}else if(a == 80) {
					txtNulo.setVisible(true);
				}else if(a == 90) {
					txtNulo.setVisible(true);
				}
			}
		};
		b0.addActionListener(listener);
		return b0;
	}

	// B1
	public JButton getB1() {
		b1 = new JButton("1");
		b1.setBounds(750, 165, 70, 60);
		b1.setBackground(Color.black);
		b1.setForeground(Color.WHITE);
		b1.setFocusable(false);
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.getText().length() == 2) {
					return;
				} else
					num.setText(num.getText() + "1");			
				int a = Integer.parseInt(num.getText());
				if (a == 21) {
					candi3.setVisible(true);
					nCandi3.setVisible(true);
					nome3.setVisible(true);
					partido3.setVisible(true);					
				}else if(a == 11) {
					txtNulo.setVisible(true);
				}else if(a == 31) {
					txtNulo.setVisible(true);
				}else if(a == 41) {
					txtNulo.setVisible(true);
				}else if(a == 51) {
					txtNulo.setVisible(true);
				}else if(a == 61) {
					txtNulo.setVisible(true);
				}else if(a == 71) {
					txtNulo.setVisible(true);
				}else if(a == 81) {
					txtNulo.setVisible(true);
				}else if(a == 91) {
					txtNulo.setVisible(true);
				}
			}
		};
		b1.addActionListener(listener);
		return b1;
	}
	// B2
	public JButton getB2() {
		b2 = new JButton("2");
		b2.setBounds(840, 165, 70, 60);
		b2.setBackground(Color.black);
		b2.setForeground(Color.WHITE);
		b2.setFocusable(false);
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.getText().length() == 2) {
					return;
				} else
					num.setText(num.getText() + "2");				
				int a = Integer.parseInt(num.getText());
				if (a == 22) {
					candi6.setVisible(true);
					nCandi6.setVisible(true);
					nome6.setVisible(true);
					partido6.setVisible(true);					
				}else if(a == 12) {
					txtNulo.setVisible(true);
				}else if(a == 32) {
					txtNulo.setVisible(true);
				}else if(a == 42) {
					txtNulo.setVisible(true);
				}else if(a == 52) {
					txtNulo.setVisible(true);
				}else if(a == 62) {
					txtNulo.setVisible(true);
				}else if(a == 72) {
					txtNulo.setVisible(true);
				}else if(a == 82) {
					txtNulo.setVisible(true);
				}else if(a == 92) {
					txtNulo.setVisible(true);
				}
			}
		};
		b2.addActionListener(listener);
		return b2;
	}
	// B3
	public JButton getB3() {
		b3 = new JButton("3");
		b3.setBounds(930, 165, 70, 60);
		b3.setBackground(Color.black);
		b3.setForeground(Color.WHITE);
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.getText().length() == 2) {
					return;
				} else
					num.setText(num.getText() + "3");
				int a = Integer.parseInt(num.getText());
				if (a == 13) {
					candi1.setVisible(true);
					nCandi1.setVisible(true);
					nome1.setVisible(true);
					partido1.setVisible(true);					
				}else if(a == 23) {
					txtNulo.setVisible(true);
				}else if(a == 33) {
					txtNulo.setVisible(true);
				}else if(a == 43) {
					txtNulo.setVisible(true);
				}else if(a == 53) {
					txtNulo.setVisible(true);
				}else if(a == 63) {
					txtNulo.setVisible(true);
				}else if(a == 73) {
					txtNulo.setVisible(true);
				}else if(a == 83) {
					txtNulo.setVisible(true);
				}else if(a == 93) {
					
				}
			}
		};
		b3.addActionListener(listener);
		return b3;
	}

	// B4
	public JButton getB4() {
		b4 = new JButton("4");
		b4.setBounds(750, 243, 70, 60);
		b4.setBackground(Color.black);
		b4.setForeground(Color.WHITE);
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.getText().length() == 2) {
					return;
				} else
					num.setText(num.getText() + "4");
				int a = Integer.parseInt(num.getText());
				if (a == 44) {
					candi8.setVisible(true);
					nCandi8.setVisible(true);
					nome8.setVisible(true);
					partido8.setVisible(true);					
				}else if(a == 14) {
					txtNulo.setVisible(true);
				}else if(a == 24) {
					txtNulo.setVisible(true);
				}else if(a == 34) {
					txtNulo.setVisible(true);
				}else if(a == 54) {
					txtNulo.setVisible(true);
				}else if(a == 64) {
					txtNulo.setVisible(true);
				}else if(a == 74) {
					txtNulo.setVisible(true);
				}else if(a == 84) {
					txtNulo.setVisible(true);
				}else if(a == 94) {
					txtNulo.setVisible(true);
				}
			}
		};
		b4.addActionListener(listener);
		return b4;
	}

	// B5
	public JButton getB5() {
		b5 = new JButton("5");
		b5.setBounds(840, 243, 70, 60);
		b5.setBackground(Color.black);
		b5.setForeground(Color.WHITE);
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.getText().length() == 2) {
					return;
				} else
					num.setText(num.getText() + "5");				
				int a = Integer.parseInt(num.getText());
				if (a == 15) {
					candi2.setVisible(true);
					nCandi2.setVisible(true);
					nome2.setVisible(true);
					partido2.setVisible(true);					
				}else if(a == 35) {
					candi5.setVisible(true);
					nCandi5.setVisible(true);
					nome5.setVisible(true);
					partido5.setVisible(true);					
				}else if(a == 45) {
					candi7.setVisible(true);
					nCandi7.setVisible(true);
					nome7.setVisible(true);
					partido7.setVisible(true);					
				}else if(a == 25) {
					txtNulo.setVisible(true);
				}else if(a == 55) {
					txtNulo.setVisible(true);
				}else if(a == 65) {
					txtNulo.setVisible(true);
				}else if(a == 75) {
					txtNulo.setVisible(true);
				}else if(a == 85) {
					txtNulo.setVisible(true);
				}else if(a == 95) {
					txtNulo.setVisible(true);
				}				
			}
		};
		b5.addActionListener(listener);
		return b5;
	}

	// B6
	public JButton getB6() {
		b6 = new JButton("6");
		b6.setBounds(930, 243, 70, 60);
		b6.setBackground(Color.black);
		b6.setForeground(Color.WHITE);
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.getText().length() == 2) {
					return;
				} else
					num.setText(num.getText() + "6");								
				int a = Integer.parseInt(num.getText());				
				if(a == 16) {
					txtNulo.setVisible(true);
				}else if(a == 26) {
					txtNulo.setVisible(true);
				}else if(a == 36) {
					txtNulo.setVisible(true);
				}else if(a == 46) {
					txtNulo.setVisible(true);
				}else if(a == 56) {
					txtNulo.setVisible(true);
				}else if(a == 66) {
					txtNulo.setVisible(true);
				}else if(a == 76) {
					txtNulo.setVisible(true);
				}else if(a == 86) {
					txtNulo.setVisible(true);
				}else if(a == 96) {
					txtNulo.setVisible(true);
				}
			}
			
			
		};
		b6.addActionListener(listener);
		return b6;
	}

	// B7
	public JButton getB7() {
		b7 = new JButton("7");
		b7.setBounds(750, 322, 70, 60);
		b7.setBackground(Color.black);
		b7.setForeground(Color.WHITE);
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.getText().length() == 2) {
					return;
				} else
					num.setText(num.getText() + "7");				
				int a = Integer.parseInt(num.getText());
				if (a == 27) {
					candi9.setVisible(true);
					nCandi9.setVisible(true);
					nome9.setVisible(true);
					partido9.setVisible(true);					
				}else if(a == 17) {
					txtNulo.setVisible(true);
				}else if(a == 37) {
					txtNulo.setVisible(true);
				}else if(a == 47) {
					txtNulo.setVisible(true);
				}else if(a == 57) {
					txtNulo.setVisible(true);
				}else if(a == 67) {
					txtNulo.setVisible(true);
				}else if(a == 77) {
					txtNulo.setVisible(true);
				}else if(a == 87) {
					txtNulo.setVisible(true);
				}else if(a == 97) {
					
				}
			}
		};
		b7.addActionListener(listener);
		return b7;
	}

	// B8
	public JButton getB8() {
		b8 = new JButton("8");
		b8.setBounds(840, 322, 70, 60);
		b8.setBackground(Color.black);
		b8.setForeground(Color.WHITE);
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.getText().length() == 2) {
					return;
				} else
					num.setText(num.getText() + "8");
               int a = Integer.parseInt(num.getText());
				
				if(a == 18) {
					txtNulo.setVisible(true);
				}else if(a == 28) {
					txtNulo.setVisible(true);
				}else if(a == 38) {
					txtNulo.setVisible(true);
				}else if(a == 48) {
					txtNulo.setVisible(true);
				}else if(a == 58) {
					txtNulo.setVisible(true);
				}else if(a == 68) {
					txtNulo.setVisible(true);
				}else if(a == 78) {
					txtNulo.setVisible(true);
				}else if(a == 88) {
					txtNulo.setVisible(true);
				}else if(a == 98) {
					txtNulo.setVisible(true);
				}
			}
		};
		b8.addActionListener(listener);
		return b8;
	}

	// B9
	public JButton getB9() {
		b9 = new JButton("9");
		b9.setBounds(930, 322, 70, 60);
		b9.setBackground(Color.black);
		b9.setForeground(Color.WHITE);
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.getText().length() == 2) {
					return;
				} else
					num.setText(num.getText() + "9");
                   int a = Integer.parseInt(num.getText());
				
				if(a == 19) {
					txtNulo.setVisible(true);
				}else if(a == 29) {
					txtNulo.setVisible(true);
				}else if(a == 39) {
					txtNulo.setVisible(true);
				}else if(a == 49) {
					txtNulo.setVisible(true);
				}else if(a == 59) {
					txtNulo.setVisible(true);
				}else if(a == 69) {
					txtNulo.setVisible(true);
				}else if(a == 79) {
					txtNulo.setVisible(true);
				}else if(a == 89) {
					txtNulo.setVisible(true);
				}else if(a == 99) {
					JOptionPane.showMessageDialog(null, "Aperte confirmar para gerar o relatório");
				}
			}
		};
		b9.addActionListener(listener);
		return b9;
	}

	// BOTOES DE BRANCO, CORRIGE, E CONFIRMAR

	public JButton getCorrige() {
		corrige = new JButton("Corrige");
		corrige.setBounds(830, 500, 90, 50);
		corrige.setBackground(Color.red);
		corrige.setForeground(Color.black);
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num.setText("");
				candi1.setVisible(false);
				nCandi1.setVisible(false);
				nome1.setVisible(false);
				partido1.setVisible(false);
				candi2.setVisible(false);
				nCandi2.setVisible(false);
				nome2.setVisible(false);
				partido2.setVisible(false);
				candi3.setVisible(false);
				nCandi3.setVisible(false);
				nome3.setVisible(false);
				partido3.setVisible(false);
				candi4.setVisible(false);
				nCandi4.setVisible(false);
				nome4.setVisible(false);
				partido4.setVisible(false);
				candi5.setVisible(false);
				nCandi5.setVisible(false);
				nome5.setVisible(false);
				partido5.setVisible(false);
				candi6.setVisible(false);
				nCandi6.setVisible(false);
				nome6.setVisible(false);
				partido6.setVisible(false);
				candi7.setVisible(false);
				nCandi7.setVisible(false);
				nome7.setVisible(false);
				partido7.setVisible(false);
				candi8.setVisible(false);
				nCandi8.setVisible(false);
				nome8.setVisible(false);
				partido8.setVisible(false);
				candi9.setVisible(false);
				nCandi9.setVisible(false);
				nome9.setVisible(false);
				partido9.setVisible(false);
				candi10.setVisible(false);
				nCandi10.setVisible(false);
				nome10.setVisible(false);
				partido10.setVisible(false);
				txtNulo.setVisible(false);
				num.setVisible(true);
				txtBranco.setVisible(false);
				b0.setEnabled(true);
				b1.setEnabled(true);
				b2.setEnabled(true);
				b3.setEnabled(true);
				b4.setEnabled(true);
				b5.setEnabled(true);
				b6.setEnabled(true);
				b7.setEnabled(true);
				b8.setEnabled(true);
				b9.setEnabled(true);											
			}
		};
		corrige.addActionListener(listener);
		return corrige;
	}

	public JButton getBranco() {
		branco = new JButton("Branco");
		branco.setBounds(720, 500, 90, 50);
		branco.setBackground(Color.white);
		branco.setForeground(Color.black);
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num.setVisible(false);
				txtBranco.setVisible(true);
				num.setText("1234");
				b0.setEnabled(false);
				b1.setEnabled(false);
				b2.setEnabled(false);
				b3.setEnabled(false);
				b4.setEnabled(false);
				b5.setEnabled(false);
				b6.setEnabled(false);
				b7.setEnabled(false);
				b8.setEnabled(false);
				b9.setEnabled(false);											
			}
		};
		branco.addActionListener(listener);
		return branco;
	}

	public JButton getConfirmar() {
		confirmar = new JButton("Confirmar");
		confirmar.setBounds(940, 479, 100, 72);
		confirmar.setBackground(Color.GREEN);
		confirmar.setForeground(Color.BLACK);
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {							
				try {
				
				int a = Integer.parseInt(num.getText());
				
				//IFS E ELSEIFS PARA IDENTIFICAR OS VOTOS
				if (a == candidatos[0].getNumero()) {
					AudioAcerto ();
					votosHomAra++;
					candidatos[0].setVotos(votosHomAra);
					JOptionPane.showMessageDialog(null, "Seu voto foi guardado");
					num.setText("");
					candi1.setVisible(false);
					nCandi1.setVisible(false);
					nome1.setVisible(false);
					partido1.setVisible(false);
					VotosTotais++;
				}else if (a == candidatos[1].getNumero()) {
					AudioAcerto ();
					votosCapAme++;
					candidatos[1].setVotos(votosCapAme);
					JOptionPane.showMessageDialog(null, "Seu voto foi guardado");
					num.setText("");
					candi2.setVisible(false);
					nCandi2.setVisible(false);
					nome2.setVisible(false);
					partido2.setVisible(false);
					VotosTotais++;					
				}else if (a == candidatos[2].getNumero()) {
					AudioAcerto ();
					votosDead++;
					candidatos[2].setVotos(votosDead);
					JOptionPane.showMessageDialog(null, "Seu voto foi guardado");
					num.setText("");
					candi3.setVisible(false);
					nCandi3.setVisible(false);
					nome3.setVisible(false);
					partido3.setVisible(false);
					VotosTotais++;					
				}else if (a == candidatos[3].getNumero()) {
					AudioAcerto ();
					votosDouEstr++;
					candidatos[3].setVotos(votosDouEstr);
					JOptionPane.showMessageDialog(null, "Seu voto foi guardado");
					num.setText("");
					candi4.setVisible(false);
					nCandi4.setVisible(false);
					nome4.setVisible(false);
					partido4.setVisible(false);
					VotosTotais++;					
				}else if (a == candidatos[4].getNumero()) {
					AudioAcerto ();
					votosFeiti++;
					candidatos[4].setVotos(votosFeiti);
					JOptionPane.showMessageDialog(null, "Seu voto foi guardado");
					num.setText("");
					candi5.setVisible(false);
					nCandi5.setVisible(false);
					nome5.setVisible(false);
					partido5.setVisible(false);
					VotosTotais++;					
				}else if (a == candidatos[5].getNumero()) {
					AudioAcerto ();
					votosHomFer++;
					candidatos[5].setVotos(votosHomFer);
					JOptionPane.showMessageDialog(null, "Seu voto foi guardado");
					num.setText("");
					candi6.setVisible(false);
					nCandi6.setVisible(false);
					nome6.setVisible(false);
					partido6.setVisible(false);
					VotosTotais++;					
				}else if (a == candidatos[6].getNumero()) {
					AudioAcerto ();
					votosHulk++;
					candidatos[6].setVotos(votosHulk);
					JOptionPane.showMessageDialog(null, "Seu voto foi guardado");
					num.setText("");
					candi7.setVisible(false);
					nCandi7.setVisible(false);
					nome7.setVisible(false);
					partido7.setVisible(false);
					VotosTotais++;					
				}else if (a == candidatos[7].getNumero()) {
					AudioAcerto ();
					votosPanNeg++;
					candidatos[7].setVotos(votosPanNeg);
					JOptionPane.showMessageDialog(null, "Seu voto foi guardado");
					num.setText("");
					candi8.setVisible(false);
					nCandi8.setVisible(false);
					nome8.setVisible(false);
					partido8.setVisible(false);
					VotosTotais++;					
				}else if (a == candidatos[8].getNumero()) {
					AudioAcerto ();
					votosThor++;
					candidatos[8].setVotos(votosThor);
					JOptionPane.showMessageDialog(null, "Seu voto foi guardado");
					num.setText("");
					candi9.setVisible(false);
					nCandi9.setVisible(false);
					nome9.setVisible(false);
					partido9.setVisible(false);
					VotosTotais++;					
				}else if (a == candidatos[9].getNumero()) {
					AudioAcerto ();
					votosViuva++;
					candidatos[9].setVotos(votosViuva);
					JOptionPane.showMessageDialog(null, "Seu voto foi guardado");
					num.setText("");
					candi10.setVisible(false);
					nCandi10.setVisible(false);
					nome10.setVisible(false);
					partido10.setVisible(false);
					VotosTotais++;								
				}else if (a == 1234) {
					AudioAcerto ();
					VotosBrancos++;
					JOptionPane.showMessageDialog(null, "Voto Branco");
					num.setVisible(true);
					num.setText("");
					txtBranco.setVisible(false);
					b0.setEnabled(true);
					b1.setEnabled(true);
					b2.setEnabled(true);
					b3.setEnabled(true);
					b4.setEnabled(true);
					b5.setEnabled(true);
					b6.setEnabled(true);
					b7.setEnabled(true);
					b8.setEnabled(true);
					b9.setEnabled(true);											
				}
				//BLOCO PARA CONSTRUIR O RELATORIO E VERIFICAR O VENCEDOR
				else if (a == 99) {		
					        AudioAcerto ();
							dir = new File("C:\\RelatorioUrna");
							dir.mkdir();
							arq = new File(dir,"Relatorio.txt");
							try {
								arq.delete();
								arq.createNewFile();
								FileWriter fileWriter = new FileWriter(arq,true);
								PrintWriter printW = new PrintWriter(fileWriter);			
								
								//FOR PARA IMPRIMIR AS INFORMAÇOES DOS CANDIDATOS
								for(int i =0; i < candidatos.length; i++) {																												
								printW.println("Nome: " + candidatos[i].getNome());
								printW.println("Partido: " +candidatos[i].getPartido());
								printW.println("Numero: " +candidatos[i].getNumero());
								printW.println("Votos: " +candidatos[i].getVotos() + "\n");												           
					            }																				
								printW.println("Votos Validos: " + getVotosTotais());
								printW.println("Votos Brancos: " + getVotosBrancos() + "\n");		
								
								//FOR PARA VERIFICAR O VENCEDOR
								for(int i =0; i < candidatos.length; i++) {																
									if(candidatos[i].getVotos() > vencedor) {
										vencedor = candidatos[i].getVotos();
									}
								}
								//FOR PARA DEFINIR O VENCEDOR	
										
								if(vencedor  == 0){
											printW.println("nenhum vencedor ");
										}
								else
									{for(int i =0; i < candidatos.length; i++) {								
									if(candidatos[i].getVotos() == vencedor ){										
										printW.println("O Presidente Marverl é: " + candidatos[i].getNome());																				
									}		            
								}
									}					
								printW.flush();
					            printW.close();				            
					            JOptionPane.showMessageDialog(null, "Votações finalizadas, Foi gerado um relatorio na pasta C:\\RelatorioUrna");					            					            
							} catch (IOException k) {
								System.out.println(k.getMessage());
							}
							System.exit(0);
							
				}else{
				AudioAcerto ();
				JOptionPane.showMessageDialog(null, "Seu voto foi nulo");
				txtNulo.setVisible(false);
				num.setText("");
				}
					
			} catch (Exception g) {
				JOptionPane.showMessageDialog(null, "Digite um numero");
			}					
			}
		};
		confirmar.addActionListener(listener);
		return confirmar;
	}

	//AREA DO DIGITO
	public JTextField getNumDigito() {
		num = new JTextField();
		num.setBounds(40, 400, 150, 150);
		Border border = BorderFactory.createLineBorder(Color.black, 5);
		num.setBorder(border);
		num.setHorizontalAlignment(JTextField.CENTER);
		num.setEditable(false);
		num.setFont(new Font("", Font.PLAIN, 100));
		return num;
	}
	// PAINEL OBS: O PAINEL ESTA SERVINDO APENAS COMO DIVISORIA
	public JPanel getPainel1() {
		painel1 = new JPanel();
		Color cinza = new Color(28, 28, 28);
		painel1.setBackground(cinza);
		painel1.setBounds(650, 150, 450, 700);
		tela.getContentPane().add(getConfirmar());
		tela.getContentPane().add(getB1());
		tela.getContentPane().add(getB2());
		tela.getContentPane().add(getB3());
		tela.getContentPane().add(getB4());
		tela.getContentPane().add(getB5());
		tela.getContentPane().add(getB6());
		tela.getContentPane().add(getB7());
		tela.getContentPane().add(getB8());
		tela.getContentPane().add(getB9());
		tela.getContentPane().add(getB0());
		tela.getContentPane().add(getCorrige());
		tela.getContentPane().add(getBranco());
		return painel1;
	}

	// CONFIGUÇÕES DA TELA

	public void montarJanela() {
		tela = new JFrame();
		
		// CONFIGUÇÕES DA TELA
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.setResizable(false);
		tela.setBounds(0, 0, 1100, 700);
		tela.setLocationRelativeTo(null);
		
		//ADD PAINEL E JTEXTFIELD
		tela.getContentPane().add(getPainel1());
		tela.getContentPane().add(getNumDigito());
		tela.getContentPane().add(getTxtNulo());
		tela.getContentPane().add(getTxtBranco());
		tela.getContentPane().add(getSimbolo());
		
		//ADD IMAGENS DE MONSTRUARIO
		tela.getContentPane().add(getImg(img1, image1, 40, 20));
		tela.getContentPane().add(getImg(img2, image2, 160, 20));
		tela.getContentPane().add(getImg(img3, image3, 280, 20));
		tela.getContentPane().add(getImg(img4, image4, 400, 20));
		tela.getContentPane().add(getImg(img5, image5, 520, 20));
		tela.getContentPane().add(getImg(img6, image6, 40, 160));
		tela.getContentPane().add(getImg(img7, image7, 160, 160));
		tela.getContentPane().add(getImg(img8, image8, 280, 160));
		tela.getContentPane().add(getImg(img9, image9, 400, 160));
		tela.getContentPane().add(getImg(img10, image10, 520, 160));
		
		//ADD AS IMAGENS MAIORES PARA VOTAÇÃO
		tela.getContentPane().add(getCandi1(150, 200));
		tela.getContentPane().add(getCandi2(150, 210));
		tela.getContentPane().add(getCandi3(150, 199));
		tela.getContentPane().add(getCandi4(150, 200));
		tela.getContentPane().add(getCandi5(150, 200));
		tela.getContentPane().add(getCandi6(150, 200));
		tela.getContentPane().add(getCandi7(150, 200));
		tela.getContentPane().add(getCandi8(150, 200));
		tela.getContentPane().add(getCandi9(150, 200));
		tela.getContentPane().add(getCandi10(150, 200));
		
		//ADD OS NUMEROS DE MONSTRUARIO
		tela.getContentPane().add(getN1(n1, 0, 75, 100));
		tela.getContentPane().add(getN1(n2, 1, 195, 100));
		tela.getContentPane().add(getN1(n3, 2, 315, 100));
		tela.getContentPane().add(getN1(n4, 3, 435, 100));
		tela.getContentPane().add(getN1(n5, 4, 555, 100));
		tela.getContentPane().add(getN1(n6, 5, 75, 240));
		tela.getContentPane().add(getN1(n7, 6, 195, 240));
		tela.getContentPane().add(getN1(n8, 7, 315, 240));
		tela.getContentPane().add(getN1(n9, 8, 435, 240));
		tela.getContentPane().add(getN1(n10, 9, 555, 240));
		
		//ADD OS NUMEROS DE VOTAÇÃO
		tela.getContentPane().add(getnCandi1());
		tela.getContentPane().add(getnCandi2());
		tela.getContentPane().add(getnCandi3());
		tela.getContentPane().add(getnCandi4());
		tela.getContentPane().add(getnCandi5());
		tela.getContentPane().add(getnCandi6());
		tela.getContentPane().add(getnCandi7());
		tela.getContentPane().add(getnCandi8());
		tela.getContentPane().add(getnCandi9());
		tela.getContentPane().add(getnCandi10());
		
		//ADD OS PARTIDOS DE VOTAÇÃO
		tela.getContentPane().add(getPartido1());
		tela.getContentPane().add(getPartido2());
		tela.getContentPane().add(getPartido3());
		tela.getContentPane().add(getPartido4());
		tela.getContentPane().add(getPartido5());
		tela.getContentPane().add(getPartido6());
		tela.getContentPane().add(getPartido7());
		tela.getContentPane().add(getPartido8());
		tela.getContentPane().add(getPartido9());
		tela.getContentPane().add(getPartido10());
		
		//ADD OS NOMES DE VOTAÇÃO
		tela.getContentPane().add(getNome1());
		tela.getContentPane().add(getNome2());
		tela.getContentPane().add(getNome3());
		tela.getContentPane().add(getNome4());
		tela.getContentPane().add(getNome5());
		tela.getContentPane().add(getNome6());
		tela.getContentPane().add(getNome7());
		tela.getContentPane().add(getNome8());
		tela.getContentPane().add(getNome9());
		tela.getContentPane().add(getNome10());
		
		//TORNANDO A TELA VISIVEL
		tela.setVisible(true);

	}
	// INICIANDO A TELA
	public static void main(String[] args) {
		Tela tela = new Tela();
		tela.montarJanela();
	}
}
