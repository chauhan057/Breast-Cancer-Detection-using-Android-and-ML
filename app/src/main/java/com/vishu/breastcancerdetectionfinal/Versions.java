package com.vishu.breastcancerdetectionfinal;

public class Versions {

    private String codeName, version, apiLevel,description;
    //press alt+insert and create a parameterize constructor and setter and getters
    private boolean expendable;

    public boolean isExpendable() {
        return expendable;
    }

    public void setExpendable(boolean expendable) {
        this.expendable = expendable;
    }

    public Versions(String codeName, String version, String apiLevel, String description) {
        this.codeName = codeName;
        this.version = version;
        this.apiLevel = apiLevel;
        this.description = description;
        this.expendable=false; //press alt+ insert and create getters and setters for expendale
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getApiLevel() {
        return apiLevel;
    }

    public void setApiLevel(String apiLevel) {
        this.apiLevel = apiLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //also create a tostring method here


    @Override
    public String toString() {
        return "Versions{" +
                "codeName='" + codeName + '\'' +
                ", version='" + version + '\'' +
                ", apiLevel='" + apiLevel + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    //so now create a adapter class

}


