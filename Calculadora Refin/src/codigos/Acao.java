package codigos;

import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class Acao {
	
	//Atributos
	double coeficiente = 0.02820;
	public int codErro = 0;
	public String mensagemResultado = "";
	public String mensagemFinal = "";
	String copiaResultado = "";

	//M�todo para calcular
	public void RealizarCalculo(String valorParcela, String valorLiquido) {
		
		//Zerando valor - Caso o bot�o seja clicado novamente [Pois n�o ser� executa a classe a��o, logo o codErro n�o ser� zerado]
		codErro = 0;
		
		//Dando replace no valor digitado
		String reporParcela = valorParcela.replace(",", ".");
		String reporLiquido = valorLiquido.replace(",", ".");
		
		//Puxando as variaveis da classe [Calculo]
		Calculo c = new Calculo();
		
		//Validando [Campo em branco]
		if(valorParcela.equals("") || valorLiquido.equals("")) {
			codErro = 1;
		}
		
		if(codErro == 0) {
			//Validando [Digitou letra]
			try {
				
				c.setParcela(Double.parseDouble(reporParcela));
				c.setLiquido(Double.parseDouble(reporLiquido));
				
				
			}catch(Exception e) {
				codErro = 2;
			}
		}
		
		
		
		//Resultado final [Calculando e exibindo o acontecimento]
		
		if(codErro == 1) {
			mensagemResultado = "\n\n       N�o deixe campos em branco";
		}else if(codErro == 2) {
			mensagemResultado = "\n\n         Digite apenas n�meros";
		}else if(codErro == 0){
			
			//Resultado = parcela / coeficiente
			c.setResultado(c.getParcela() / coeficiente);
			
			//Resultado  = Resultado(Com valor de cima) - valor l�quido
			c.setResultado(c.getResultado() - c.getLiquido());
			
			//Copiar resultado para jogar no m�todo [CopiarResultado]
			copiaResultado = String.valueOf(String.format("%.2f",c.getResultado()));
			
			mensagemResultado = " Parcela: R$ "+valorParcela+"\n Coeficiente: "+coeficiente+"\n Valor l�quido: R$ "+valorLiquido;
			mensagemFinal = "         Valor d�vida: R$"+String.format("%.2f",c.getResultado()).replace(".", ",");
			 
		}
		
		
	}
	
	//M�todo para copiar
	public void CopiarResultado() {
		
		
	    StringSelection stringSelection = new StringSelection(copiaResultado);
	    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clpbrd.setContents(stringSelection, null);
		
		
		
		
	}
}
