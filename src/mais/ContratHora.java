package mais;

import java.util.Date;

public class ContratHora {

	private Date data;
	private Double valorhora;
	private Integer horas;
	
	public ContratHora() {
	}

	public ContratHora(Date data, Double valorhora, Integer horas) {
		this.data = data;
		this.valorhora = valorhora;
		this.horas = horas;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorhora() {
		return valorhora;
	}

	public void setValorhora(Double valorhora) {
		this.valorhora = valorhora;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public double ValorTotal() {
	  return valorhora*horas;	
	}
		
	
	
	
}
