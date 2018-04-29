package RoundRobinSimulation;


public class Job {
    private int time;

    public Job(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void subtract(int time) {
        this.time -= time;
    }
    @Override
    public String toString(){
        return time + "";
    }
}