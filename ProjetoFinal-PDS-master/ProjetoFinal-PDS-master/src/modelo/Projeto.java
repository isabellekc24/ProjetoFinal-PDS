package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Projeto implements Serializable{
	
	private String nomeProj;
	private String descProj;
	private String departamento;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	private float orcamento;
	private String equipePesq;
	private String nomeCoord;
	private String objtProjeto;
	private String ResultEsperado;
	private String statusProj;
	
	
	
	
	public String getNomeProj() {
		return nomeProj;
	}
	public void setNomeProj(String nomeProj) {
		this.nomeProj = nomeProj;
	}
	public String getDescProj() {
		return descProj;
	}
	public void setDescProj(String descProj) {
		this.descProj = descProj;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}
	public float getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(float orcamento) {
		this.orcamento = orcamento;
	}
	public String getEquipePesq() {
		return equipePesq;
	}
	public void setEquipePesq(String equipePesq) {
		this.equipePesq = equipePesq;
	}
	public String getNomeCoord() {
		return nomeCoord;
	}
	public void setNomeCoord(String nomeCoord) {
		this.nomeCoord = nomeCoord;
	}
	public String getObjtProjeto() {
		return objtProjeto;
	}
	public void setObjtProjeto(String objtProjeto) {
		this.objtProjeto = objtProjeto;
	}
	public String getResultEsperado() {
		return ResultEsperado;
	}
	public void setResultEsperado(String resultEsperado) {
		ResultEsperado = resultEsperado;
	}
	public String getStatusProj() {
		return statusProj;
	}
	public void setStatusProj(String statusProj) {
		this.statusProj = statusProj;
	}
	
}
