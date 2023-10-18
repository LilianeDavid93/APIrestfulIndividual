package com.residencia.biblioteca.DTO;

public class EditoraDTO {

	private int codigoEditora;
	private String nome;
	private String imagemNome;
	private String imagemFilenome;
	private String imagemUrl;

	public EditoraDTO() {

	}

	public EditoraDTO(int codigoEditora, String nome, String imagemNome, String imagemFilenome, String imagemUrl) {
		super();
		this.codigoEditora = codigoEditora;
		this.nome = nome;
		this.imagemNome = imagemNome;
		this.imagemFilenome = imagemFilenome;
		this.imagemUrl = imagemUrl;
	}

	public int getCodigoEditora() {
		return codigoEditora;
	}

	public void setCodigoEditora(int codigoEditora) {
		this.codigoEditora = codigoEditora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagemNome() {
		return imagemNome;
	}

	public void setImagemNome(String imagemNome) {
		this.imagemNome = imagemNome;
	}

	public String getImagemFilenome() {
		return imagemFilenome;
	}

	public void setImagemFilenome(String imagemFilenome) {
		this.imagemFilenome = imagemFilenome;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

}
