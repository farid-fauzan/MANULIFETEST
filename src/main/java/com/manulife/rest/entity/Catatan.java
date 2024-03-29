package com.manulife.rest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "catatan", schema = "db_manulife")
public class Catatan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "author", nullable = true)
    private String author;

    @Column(name = "created_at", nullable = true )
    private Date createdt;

    @Column(name = "updated_at", nullable = true )
    private Date updatedAt;
}
