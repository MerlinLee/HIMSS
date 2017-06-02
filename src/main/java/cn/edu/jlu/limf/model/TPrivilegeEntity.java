package cn.edu.jlu.limf.model;

import javax.persistence.*;

/**
 * Created by merlin on 17-5-2.
 */
@Entity
@Table(name = "t_privilege", schema = "HIMSDB", catalog = "")
public class TPrivilegeEntity {
    private int priid;
    private String pricode;
    private String priname;

    @Id
    @Column(name = "PRIID", nullable = false)
    public int getPriid() {
        return priid;
    }

    public void setPriid(int priid) {
        this.priid = priid;
    }

    @Basic
    @Column(name = "PRICODE", nullable = false, length = 20)
    public String getPricode() {
        return pricode;
    }

    public void setPricode(String pricode) {
        this.pricode = pricode;
    }

    @Basic
    @Column(name = "PRINAME", nullable = false, length = 45)
    public String getPriname() {
        return priname;
    }

    public void setPriname(String priname) {
        this.priname = priname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TPrivilegeEntity that = (TPrivilegeEntity) o;

        if (priid != that.priid) return false;
        if (pricode != null ? !pricode.equals(that.pricode) : that.pricode != null) return false;
        if (priname != null ? !priname.equals(that.priname) : that.priname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = priid;
        result = 31 * result + (pricode != null ? pricode.hashCode() : 0);
        result = 31 * result + (priname != null ? priname.hashCode() : 0);
        return result;
    }
}
