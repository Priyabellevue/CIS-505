

import java.util.ArrayList;
import java.util.List;

public class MemComposerDao implements ComposerDao{ /* This class implements our abstract interface ComposerDao. */
    /* This is the attribute of MemComposerDao. */
    private List<Composer> composers;

    /* This is a constructor that creates 5 default composer objects and puts them in the list composers. */
    public MemComposerDao() {
        this.composers = new ArrayList<>();
        // create a default list of five composer objects
        this.composers.add(new Composer(1007,"Ludwig Van Beethoven","Classical"));
        this.composers.add(new Composer(1008, "Johann Sebastian Bach", "Classical"));
        this.composers.add(new Composer(1009, "Wolfgang Amadeus Mozart", "Classical"));
        this.composers.add(new Composer(1010, "Johannes Brahms", "Classical"));
        this.composers.add(new Composer(1011, "Joseph Haydn", "Classical"));
    }
    
    /* This overrides the findAll method from our GenericDao class extended to ComposerDao. It returns all of our composers in the list. */
    
    @Override
    public List<Composer> findAll() {
        System.out.println("  --DISPLAYING COMPOSERS--");
        return this.composers;
    }

    /* This overrides the findBy method from our GenericDao class extended to ComposerDao. It returns a composer based on the ID selected by the user. */
    @Override
    public Composer findBy(Integer id){
        System.out.println("  --DISPLAYING COMPOSERS--");
        for (Composer composer : composers){ /* This iterates through the composer list. */
            if (id.equals(composer.getId())){ /* This selects a composer based on the ID and returns it. */
                return composer;
            }
        }
        return null;
    }
    /* This overrides our void insert method from the GenericDao class extended to ComposerDao. It adds a composer to the composer list. */
    @Override
    public void insert(Composer newComposer){
        composers.add(newComposer);
    }
}/* End MemComposerDao class. */
