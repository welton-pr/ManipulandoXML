
package br.com.welton.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


//<pessoas>
//	<pessoa id="">
//		<atributo></atributo>
//		<atributo></atributo>
//		<atributo></atributo>
//	</pessoa>
//	<pessoa>
//		<atributo></atributo>
//		<atributo></atributo>
//		<atributo></atributo>
//	</pessoa>
//</pessoas>


@XmlRootElement(name="pessoas")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pessoas {
	
	@XmlElement
	List<Pessoa> pessoa= new ArrayList<Pessoa>();

	//Getters e setters
	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
}

