package factory;

import command.*;
import memento.CareTaker;
import system.Receiver;

public class CommandFactory {
    private Receiver receiver;
    private CareTaker careTaker;

    public CommandFactory(Receiver receiver, CareTaker careTaker) {
        this.receiver = receiver;
        this.careTaker = careTaker;
    }

    public Command createCommand(String commandType, Object[] params) {
        switch (commandType) {
            case "create":
                return new CreatePlayerCommand(receiver, careTaker, (String)params[0], (String)params[1]);
            case "add":
                return new AddHeroCommand(receiver, careTaker, (String)params[0], (String)params[1], (String)params[2]);
            case "delete":
                return new DeleteHeroCommand(receiver, careTaker, (String)params[0]);
            case "select":
                return new SelectPlayerCommand(receiver, careTaker, (String)params[0]);
            case "skill":
                return new CallHeroSkillCommand(receiver, careTaker, (String)params[0]);
            case "show":
                return new ShowPlayerCommand(receiver, careTaker);
            case "display":
                return new DisplayAllPlayersCommand(receiver, careTaker);
            case "change":
                return new ChangePlayerNameCommand(receiver, careTaker, (String)params[0], (String)params[1]);
            case "undo":
                return new UndoCommand(receiver, careTaker);
            case "redo":
                return new RedoCommand(receiver, careTaker);
            case "list":
                return new ListUndoRedoCommand(receiver, careTaker);
            case "exit":
                return new ExitSystemCommand(receiver, careTaker);
            default:
                throw new IllegalArgumentException("Unknown command type: " + commandType);
        }
    }
} 