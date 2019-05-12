/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author buddhika
 */
@Entity
public class YearData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int yearSerial;
    private int yearNumber;
    private Double dataDouble;
    private Double dateString;
    
    
    
    
    


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof YearData)) {
            return false;
        }
        YearData other = (YearData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.YearData[ id=" + id + " ]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYearSerial() {
        return yearSerial;
    }

    public void setYearSerial(int yearSerial) {
        this.yearSerial = yearSerial;
    }

    public int getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    public Double getDataDouble() {
        return dataDouble;
    }

    public void setDataDouble(Double dataDouble) {
        this.dataDouble = dataDouble;
    }

    public Double getDateString() {
        return dateString;
    }

    public void setDateString(Double dateString) {
        this.dateString = dateString;
    }

    
}
