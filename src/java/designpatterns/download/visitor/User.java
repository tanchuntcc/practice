package designpatterns.download.visitor;

//抽象元素
public interface User {
	void accept(Visitor visitor);
}
