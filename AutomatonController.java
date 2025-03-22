/**
 * Set up and control an elementary cellular automaton.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version  2016.02.29
 * 
 * 25. yes its the same pattern
 * 26. theres 10, it specified the value to each element, its used to fill it with one element.
 * 27. the patterns stays the same, its just the pattern is not in the middle its changed more towars the left.
 * 
 * 
 * 
 */
public class AutomatonController
{
    // The automaton.
    private Automaton auto;
    
    /**
     * Create an AutomatonController.
     * @param numberOfCells The number of cells in the automaton.
     */
    public AutomatonController(int numberOfCells)
    {
        auto = new Automaton(numberOfCells);
        auto.print();
    }
    
    /**
     * Create an AutomatonController with
     * a default number of cells.
     */
    public AutomatonController()
    {
        this(50);
    }
    
    /**
     * Run the automaton for the given number of steps.
     * @param numSteps The number of steps.
     */
    public void run(int numSteps)
    {
        for(int step = 1; step <= numSteps; step++) {
            step();
        }
    }
    
    /**
     * Run the automaton for a single step.
     */
    public void step()
    {
        auto.update();
        auto.print();
    }
    
    /**
     * Reset the automaton.
     */
    public void reset()
    {
        auto.reset();
        auto.print();
    }
}
