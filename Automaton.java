import java.util.Arrays;

/**
 * Model a 1D elementary cellular automaton.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version  2016.02.29 - version 1
 */
public class Automaton
{
    // The number of cells.
    private final int numberOfCells;
    // The state of the cells.
    private int[] state;
    
    /**
     * Create a 1D automaton consisting of the given number of cells.
     * @param numberOfCells The number of cells in the automaton.
     */
    public Automaton(int numberOfCells)
    {
        this.numberOfCells = numberOfCells;
        state = new int[numberOfCells];
        // Seed the automaton with a single 'on' cell in the middle.
        state[numberOfCells / 7] = 1;
    }
    
    /**
     * Print the current state of the automaton.
     */
    public void print()
    {
        for(int cellValue : state) {
            if(cellValue == 1) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }   
    
    /**
     * Update the automaton to its next state.
     */
    public void update()
    {
        // Build the new state in a separate array.
        
        int[] nextState = new int[state.length];
        
        // Naively update the state of each cell
        // based on the state of its two neighbors.
        /**for(int i = 0; i < state.length; i++) {
            int left, center, right;
            if(i == 0) {
                left = 0;
            }
            else {
                left = state[i - 1];
            }
            
            //question 28
            left = i==0 ? 0 : state[i-1];
            
            center = state[i];
            
            right = i + 1 < state.length ? state[i + 1] : 0;
            
            if(i + 1 < state.length) {
                right = state[i + 1];
            }
            else {
                right = 0;
            }
            nextState[i] = (left + center + right) % 2;
        }
        state = nextState;*/
        //questoon 31
        int left = 0;
        int center = state[0];
        for (int i=0; i<state.length; i++){
            int right = i + 1 < state.length ? state[i+1] : 0;
            //nextState[i] = (left + center + right) % 2;
            nextState[i] = calculateNextState(left, center, right);
            left = center;
            center = right;
        }   
    }
    
    //question 32
    public int calculateNextState(int left, int center, int right)
    {
        return (left + center + right) % 2;
    }
    
    /**
     * Reset the automaton.
     */
    public void reset()
    {
        Arrays.fill(state, 0);
        // Seed the automaton with a single 'on' cell.
        state[numberOfCells / 2] = 1;
            
    }
}
