package com.gemini.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @author xiaocuzi
 * @package com.gemini.buffer
 * @classname: Buffers
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/7 15:44
 * @since 1.0.0
 */
public class Buffers {
    ByteBuffer readBuffer;
    ByteBuffer writeBuffer;


    public Buffers(int readBufferCpacity, int writeBufferCapacity) {
        this.readBuffer = ByteBuffer.allocate(readBufferCpacity);
        this.writeBuffer = ByteBuffer.allocate(writeBufferCapacity);
    }

    public ByteBuffer getReadBuffer() {
        return readBuffer;
    }

    public ByteBuffer getWriteBuffer() {
        return writeBuffer;
    }
}
