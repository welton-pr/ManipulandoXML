package br.com.welton.controle;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamWriter;

import br.com.welton.model.Pessoa;
import br.com.welton.model.Pessoas;

public class Main {

	public static void main(String[] args) {

	
		try {
	

			//Primeiro exemplo convertendo de objeto para String
//			JAXBContext jaxbContext = JAXBContext.newInstance(Pessoas.class);
//			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//			StringWriter sw = new StringWriter();
//			Pessoas pessoas = retornaObjetoPessoas();
//			
//			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
////			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
//
//			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
//			jaxbMarshaller.marshal(pessoas, sw);
//			System.out.println(sw.toString());	
//		
			

			//Segundo exemplo convertendo de string para objeto
			Reader reader = new StringReader(retornXML());
			JAXBContext jaxbContext = JAXBContext.newInstance(Pessoas.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//			deixa formatado
//			unmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			entende os acentos caso não esteja convertendo corretamente
//			esses caracteres
//			unmarshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
//			Insere cabecalho do arquivo
//			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			Pessoas pessoas = (Pessoas)unmarshaller.unmarshal(reader);
			
			for(Pessoa p : pessoas.getPessoa()) {
				System.out.println(p.getNome());	
				System.out.println(p.getSobrenome());	
				System.out.println(p.getNascimento());	
			}
		
			
		
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static Pessoas retornaObjetoPessoas() {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		try {
		
			//primeira pessoa 
			Pessoa p1 = new Pessoa();
			p1.setCodigo(1);
			p1.setNome("Fabio");
			p1.setSobrenome("António");
			p1.setNascimento(sdf.parse("12/12/1989"));
			lista.add(p1);
			
			//segunda pessoa 
			Pessoa p2 = new Pessoa();
			p2.setCodigo(2);
			p2.setNome("António");
			p2.setSobrenome("Silva");
			p2.setNascimento(sdf.parse("01/01/1990"));
			lista.add(p2);
			
			//terceira pessoa 
			Pessoa p3 = new Pessoa();
			p3.setCodigo(3);
			p3.setNome("Flávio");
			p3.setSobrenome("Monteiro");
			p3.setNascimento(sdf.parse("10/05/1970"));
			lista.add(p3);
		
			//quarta pessoa 
			Pessoa p5 = new Pessoa();
			p5.setCodigo(5);
			p5.setNome("Denilson");
			p5.setSobrenome("Montero");
			p5.setNascimento(sdf.parse("10/10/1973"));
			lista.add(p5);
		
			
			//quinta pessoa 
			Pessoa p4 = new Pessoa();
			p4.setCodigo(4);
			p4.setNome("Denilson");
			p4.setSobrenome("Monteiro");
			p4.setNascimento(sdf.parse("10/10/1973"));
			lista.add(p4);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		Pessoas p = new Pessoas();
		p.setPessoa(lista);
		return p;
	}
	
	/**
	 * Método de retorna um xml em format string para teste de xml.
	 * @return
	 */
	private static String retornXML() {
		return "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"yes\"?>"
		+"<pessoas>"
		+    "<pessoa codigo=\"1\">"
		+        "<nome>Fabio</nome>"
		+        "<sobrenome>António</sobrenome>"
		+        "<nascimento>12-12-1989 00:00</nascimento>"
		+    "</pessoa>"
		+    "<pessoa codigo=\"2\">"
		+        "<nome>António</nome>"
		+        "<sobrenome>Silva</sobrenome>"
		+        "<nascimento>01-01-1990 00:00</nascimento>"
		+    "</pessoa>"
		+    "<pessoa codigo=\"3\">"
		+        "<nome>Flávio</nome>"
		+        "<sobrenome>Monteiro</sobrenome>"
		+        "<nascimento>10-05-1970 00:00</nascimento>"
		+    "</pessoa>"
		+    "<pessoa codigo=\"5\">"
		+        "<nome>Denilson</nome>"
		+        "<sobrenome>Montero</sobrenome>"
		+        "<nascimento>10-10-1973 00:00</nascimento>"
		+    "</pessoa>"
		+    "<pessoa codigo=\"4\">"
		+        "<nome>Denilson</nome>"
		+        "<sobrenome>Monteiro</sobrenome>"
		+        "<nascimento>10-10-1973 00:00</nascimento>"
		+    "</pessoa>"
		+"</pessoas>";
	}
	
	
	/**
	 * Método que retorna o comparator para ordenação de pessoa por nome e sobrenome.
	 * @return
	 */
	public static Comparator<Pessoa> ordenaPessoaNomeSobrenome(){
		
		return new Comparator<Pessoa>() {
			@Override
			public int compare(Pessoa p1, Pessoa p2) {
				int resultado = p1.getNome().compareTo(p2.getNome());
				if(resultado == 0)
					resultado = p1.getSobrenome().compareTo(p2.getSobrenome());
				return resultado;
			}
		};
		
		
	}
	
	
	/**
	 * Método que retorna o comparator para ordenação de pessoa por nascimento.
	 * @return
	 */
	public static Comparator<Pessoa> ordenaPessoaNascimento(){
		
		return new Comparator<Pessoa>() {
			@Override
			public int compare(Pessoa p1, Pessoa p2) {
				int resultado = p1.getNascimento().compareTo(p2.getNascimento());
				return resultado;
			}
		};
		
		
	}
	
}
