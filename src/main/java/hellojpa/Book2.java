package hellojpa;

import jakarta.persistence.Entity;

@Entity
public class Book2 extends Item2
{
    private String author;
    private String isbn;
}
