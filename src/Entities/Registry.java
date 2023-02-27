package Entities;

import java.time.LocalDateTime;

public class Registry {
	private String placa;
	private LocalDateTime hora_entrada;
	private LocalDateTime hora_saida;
	private double valorTotal;
	
	
	public Registry() {

	}

	
	public Registry(String placa, LocalDateTime hora_entrada) {
		this.placa = placa;
		this.hora_entrada = hora_entrada;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public LocalDateTime getHora_entrada() {
		return hora_entrada;
	}


	public void setHora_entrada(LocalDateTime hora_entrada) {
		this.hora_entrada = hora_entrada;
	}


	public LocalDateTime getHora_saida() {
		return hora_saida;
	}


	public void setHora_saida(LocalDateTime hora_saida) {
		this.hora_saida = hora_saida;
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public void valorTotal() {
		
	}
	

	@Override
	public String toString() {
		return "Registry [placa=" + placa + ", hora_entrada=" + hora_entrada + ", hora_saida=" + hora_saida
				+ ", valorTotal=" + valorTotal + "]";
	}
	
	

	
}
