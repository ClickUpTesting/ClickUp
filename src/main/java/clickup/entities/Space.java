package clickup.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Space implements Features {
    public String id;
    public String name;
    public boolean access;

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

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "Space{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", access=" + access
                + '}';
    }

    @Override
    public <T> T getIdentifier() {
        return null;
    }

    @Override
    public void setDefaultValues() {

    }
}
