package ZooJPA.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "zoo", schema = "public", catalog = "shaimart")
public class ZooEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_zoo")
    private int idZoo;
    @Basic
    @Column(name = "zoo_name", nullable = false)
    private String zooName;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "postalcode")
    private int postalcode;
    @Basic
    @Column(name = "url")
    private String url;
    @ManyToOne
    @JoinColumn(name = "zoo_name", referencedColumnName = "namezoo", nullable = false, insertable = false, updatable = false)
    private AnimalEntity animalByZooName;
    @ManyToOne
    @JoinColumn(name = "zoo_name", referencedColumnName = "namezoo", nullable = false, insertable = false, updatable = false)
    private EmployeeEntity employeeByZooName;

    public int getIdZoo() {
        return idZoo;
    }

    public void setIdZoo(int idZoo) {
        this.idZoo = idZoo;
    }

    public String getZooName() {
        return zooName;
    }

    public void setZooName(String zooName) {
        this.zooName = zooName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZooEntity zooEntity = (ZooEntity) o;

        if (idZoo != zooEntity.idZoo) return false;
        if (postalcode != zooEntity.postalcode) return false;
        if (zooName != null ? !zooName.equals(zooEntity.zooName) : zooEntity.zooName != null) return false;
        if (city != null ? !city.equals(zooEntity.city) : zooEntity.city != null) return false;
        if (street != null ? !street.equals(zooEntity.street) : zooEntity.street != null) return false;
        if (url != null ? !url.equals(zooEntity.url) : zooEntity.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idZoo;
        result = 31 * result + (zooName != null ? zooName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + postalcode;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    public AnimalEntity getAnimalByZooName() {
        return animalByZooName;
    }

    public void setAnimalByZooName(AnimalEntity animalByZooName) {
        this.animalByZooName = animalByZooName;
    }

    public EmployeeEntity getEmployeeByZooName() {
        return employeeByZooName;
    }

    public void setEmployeeByZooName(EmployeeEntity employeeByZooName) {
        this.employeeByZooName = employeeByZooName;
    }
}
