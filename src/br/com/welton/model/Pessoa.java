package br.com.welton.model;
import java.util.Comparator;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.welton.controle.DateAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
public class Pessoa implements Comparator<Pessoa>{

	@XmlAttribute
	private int codigo;
	@XmlElement
	private String nome;
	@XmlElement
	private String sobrenome;
	@XmlElement
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date nascimento;
	
	//Getters e setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	
	}
	@Override
	public int compare(Pessoa p1, Pessoa p2) {
		int resultado = p1.getNome().compareTo(p2.getNome());
		if(resultado == 0)
			resultado = p1.getSobrenome().compareTo(p2.getSobrenome());
		return resultado;
	}
}
