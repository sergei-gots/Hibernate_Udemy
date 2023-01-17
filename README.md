# Hibernate_UDEMY

To the Spring Framework Course by Nail Alishev
https://www.udemy.com/course/spring-alishev/learn/lecture/31012638#overview


<h2>Entity</h2>
<div>
<code>
    package org.example.model;
    
    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.Table;

    @Entity
    @Table(name = "Person")
    public class Person {
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

    ...
    }
</code>
</div>

<b>strategy = GenerationType.IDENTITY</b> means
that the process of key generation for id will be
completely performed on the Postgres-side.

An Example code for <b>strategy = GenerationType.SEQUENCE</b>:

<div>
<code>

    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "seq_generator_person")
    @SequenceGenerator(name = "seq_generator_person",
        sequenceName = "person_id_seq",
        allocationSize = 1)
</code>
</div>



