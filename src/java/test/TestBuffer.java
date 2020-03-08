package test;

import java.nio.ByteBuffer;

/**
 * @author 谭春
 * Date: 2020/2/18
 * Description:
 */
public class TestBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(1024);

        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());



    }
}

