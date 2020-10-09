package com.rns.testes.java.model;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ESTOQUE")
@SequenceGenerator(name = "ESTOQUE_SEQ", sequenceName = "ESTOQUE_SEQ", allocationSize = 1)
@Data
public class Estoque extends GenericEntity<Long> {

	
	@Id
    @GeneratedValue(generator = "ESTOQUE_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_FILIAL", referencedColumnName = "id")
	private Filial filial; 
	
	@OneToMany
	@JoinTable(name="ESTOQUE_PRODUTO",
				joinColumns = {@JoinColumn(name="ID_PRODUTO")},
				inverseJoinColumns = {@JoinColumn(name="ID_ESTOQUE")})
	private List<Produto> produtos;
	
	@ElementCollection(targetClass=String.class)
	@MapKeyColumn(name="PRODUTO_ID")
	private Map<Long, Integer> quantidadeProduto;
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
