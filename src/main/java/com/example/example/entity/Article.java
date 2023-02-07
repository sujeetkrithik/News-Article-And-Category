package com.example.example.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Data
@Table(name = "article")
@SQLDelete(sql = "UPDATE article SET deleted_date_time = NOW() WHERE id=?")
public class Article {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String title;

    private String description;
    private String creationDateTime;
    private String updationDateTime;
    private String deletedDateTime;
}
