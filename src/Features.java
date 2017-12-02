public interface Features {

    /* ---------------------------------------- Required Variable ------------------------------------------- */
    public static final int ROWS_OF_INVADERS = 5;
    public static final int COLS_OF_INVADERS = 10;
    public static final int RATE_OF_INVADERS = 10; // will drop down every thirty seconds
    public static final int INV_RATE_OF_FIRE = 5;  // one invader will shoot randomly every 5 seconds
    public static final int DEFENDER_LIVES   = 3;

    /* ------------------------------------------ Other Variables -------------------------------------------- */

    public static final int INVADER_SPACING_X = 4;  // the large the number the smaller the spacing (Suggested 4)
    public static final int INVADER_SPACING_Y = 4;  // the large the number the smaller the spacing (Suggested 4)
    public static final int X_MOVE_INVADERS   = 10;
    public static final int Y_MOVE_INVADERS   = 10;
    public static final int SPEED_OF_SHOT     = 10;
}
