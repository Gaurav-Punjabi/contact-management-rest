package com.example.contactmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Just a model that holds all the basic meta fields that must be included in all the tables.
 */
public class BaseModel {
    /**
     * The Date on which the entry was created.
     */
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    /**
     * The Date on which the data was updated
     */
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updatedAt;

    /**
     * The Id of the user that created this entry.
     */
    @JsonIgnore
    @Basic
    @Column(name = "created_by")
    private Long createdBy;

    /**
     * The Id of the user who updated this entry.
     */
    @JsonIgnore
    @Basic
    @Column(name = "updated_by")
    private Long updatedBy;

    /**
     * Jus a flag like the dirty bit.
     */
    @JsonIgnore
    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean deleted = false;

    // GETTERS

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public boolean isDeleted() {
        return deleted;
    }

    // SETTERS

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
