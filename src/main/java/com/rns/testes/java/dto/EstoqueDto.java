package com.rns.testes.java.dto;

import java.util.List;
import java.util.Map;

import com.rns.testes.java.model.Filial;
import com.rns.testes.java.model.Produto;

import lombok.Data;

@Data
public class EstoqueDto {

    private String id;
    private Filial filial;
	private List<Produto> produtos;
	private Map<Long, Integer> quantidadeProduto;

}
