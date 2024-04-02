package messagerie;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TaskManagerImpl extends UnicastRemoteObject implements TaskManager {
    private List<String> taskList;

    public TaskManagerImpl() throws RemoteException {
        taskList = new ArrayList<>();
    }

    @Override
    public void addTask(String task) throws RemoteException {
        taskList.add(task);
        System.out.println("Task added: " + task);
    }

    @Override
    public void removeTask(String task) throws RemoteException {
        if (taskList.remove(task)) {
            System.out.println("Task removed: " + task);
        } else {
            System.out.println("Task not found: " + task);
        }
    }

    @Override
    public List<String> getTaskList() throws RemoteException {
        return new ArrayList<>(taskList);
    }
}
