package designpatterns.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.zip.GZIPInputStream;

/**
 * @author 谭春
 * Date: 2020/3/18
 * Description:
 */
public abstract class Decorator extends SpanNode {

    protected final SpanNode textNode;

    public Decorator(SpanNode textNode) {
        this.textNode = textNode;
    }

    @Override
    public void setText(String text) {
        this.textNode.setText(text);
    }

    public static void main(String[] args) {
        SpanNode spanNode = new SpanNode();
        BoDecorator boDecorator = new BoDecorator(spanNode);
        UiDecorator uiDecorator = new UiDecorator(boDecorator);
        System.out.println(boDecorator.getTest());
        System.out.println(uiDecorator.getTest());
    }
}

