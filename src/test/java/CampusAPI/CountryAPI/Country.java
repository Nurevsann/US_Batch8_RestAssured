package CampusAPI.CountryAPI;

import java.util.List;

public class Country {
    private String id;
    private String name;
    private String shortName;
    private List <String> translateName;
    private String code;
    private boolean hasState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<String> getTranslateName() {
        return translateName;
    }

    public void setTranslateName(List<String> translateName) {
        this.translateName = translateName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isHasState() {
        return hasState;
    }

    public void setHasState(boolean hasState) {
        this.hasState = hasState;
    }
}
