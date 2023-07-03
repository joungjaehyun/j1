package org.zerock.j1.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_sample")
public class Sample {
    // Entity Class
    // 모든 Entity는 primary key(ID)가있어야된다
    @Id
    private String keyCol;
    
    private String first;
    
    private String last;
    
}
