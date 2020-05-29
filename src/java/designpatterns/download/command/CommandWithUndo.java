package designpatterns.download.command;

//命令接口
public interface CommandWithUndo extends Command {
	void undo();
}
