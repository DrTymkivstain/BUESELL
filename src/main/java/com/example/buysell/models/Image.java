package com.example.buysell.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "size")
    private Long size;
    @Column(name = "name")
    private String name;
    @Column(name = "originalfilename")
    private String originalFileName;
    @Column(name = "contenttype")
    private String contentType;
    @Column(name = "ispreviewimage")
    private boolean isPreviewImage;
    @Lob
    @Type(type = "org.hibernate.type.ImageType")

    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER )
    private Product product;
}
