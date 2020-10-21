package com.bouali.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Todo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    private ZonedDateTime startDate;

    private boolean done;

    private boolean favorite;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnore
    private Category category;
}
