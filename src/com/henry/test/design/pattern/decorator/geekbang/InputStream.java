package com.henry.test.design.pattern.decorator.geekbang;


import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public abstract class InputStream {
    //...
    public int read(byte b[]) throws IOException {
        return read(b, 0, b.length);
    }

    public int read(byte b[], int off, int len) throws IOException {
        //...
        return 1;
    }

    public long skip(long n) throws IOException {
        //...
        return 1L;
    }

    public int available() throws IOException {
        log.info("come here!");
        return 0;
    }

    public void close() throws IOException {
        log.info("come here!");
    }

    public synchronized void mark(int readlimit) {}

    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    public boolean markSupported() {
        return false;
    }
    {
        new Runnable() {

            @Override public void run() {

            }
        };
    }

    class A {

    }
}

@Slf4j
class FileInputStream extends InputStream {
    private String path;
    public FileInputStream(String path) {
        this.path = path;
    }
    public void close() throws IOException {
        log.info("come here!");
        super.close();
    }
}

@Slf4j
class FilterInputStream extends  InputStream {
    private InputStream is;
    public FilterInputStream(InputStream is) {
        this.is = is;
    }
    public void close() throws IOException {
        log.info("come here!");
        is.close();
    }
}

@Slf4j
class BufferedInputStream extends InputStream {
    protected volatile InputStream in;

    protected BufferedInputStream(InputStream in) {
        this.in = in;
    }

    //...实现基于缓存的读数据接口...
    public int available() throws IOException {
        log.info("come here!");
        return super.available();
    }

    public void close() throws IOException {
        log.info("come here!");
        in.close();
    }
}

@Slf4j
class BufferedInputStream2 extends FilterInputStream {
    public BufferedInputStream2(InputStream in) {
        super(in);
    }

    //...实现基于缓存的读数据接口...
    public int available() throws IOException {
        log.info("come here!");
        return super.available();
    }

//    public void close() throws IOException {
//        log.info("come here!");
//        in.close();
//    }
}

class DataInputStream extends InputStream {
    protected volatile InputStream in;

    protected DataInputStream(InputStream in) {
        this.in = in;
    }

    //...实现读取基本类型数据的接口
}

class App {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("/user/wangzheng/test.txt");
        InputStream bin = new BufferedInputStream(is);
        InputStream bin2 = new BufferedInputStream2(is);
//        bin.available();
//        bin.close();
        bin2.close();
        InputStream din = new DataInputStream(bin);
    }
}
