package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Registry {
    private String placa;
    private Date hora_entrada;
    private Date hora_saida;
    private double valorTotal;

    public Registry() {

    }

    public Registry(String placa, Date hora_entrada) {
        long time = hora_entrada.getTime();
        Date date = new Date(time - 3600000);
        this.placa = placa;
        this.hora_entrada = date;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Date hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public Date getHora_saida() {
        return hora_saida;
    }

    public void setHora_saida(Date hora_saida) {
        this.hora_saida = hora_saida;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Calcula o valor total referente a 10 centavos por minuto;
     */
    public void calcularValor() {
        long hora_saida = this.hora_saida.getTime();
        long hora_entrada = this.hora_entrada.getTime();
        long dif = (hora_saida - hora_entrada) / 1000;
        dif = dif / 60 / 60;
        this.valorTotal = (dif * 15);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss - dd/MMMM/yyyy");
        return "\n ---------------------------------------------------" + ((placa != null) ? "\n Placa: " + placa : "")
                + ((hora_entrada != null) ? "\n Horario de entrada: " + sdf.format(hora_entrada) : "")
                + ((hora_saida != null) ? "\n Horario de saida: " + sdf.format(hora_saida) : "")
                + ((valorTotal != 0.00) ? "\n Valor total: R$ " + String.format("%.2f", valorTotal) : "")
                + "\n ---------------------------------------------------";
    }
}
