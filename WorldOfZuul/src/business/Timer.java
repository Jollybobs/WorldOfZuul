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
class Timer {
    double startTime;
    public Timer() {
        startTime = System.currentTimeMillis();
    }
            
    
    protected void resetTime(){
        startTime = System.currentTimeMillis();
    }
    
    protected String getTimeSinceStart(){
        double timeSinceStart = System.currentTimeMillis() - startTime;
        double allSecondsSinceStart = timeSinceStart/1000;
        double secondsSinceStart = allSecondsSinceStart%60;
        double minutesSinceStart = allSecondsSinceStart/60;
        String timeGone = (int)minutesSinceStart + ":" + (int)secondsSinceStart;
        return timeGone;
    }

    protected double getStartTime() {
        return startTime;
    }
    
}
