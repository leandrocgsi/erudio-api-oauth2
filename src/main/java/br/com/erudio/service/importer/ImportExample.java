package br.com.erudio.service.importer;

import java.io.Serializable;

public class ImportExample implements Serializable{

	private static final long serialVersionUID = 1L;

    private Long id;
    private String scale;
    private String oxygen_behavior;
    private Integer oxygen_behavior_number;
    private String question_pt_br;
    private String factor_pt_br;
    private String grid_intro_text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getOxygen_behavior() {
        return oxygen_behavior;
    }

    public void setOxygen_behavior(String oxygen_behavior) {
        this.oxygen_behavior = oxygen_behavior;
    }

    public Integer getOxygen_behavior_number() {
        return oxygen_behavior_number;
    }

    public void setOxygen_behavior_number(Integer oxygen_behavior_number) {
        this.oxygen_behavior_number = oxygen_behavior_number;
    }

    public String getQuestion_pt_br() {
        return question_pt_br;
    }

    public void setQuestion_pt_br(String question_pt_br) {
        this.question_pt_br = question_pt_br;
    }

    public String getFactor_pt_br() {
        return factor_pt_br;
    }

    public void setFactor_pt_br(String factor_pt_br) {
        this.factor_pt_br = factor_pt_br;
    }

    public String getGrid_intro_text() {
        return grid_intro_text;
    }

    public void setGrid_intro_text(String grid_intro_text) {
        this.grid_intro_text = grid_intro_text;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ImportExample other = (ImportExample) obj;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        return true;
    }
}