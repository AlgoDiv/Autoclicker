import java.awt.Robot;
import java.awt.event.InputEvent;

public class Clicker {
    /**
     * Clicks specified amount of times where the user moved their mouse to.
     * Will return without click and system.log if an error is thrown
     *
     * @author Tyler Johnson
     * @param mouseButton Type of mouse click to be performed
     * @param clickCount Amount of times to click
     * @param clickDelay Time in between clicks
     * @param startDelay Time before beginning clicks
     */
    protected static void clickCount(int mouseButton, int clickCount, double clickDelay, double startDelay) {
        Robot r;
        try {
            r = new Robot();
        }
        catch(Exception e) {
            System.out.println("Error: Couldn't create robot in clickCreate");
            return;
        }
        // Wait the starting delay amount before beginning to click where ever the user moves their mouse to
        r.delay((int)(startDelay * 1000));

        // Save mouse button
        int clickType;
        switch(mouseButton)
        {
            case 1:
                clickType = InputEvent.BUTTON1_DOWN_MASK;
                break;
            case 2:
                clickType = InputEvent.BUTTON2_DOWN_MASK;
                break;
            case 3:
                clickType = InputEvent.BUTTON3_DOWN_MASK;
                break;
            default:
                System.out.println("Error: Invalid mouseButton passed to clickCount");
                return;
        }

        // Loop until the program has clicked the specified amount
        for(int c = 0; c < clickCount; c++) {
            r.mousePress(clickType);
            r.mouseRelease(clickType);
            // Do not delay after the final click
            if(c < clickCount - 1) {
                r.delay((int)(clickDelay * 1000));
            }
        }
    }

    /**
     * Clicks for specified amount of time where the user moved their mouse to.
     * Will return without click and system.log if an error is thrown.
     *
     * @author Tyler Johnson
     * @param mouseButton Type of mouse click to be performed
     * @param clickTime Amount of time to click for
     * @param clickDelay Time in between clicks
     * @param startDelay Time before beginning clicks
     */
    protected static void clickTime(int mouseButton, double clickTime, double clickDelay, double startDelay) {
        Robot r;
        try {
            r = new Robot();
        }
        catch(Exception e) {
            System.out.println("Error: Couldn't create robot in clickCreate");
            return;
        }
        // Wait the starting delay amount before beginning to click where ever the user moves their mouse to
        r.delay((int)(startDelay * 1000));

        // Save mouse button
        int clickType;
        switch(mouseButton)
        {
            case 1:
                clickType = InputEvent.BUTTON1_DOWN_MASK;
                break;
            case 2:
                clickType = InputEvent.BUTTON2_DOWN_MASK;
                break;
            case 3:
                clickType = InputEvent.BUTTON3_DOWN_MASK;
                break;
            default:
                System.out.println("Error: Invalid mouseButton passed to clickCount");
                return;
        }

        long start, end;
        start = end = System.currentTimeMillis();

        // Loop until the program has ran for time elapsed
        while(end - start < (long)(clickTime * 1000)) {
            r.mousePress(clickType);
            r.mouseRelease(clickType);
            r.delay((int)(clickDelay * 1000));
            end = System.currentTimeMillis();
        }
    }
}
