package cn.edu.jlu.limf.model;

import javax.persistence.*;

/**
 * Created by merlin on 17-5-2.
 */
@Entity
@Table(name = "t_moduleprivilege", schema = "HIMSDB", catalog = "")
public class TModuleprivilegeEntity {
    private int mpid;
    private String modulecode;
    private String pricode;

    @Id
    @Column(name = "MPID", nullable = false)
    public int getMpid() {
        return mpid;
    }

    public void setMpid(int mpid) {
        this.mpid = mpid;
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
    @Column(name = "PRICODE", nullable = false, length = 20)
    public String getPricode() {
        return pricode;
    }

    public void setPricode(String pricode) {
        this.pricode = pricode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TModuleprivilegeEntity that = (TModuleprivilegeEntity) o;

        if (mpid != that.mpid) return false;
        if (modulecode != null ? !modulecode.equals(that.modulecode) : that.modulecode != null) return false;
        if (pricode != null ? !pricode.equals(that.pricode) : that.pricode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mpid;
        result = 31 * result + (modulecode != null ? modulecode.hashCode() : 0);
        result = 31 * result + (pricode != null ? pricode.hashCode() : 0);
        return result;
    }
}
