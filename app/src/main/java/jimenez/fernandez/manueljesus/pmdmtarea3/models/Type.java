package jimenez.fernandez.manueljesus.pmdmtarea3.models;

public class Type {
    private String name;
    private String url;

    public Type() {}

    public Type(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
