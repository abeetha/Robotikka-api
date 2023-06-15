package com.bootcamp.robotikka.robotikkaapi.entity.share;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class FileResource {
    @Column(name="directory_name")
    private String directory;
    private String hash;
    private String resourceUrl;
    private String fileName;

}
