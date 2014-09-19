package processscheduling;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.DemostrationInterface;

/**
 *
 * @author Nands
 */
public class ProcessScheduling {

    /**
     * @param args the command line arguments
     */
//    TimeSlicer timeSlicer;
    Dispatcher dispatcher;
    Cpu cpu;
    long timeQuantum;
    Process currentProcess;

    private ArrayList<Process> processes;

    public Cpu getCpu() {
        return cpu;
    }

    public ProcessScheduling(long timeQuantum) {
        this.timeQuantum = timeQuantum;
        //this.timeSlicer = new TimeSlicer(timeQuantum);
        this.cpu = new Cpu(timeQuantum);
        this.dispatcher = new Dispatcher(cpu, timeQuantum);

        processes = new ArrayList<>();
        //timeSlicer.addObserver(dispatcher);

    }

    public void simulate() {
        //timeSlicer.startTimer();
        currentProcess = dispatcher.dispatch();

    }

    public Process getCurrentProcess() {
        return currentProcess;
    }

    public void createTenProcesses() {
        for (int i = 0; i < 10; i++) {
            Process newProcess = new Process((i + 1), "Ready", (i + 1) * 1000, 0, 0, (i + 1) * 1000);
            dispatcher.addNewProcess(newProcess);
            processes.add(newProcess);
        }

        //dispatcher.dispatch();
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            DemostrationInterface demo = new DemostrationInterface();
            demo.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProcessScheduling.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ProcessScheduling.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ProcessScheduling.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ProcessScheduling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the Processes
     */
    public ArrayList<Process> getProcesses() {
        return processes;
    }

}
