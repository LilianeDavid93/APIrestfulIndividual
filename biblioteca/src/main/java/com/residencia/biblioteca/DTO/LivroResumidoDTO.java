package com.residencia.biblioteca.DTO;

import java.util.Date;

public class LivroResumidoDTO {

	private Integer codigoLivro;
	private String nomeLivro;
	private Date dataLancamento;
	private String nomeEditora;

	

	public LivroResumidoDTO() {
	}

	public LivroResumidoDTO(Integer codigoLivro, String nomeLivro, Date dataLancamento, String nomeEditora) {
		this.codigoLivro = codigoLivro;
		this.nomeLivro = nomeLivro;
		this.dataLancamento = dataLancamento;
		this.nomeEditora = nomeEditora;
	}

	public Integer getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(Integer codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getNomeEditora() {
		return nomeEditora;
	}

	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}

}
