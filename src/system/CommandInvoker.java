package system;

import command.Command;
import memento.CareTaker;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CommandInvoker {
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();
    private CareTaker careTaker = new CareTaker();
    private static final int MAX_UNDO_LEVELS = 20;

    public void executeCommand(Command command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
        validateUndoLevel();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }

    private void validateUndoLevel() {
        while (undoStack.size() > MAX_UNDO_LEVELS) {
            undoStack.remove(0);
        }
    }

    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    public boolean canRedo() {
        return !redoStack.isEmpty();
    }

    public void showHistory() {
    }

    public List<String> getUndoList() {
        return null;
    }

    public List<String> getRedoList() {
        return null;
    }

    public void clearHistory() {
        undoStack.clear();
        redoStack.clear();
    }
} 