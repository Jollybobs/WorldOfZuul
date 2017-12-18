package business;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marc
 */
class TimeHandler {
    double startTime;
    public TimeHandler() {
        startTime = System.currentTimeMillis();
    }
    
    /**
     * Reset the starting time.
     */
    protected void resetTime(){
        startTime = System.currentTimeMillis();
    }
    
    /**
     * get the time since start or last reset.
     * 
     * @return double time since start or reset.
     */
    protected String getTimeSinceStart(){
        double timeSinceStart = System.currentTimeMillis() - startTime;
        double allSecondsSinceStart = timeSinceStart/1000;
        double secondsSinceStart = allSecondsSinceStart%60;
        double minutesSinceStart = allSecondsSinceStart/60;
        String timeGone = (int)minutesSinceStart + ":" + (int)secondsSinceStart;
        return timeGone;
    }

    /**
     * get the time at start or reset
     * 
     * @return double time at start or reset
     */
    protected double getStartTime() {
        return startTime;
    }
}
