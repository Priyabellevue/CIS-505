

import java.util.List;

public interface GenericDao<E, K> { /* This is a GenericDao that establishes abstract methods. */
    List <E> findAll(); /* This is an abstract method to findAll. */
    E findBy(K key); /* This is an abstract method to findBy. */
    void insert(E entity); /* This is an abstract method to insert an entity. */
} /* End GenericDao class. */