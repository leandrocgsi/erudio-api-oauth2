package br.com.erudio.importer;

import java.util.ArrayList;
import java.util.List;

public class ImportResult {

    private List<String> errors = new ArrayList<String>();
    private List<String> updateds = new ArrayList<String>();
    private List<String> inserteds = new ArrayList<String>();
    private List<String> inactivated = new ArrayList<String>();
    private List<String> deleted = new ArrayList<String>();

    private String filePath;

    public ImportResult() {}

    public void addInserted(String inserted) {
        if(!inserteds.contains(inserted)) inserteds.add(inserted);
    }

    public void addUpdated(String updated) {
        if(!updateds.contains(updated)) updateds.add(updated);
    }

    public void addInactivated(String inativated) {
        if(!inactivated.contains(inativated)) inactivated.add(inativated);
    }

    public void addDeleted(String deletado) {
        if(!deleted.contains(deletado)) deleted.add(deletado);
    }

    public void incError(String error) {
        errors.add(error);
    }

    public List<String> getErrors(){
        return errors;
    }

    public List<String> getUpdateds() {
        return updateds;
    }

    public void setUpdateds(List<String> updateds) {
        this.updateds = updateds;
    }

    public List<String> getInserteds() {
        return inserteds;
    }

    public void setInserteds(List<String> inserteds) {
        this.inserteds = inserteds;
    }

    public List<String> getInactivated() {
        return inactivated;
    }

    public void setInactivated(List<String> inactivated) {
        this.inactivated = inactivated;
    }

    public List<String> getDeleted() {
        return deleted;
    }

    public void setDeleted(List<String> deleted) {
        this.deleted = deleted;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}