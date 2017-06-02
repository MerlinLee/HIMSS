package cn.edu.jlu.limf.model;

import javax.persistence.*;

/**
 * Created by merlin on 17-5-2.
 */
@Entity
@Table(name = "t_modules", schema = "HIMSDB", catalog = "")
public class TModulesEntity {
    private int modid;
    private String modulecode;
    private String modulename;
    private String parentcode;
    private String moduleuri;

    @Id
    @Column(name = "MODID", nullable = false)
    public int getModid() {
        return modid;
    }

    public void setModid(int modid) {
        this.modid = modid;
    }

    @Basic
    @Column(name = "MODULECODE", nullable = false, length = 20)
    public String getModulecode() {
        return modulecode;
    }

    public void setModulecode(String modulecode) {
        this.modulecode = modulecode;
    }

    @Basic
    @Column(name = "MODULENAME", nullable = false, length = 45)
    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    @Basic
    @Column(name = "PARENTCODE", nullable = true, length = 45)
    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode;
    }

    @Basic
    @Column(name = "MODULEURI", nullable = true, length = 45)
    public String getModuleuri() {
        return moduleuri;
    }

    public void setModuleuri(String moduleuri) {
        this.moduleuri = moduleuri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TModulesEntity that = (TModulesEntity) o;

        if (modid != that.modid) return false;
        if (modulecode != null ? !modulecode.equals(that.modulecode) : that.modulecode != null) return false;
        if (modulename != null ? !modulename.equals(that.modulename) : that.modulename != null) return false;
        if (parentcode != null ? !parentcode.equals(that.parentcode) : that.parentcode != null) return false;
        if (moduleuri != null ? !moduleuri.equals(that.moduleuri) : that.moduleuri != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = modid;
        result = 31 * result + (modulecode != null ? modulecode.hashCode() : 0);
        result = 31 * result + (modulename != null ? modulename.hashCode() : 0);
        result = 31 * result + (parentcode != null ? parentcode.hashCode() : 0);
        result = 31 * result + (moduleuri != null ? moduleuri.hashCode() : 0);
        return result;
    }
}
