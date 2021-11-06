package com.giit.wallet.dataobject;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;



@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String userName;
    private String sex;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreated;
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private Set<Wallet> transactions = new HashSet<>();
    @Version
    private int version;

    public Account() {
    }

    public Account(Long id) {
        this.id = id;
    }

    public Account(String userName, String sex, Date dateCreated) {
        this.userName = userName;
        this.sex = sex;
        this.dateCreated = dateCreated;
    }
    
    

    public Account(Long id,String userName, String sex, Date dateCreated) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.dateCreated = dateCreated;
    }
    

    public Account(AccountBuilder builder) {
        id = builder.id;
        userName = builder.userName;
        sex = builder.sex;
        dateCreated = builder.dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Set<Wallet> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Wallet> transactions) {
        this.transactions = transactions;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public static class AccountBuilder {

        private Long id;
        private String userName;
        private String sex;
        private Date dateCreated;

        public Long getId() {
            return id;
        }

        public AccountBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public AccountBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public AccountBuilder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public AccountBuilder setDateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Account build() {
            return new Account(this);
        }

    }

}
