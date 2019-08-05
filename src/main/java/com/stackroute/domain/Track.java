package com.stackroute.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Track {

    @Id
    private int id;
    private String name;
    private String comment;
}
