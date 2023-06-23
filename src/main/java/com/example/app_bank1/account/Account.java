package com.example.app_bank1.account;

    import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @Entity
    @Table(name = "users")
    @AllArgsConstructor
    @NoArgsConstructor
    public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
            private Long id;

            private String accountNumber;
            private String ownerName;
            private String accountType;
            private double balance;



        @Basic(optional = false)
        @Column(name = "name")
        private String name;

       @Column(name = "Phone")
         private Integer Phone;

        @Column(name = "Email")
        private Integer Email;



    }
