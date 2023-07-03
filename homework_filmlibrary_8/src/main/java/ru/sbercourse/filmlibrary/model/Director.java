package ru.sbercourse.filmlibrary.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "directors")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@SequenceGenerator(name = "default_gen", sequenceName = "directors_seq", allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "jsonId")
public class Director extends GenericModel{

    @Column(name = "directors_fio", nullable = false)
    private String directorsFio;

    @Column(name = "position", nullable = false)
    private String position;

    @ToString.Exclude
    @ManyToMany(mappedBy = "directors")
    private Set<Film> films;
}
