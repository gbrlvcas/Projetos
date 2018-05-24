package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import codigos.Acao;


public class JanelaPrincipal {

	public JanelaPrincipal() {
		

		//Janela Principal
		JFrame cxPrincipal = new JFrame();
		cxPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cxPrincipal.setSize(400, 400);
		cxPrincipal.setLocationRelativeTo(null);
		
//JLabel, JText , JTextArea e Instanciamento de Objeto ======================================================================
		
		//Descrição e Caixa [Parcela]
		JLabel lblParcela = new JLabel("Parcela");
		lblParcela.setBounds(20, 155, 70, 30);
		lblParcela.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JTextField txtParcela = new JTextField();
		txtParcela.setBounds(20, 180, 65, 30);
		txtParcela.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtParcela.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Descrição e Caixa [Valor Líquido]
		JLabel lblLiquido = new JLabel("Liquido");
		lblLiquido.setBounds(20, 215, 70, 30);
		lblLiquido.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JTextField txtLiquido = new JTextField();
		txtLiquido.setBounds(20, 240, 65, 30);
		txtLiquido.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtLiquido.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Marca
		JLabel assinatura = new JLabel("Criado por: Gabriel Lucas Pegoretti");
		assinatura.setBounds(220, 340, 200, 30);
		assinatura.setFont(new Font("Calibri", Font.PLAIN, 10));
		
		//Informação do resultado
		JTextArea resultado = new JTextArea("");
		resultado.setBounds(110, 170, 250, 100);
		resultado.setOpaque(true);
		resultado.setEditable(false);
		resultado.setFont(new Font("Calibri", Font.PLAIN, 16));
		Border bordaResultado = BorderFactory.createLineBorder(Color.BLACK);
		resultado.setBorder(bordaResultado);
		
		//Resultado [Calculo resolvido]
		JTextArea resultadoFinal = new JTextArea("");
		resultadoFinal.setBounds(110, 245, 250, 25);
		resultadoFinal.setOpaque(true);
		resultadoFinal.setEditable(false);
		resultadoFinal.setFont(new Font("Calibri", Font.BOLD, 18));
		resultadoFinal.setBackground(Color.GRAY);
		resultadoFinal.setForeground(Color.WHITE);
		Border bordaResultadoFinal = BorderFactory.createLineBorder(Color.BLACK);
		resultadoFinal.setBorder(bordaResultadoFinal);
		resultadoFinal.setVisible(false);
		
		//Instanciando a Ação
		Acao a = new Acao();
		
//Botões e Funções ======================================================================
		
		//Botão [Reinicia e Copia]
		JButton btnReiniciaCopia = new JButton("Copiar valor e Limpar dados");
		btnReiniciaCopia.setBounds(20, 300, 340, 50);
		btnReiniciaCopia.setFont(new Font("Calibri", Font.BOLD, 18));
		btnReiniciaCopia.setForeground(Color.WHITE);
		btnReiniciaCopia.setBackground(Color.GRAY);
		btnReiniciaCopia.setVisible(false);
		
		
		//Botão Calcular [Parcela / Coeficiente]
		JButton btnCalcular = new JButton("Descobrir o valor da dívida");
		btnCalcular.setBounds(20, 300, 340, 50);
		btnCalcular.setFont(new Font("Calibri", Font.BOLD, 18));
		btnCalcular.setForeground(Color.WHITE);
		btnCalcular.setBackground(Color.DARK_GRAY);
		
		//Função Botão [Parcela / Coeficiente]
		btnCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Capturar valor
				String valorParcela = txtParcela.getText();
				String valorLiquido = txtLiquido.getText();
				
				//Instanciar um objeto da classe Ação
						//Ira aplicar a ação
				
				a.RealizarCalculo(valorParcela, valorLiquido);
				
				//Exibir os resultados
				resultado.setText(a.mensagemResultado);
				resultadoFinal.setText(a.mensagemFinal);
				
				if(a.codErro == 0) {
					
					//Ocultar botao principal e exibir secundario
					resultadoFinal.setVisible(true);
					btnCalcular.setVisible(false);
					btnReiniciaCopia.setVisible(true);
					
					//Função Botão [Reinicia e Copia]
					btnReiniciaCopia.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							//Ação para copiar o resultado
							a.CopiarResultado();
							
							//Apagar os dados dos campos
							txtParcela.setText("");
							txtLiquido.setText("");
							resultado.setText("");
							resultadoFinal.setText("");
						
							//Colocar no primeiro campo
							txtParcela.requestFocus();
							
							//Voltar para o botão de cadastro
							resultadoFinal.setVisible(false);
							btnReiniciaCopia.setVisible(false);
							btnCalcular.setVisible(true);
							
						}
					});
					
				}
				
			}
		});
		
		
		

		//Background
		JLabel BG = new JLabel(new ImageIcon(getClass().getResource("/BGApoio.jpg")));
		BG.setBounds(0, 0, 400, 400);
		
		//Adicionando componentes ao programa
		
			//Descrição e JText
			cxPrincipal.add(lblParcela);
			cxPrincipal.add(txtParcela);
			cxPrincipal.add(lblLiquido);
			cxPrincipal.add(txtLiquido);
			cxPrincipal.add(resultadoFinal);
			cxPrincipal.add(resultado);
			cxPrincipal.add(assinatura);
			
			//Botões
			cxPrincipal.add(btnCalcular);
			cxPrincipal.add(btnReiniciaCopia);
		
			//Background
			cxPrincipal.add(BG);
		
		//Deixando programa visivel
		cxPrincipal.setVisible(true);
		
	}
}
