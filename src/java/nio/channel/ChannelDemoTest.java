package nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author 谭春
 * Date: 2020/4/29
 * Description:
 */
public class ChannelDemoTest {
    public static void main(String[] args) throws IOException {
        System.out.println("------使用getChannel()获取通道完成文件复制------");
        FileInputStream fis = new FileInputStream("e:/1.gif");;
        FileOutputStream fos = new FileOutputStream("e:/copy.gif");;
        //①获取通道
        FileChannel inChannel = fis.getChannel();;
        FileChannel outChannel = fos.getChannel();;
        //②分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //③将通道中的数据存入缓冲区中
        while(inChannel.read(buf) != -1){
            buf.flip(); //切换读取数据的模式
            //④将缓冲区中的数据写入通道中
            outChannel.write(buf);
            buf.clear(); //清空缓冲区
        }
        fis.close();fos.close();inChannel.close();outChannel.close();
        System.out.println("------使用open()获取通道完成文件复制-------");

        FileChannel inChannelo = FileChannel.open(Paths.get("e:/1.gif"), StandardOpenOption.READ);
        FileChannel outChannelo = FileChannel.open(Paths.get("e:/openCopy.gif"), StandardOpenOption.WRITE,
                StandardOpenOption.READ, StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannelo.map(FileChannel.MapMode.READ_ONLY, 0, inChannelo.size());
        MappedByteBuffer outMappedBuf = outChannelo.map(FileChannel.MapMode.READ_WRITE, 0, inChannelo.size());

        //直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);
        inChannelo.close();
        outChannelo.close();
        System.out.println("------使用transferFrom/transferTo完成文件复制-------");
        FileChannel inChannelt = FileChannel.open(Paths.get("e:/1.gif"), StandardOpenOption.READ);
        FileChannel outChannelt = FileChannel.open(Paths.get("e:/tansCopy.gif"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
//		inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannelt.transferFrom(inChannelt, 0, inChannelt.size());
        inChannelt.close();
        outChannelt.close();


        RandomAccessFile raf1 = new RandomAccessFile("1.txt", "rw");
        //1. 获取通道
        FileChannel channel1 = raf1.getChannel();
        //2. 分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        //3. 分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel1.read(bufs);
        for (ByteBuffer byteBuffer : bufs) {
            byteBuffer.flip();
        }
        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("-----------------");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));
        //4. 聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("2.txt", "rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);



        Charset cs1 = Charset.forName("GBK");
        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();
        //获取解码器
        CharsetDecoder cd = cs1.newDecoder();
        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("tcc");

        cBuf.flip();
        //编码
        ByteBuffer bBuf = ce.encode(cBuf);
        for (int i = 0; i < 3; i++) {
            System.out.println(bBuf.get());
        }
        //解码
        bBuf.flip();
        CharBuffer cBuf2 = cd.decode(bBuf);
        System.out.println(cBuf2.toString());
        System.out.println("------------------------------------------------------");
        Charset cs2 = Charset.forName("UTF-8");
        bBuf.flip();
        CharBuffer cBuf3 = cs2.decode(bBuf);
        System.out.println(cBuf3.toString());
    }
}

