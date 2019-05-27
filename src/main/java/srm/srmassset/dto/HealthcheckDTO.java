package srm.srmassset.dto;

public class HealthcheckDTO {
	
	public HealthcheckDTO(String status, String descricao) {
		super();
		this.status = status;
		this.descricao = descricao;
	}

	private String status;
	
	private String descricao;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
