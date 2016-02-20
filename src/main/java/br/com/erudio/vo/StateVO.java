package br.com.erudio.vo;

import java.io.Serializable;

public class StateVO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer idState;
    private String stateName;

    public StateVO() {}

	public Integer getIdState() {
		return idState;
	}

	public void setIdState(Integer idState) {
		this.idState = idState;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idState == null) ? 0 : idState.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StateVO other = (StateVO) obj;
		if (idState == null) {
			if (other.idState != null)
				return false;
		} else if (!idState.equals(other.idState))
			return false;
		return true;
	}
}