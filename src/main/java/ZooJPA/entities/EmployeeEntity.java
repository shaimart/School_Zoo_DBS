package ZooJPA.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "employee", schema = "public", catalog = "shaimart")
public class EmployeeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_employee")
    private int idEmployee;
    @Basic
    @Column(name = "rodnecislo")
    private String rodnecislo;
    @Basic
    @Column(name = "dateofbirth")
    private Date dateofbirth;
    @Basic
    @Column(name = "firstname")
    private String firstname;
    @Basic
    @Column(name = "secondname")
    private String secondname;
    @Basic
    @Column(name = "namezoo")
    private String namezoo;
    @Basic
    @Column(name = "boss")
    private Integer boss;
    @OneToMany(mappedBy = "employeeByIdEmployee")
    private Collection<CareEntity> caresByIdEmployee;
    @ManyToOne
    @JoinColumn(name = "boss", referencedColumnName = "id_employee",insertable = false, updatable = false)
    private EmployeeEntity employeeByBoss;
    @OneToMany(mappedBy = "employeeByBoss")
    private Collection<EmployeeEntity> employeesByIdEmployee;

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getRodnecislo() {
        return rodnecislo;
    }

    public void setRodnecislo(String rodnecislo) {
        this.rodnecislo = rodnecislo;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getNamezoo() {
        return namezoo;
    }

    public void setNamezoo(String namezoo) {
        this.namezoo = namezoo;
    }

    public Integer getBoss() {
        return boss;
    }

    public void setBoss(Integer boss) {
        this.boss = boss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (idEmployee != that.idEmployee) return false;
        if (rodnecislo != null ? !rodnecislo.equals(that.rodnecislo) : that.rodnecislo != null) return false;
        if (dateofbirth != null ? !dateofbirth.equals(that.dateofbirth) : that.dateofbirth != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (secondname != null ? !secondname.equals(that.secondname) : that.secondname != null) return false;
        if (namezoo != null ? !namezoo.equals(that.namezoo) : that.namezoo != null) return false;
        if (boss != null ? !boss.equals(that.boss) : that.boss != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmployee;
        result = 31 * result + (rodnecislo != null ? rodnecislo.hashCode() : 0);
        result = 31 * result + (dateofbirth != null ? dateofbirth.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (secondname != null ? secondname.hashCode() : 0);
        result = 31 * result + (namezoo != null ? namezoo.hashCode() : 0);
        result = 31 * result + (boss != null ? boss.hashCode() : 0);
        return result;
    }

    public Collection<CareEntity> getCaresByIdEmployee() {
        return caresByIdEmployee;
    }

    public void setCaresByIdEmployee(Collection<CareEntity> caresByIdEmployee) {
        this.caresByIdEmployee = caresByIdEmployee;
    }

    public EmployeeEntity getEmployeeByBoss() {
        return employeeByBoss;
    }

    public void setEmployeeByBoss(EmployeeEntity employeeByBoss) {
        this.employeeByBoss = employeeByBoss;
    }

    public Collection<EmployeeEntity> getEmployeesByIdEmployee() {
        return employeesByIdEmployee;
    }

    public void setEmployeesByIdEmployee(Collection<EmployeeEntity> employeesByIdEmployee) {
        this.employeesByIdEmployee = employeesByIdEmployee;
    }
}
