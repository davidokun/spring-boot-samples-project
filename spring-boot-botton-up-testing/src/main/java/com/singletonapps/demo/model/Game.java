package com.singletonapps.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long yearPublished;
    private LocalDateTime createOn;
}