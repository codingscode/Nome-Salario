package mais;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mais.enums.NivelTrabalho;

public class Trabalhador {

	private String nometrab;
	private Double baseSalarial;
	private NivelTrabalho nivel;
	private Departamento departamento;
	
	private List<ContratHora> contratos = new ArrayList<>();
	
	public Trabalhador() {
	}

	public Trabalhador(String nometrab, Double baseSalarial, NivelTrabalho nivel, Departamento departamento) {
		this.nometrab = nometrab;
		this.baseSalarial = baseSalarial;
		this.nivel = nivel;
		this.departamento = departamento;
	}

	public String getNometrab() {
		return nometrab;
	}

	public void setNometrab(String nometrab) {
		this.nometrab = nometrab;
	}

	public Double getBaseSalarial() {
		return baseSalarial;
	}

	public void setBaseSalarial(Double baseSalarial) {
		this.baseSalarial = baseSalarial;
	}

	public NivelTrabalho getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalho nivel) {
		this.nivel = nivel;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public List<ContratHora> getContratos() {
	  return contratos;	
	}
	
	public void adicContrato(ContratHora contrato) {
	  contratos.add(contrato);	
	}
	
	public void removContrato(ContratHora contrato) {
	  contratos.remove(contrato);	
	}
	
    public double renda (int ano, int mes) {
	  double soma = baseSalarial;
	  Calendar cal = Calendar.getInstance();
	  for (ContratHora c : contratos) {
	    cal.setTime(c.getData());	
	    int c_ano = cal.get(Calendar.YEAR);
	    int c_mes = 1 + cal.get(Calendar.MONTH);
	    if (ano == c_ano && mes == c_mes) {
	      soma += c.ValorTotal();
	    }
	  }
	  return soma;
	}
	
	
}
