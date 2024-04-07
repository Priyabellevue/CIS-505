/*
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved
*/
package Module_4.BowlingShopApp;

import java.util.LinkedList;

public class GenericQueue<E> {
    private LinkedList<E> list = new LinkedList<E>(); /* This establishes a new LinkedList as a Generic Queue. */

    /* This method adds an item to the queue. */
    public void enqueue(E item){
        list.addFirst(item);
    }
    /* This method removes an item from the queue. */
    public Object dequeue(){
        return list.removeFirst();
    }
    /* This method returns the size of the queue. */
    public int size(){
        return list.size();
    }
}/* End Generic Queue Class. */