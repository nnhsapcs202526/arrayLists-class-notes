import java.util.ArrayList;

/**
 * The model for radar scan and accumulator
 * 
 * @author (name)
 * @version (date)
 */
public class Radar
{
    
    // stores whether each cell triggered detection for the current scan of the radar
    // (true represents a detected monster, which may be a false positive)
    private ArrayList<ArrayList<Boolean>> currentScan;
    
    // value of each cell is incremented for each scan in which that cell triggers
    //      detection
    private ArrayList<ArrayList<Integer>> accumulator;

    // location of the monster
    private Location monsterLocation;

    // probability that a cell will trigger a false detection (must be >= 0 and < 1)
    private double noiseFraction;
    
    // number of scans of the radar since construction
    private int numScans;

    /**
     * Constructor for objects of class Radar
     * 
     * @param   rows    the number of rows in the radar grid
     * @param   cols    the number of columns in the radar grid
     */
    public Radar(int rows, int cols)
    {
        // initialize the currentScan and accumulator as ArrayLists
        this.currentScan = new ArrayList<ArrayList<Boolean>>(rows);
        this.accumulator = new ArrayList<ArrayList<Integer>>(rows);
        for (int r = 0; r < rows; r++)
        {
            ArrayList<Boolean> scanRow = new ArrayList<Boolean>(cols);
            ArrayList<Integer> accRow = new ArrayList<Integer>(cols);
            for (int c = 0; c < cols; c++)
            {
                scanRow.add(Boolean.FALSE);
                accRow.add(Integer.valueOf(0));
            }
            this.currentScan.add(scanRow);
            this.accumulator.add(accRow);
        }
        
        // randomly set the location of the monster (can be explicity set through the
        //  setMonsterLocation method for the unit test
        int row = (int)(Math.random() * rows);
        int col = (int)(Math.random() * cols);
        this.monsterLocation = new Location(row, col);
        
        this.noiseFraction = 0.05;
        this.numScans= 0;
    }
    
    /**
     * Performs a scan of the radar. Noise is injected into the grid and the accumulator
     *      is updated.
     * 
     */
    public void scan()
    {
        /*
         *  algorithm for performing a scan:
         *      1. set all cells in the currentScan 2D ArrayList to false
         *      2. set the location of the monster in the currentScan 2D ArrayList by invoking the setMonsterLocation method
         *      3. inject noise into the grid by invoking the injectNoise method
         *      4. update the accumulator 2D ArrayList based on the state of the currentScan
         *          2D ArrayList
         *      5. increment the numScans instance variable
         */
        
        
        //
        // !!! add code here !!!
        //
        
        
    }

    /**
     * Sets the location of the monster
     * 
     * @param   loc     the location where the monster is located
     * @pre loc must be within the bounds of the radar grid
     */
    public void setMonsterLocation(Location loc)
    {
        // remember the monster's location
        this.monsterLocation = loc;
        
        // update the radar grid to show that something was detected at the specified
        //      location
        this.currentScan.get(this.monsterLocation.getRow()).set(this.monsterLocation.getCol(), Boolean.TRUE);
    }
    
     /**
     * Sets the probability that a given cell will generate a false detection
     * 
     * @param   fraction    the probability that a given cell will generate a false
     *                          detection expressed as a fraction (must be >= 0 and < 1)
     */
    public void setNoiseFraction(double fraction)
    {
        this.noiseFraction = fraction;
    }
    
    /**
     * Returns true if the specified location in the radar grid triggered a detection.
     * 
     * @param   loc     the location to query for detection
     * @return true if the specified location in the radar grid triggered a detection
     */
    public boolean isDetected(Location loc)
    {
        return this.currentScan.get(loc.getRow()).get(loc.getCol()).booleanValue();
    }

    /**
     * Returns a Location object containing the row and column of the detected monster based on analyzing the
     *  accumulator (NOT based on the monsterLocationinstance variable).
     * 
     * @return the location of the detected monster
     */
    public Location findMonster()
    {
        //
        // !!! add code here !!!
        //
        return null;
    }
    
    /**
     * Returns the number of times that the specified location in the radar grid has triggered a
     *  detection since the constructor of the radar object.
     * 
     * @param   loc     the location to query for accumulated detections
     * @return the number of times that the specified location in the radar grid has
     *          triggered a detection since the constructor of the radar object
     */
    public int getAccumulatedDetection(Location loc)
    {
        return accumulator.get(loc.getRow()).get(loc.getCol()).intValue();
    }
    
    /**
     * Returns the number of rows in the radar grid
     * 
     * @return the number of rows in the radar grid
     */
    public int getNumRows()
    {
        return currentScan.size();
    }
    
    /**
     * Returns the number of columns in the radar grid
     * 
     * @return the number of columns in the radar grid
     */
    public int getNumCols()
    {
        return currentScan.get(0).size();
    }
    
    /**
     * Returns the number of scans that have been performed since the radar object was
     *      constructed
     * 
     * @return the number of scans that have been performed since the radar object was
     *      constructed
     */
    public int getNumScans()
    {
        return numScans;
    }
    
    /**
     * Sets cells as falsely triggering detection based on the specified probability
     * 
     */
    private void injectNoise()
    {
        /*
         * Iterate through all cells in the currentScan 2D array to inject noise by
         * setting false positives (detected monster where is there none) or false
         * negatives (missed detection of a monster where is one). The noiseFraction
         * instance variable is the probability that a given cell will be detected as
         * a false positive or false negative. You must handle the cell containing the
         * monster as a special case since, if noise is being injected into that cell,
         * that is a false negative and the cell must be set to false.
         */
        int noiseProbability = (int)(1/this.noiseFraction);

        for(int row = 0; row < this.currentScan.size(); row++)
        {
            for(int col = 0; col < this.currentScan.get(row).size(); col++)
            {
                int willThereBeNoise = (int)(Math.random()*noiseProbability);
                if((row == monsterLocation.getRow()) && (col == monsterLocation.getCol()))
                {
                    if(willThereBeNoise == 0)
                    {
                        this.currentScan.get(row).set(col, Boolean.FALSE);
                    }
                    continue;
                }
                if(willThereBeNoise == 0)
                {
                    this.currentScan.get(row).set(col, Boolean.TRUE);
                }
            }
        }
    }
    
}
