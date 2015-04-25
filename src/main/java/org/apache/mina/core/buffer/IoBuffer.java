package org.apache.mina.core.buffer;

/**
 * A byte buffer used by MINA applications.
 * <p>
 * This is a replacement for {@link ByteBuffer}. Please refer to
 * {@link ByteBuffer} documentation for preliminary usage. MINA does not use NIO
 * {@link ByteBuffer} directly for two reasons:
 * <ul>
 * <li>It doesn't provide useful getters and putters such as <code>fill</code>,
 * <code>get/putString</code>, and <code>get/putAsciiInt()</code> enough.</li>
 * <li>It is difficult to write variable-length data due to its fixed capacity</li>
 * </ul>
 * </p>
 * 
 * <h2>Allocation</h2>
 * <p>
 * You can allocate a new heap buffer.
 * 
 * <pre>
 * IoBuffer buf = IoBuffer.allocate(1024, false);
 * </pre>
 * 
 * you can also allocate a new direct buffer:
 * 
 * <pre>
 * IoBuffer buf = IoBuffer.allocate(1024, true);
 * </pre>
 * 
 * or you can set the default buffer type.
 * 
 * <pre>
 * // Allocate heap buffer by default.
 * IoBuffer.setUseDirectBuffer(false);
 * // A new heap buffer is returned.
 * IoBuffer buf = IoBuffer.allocate(1024);
 * </pre>
 * 
 * </p>
 * 
 * <h2>Wrapping existing NIO buffers and arrays</h2>
 * <p>
 * This class provides a few <tt>wrap(...)</tt> methods that wraps any NIO
 * buffers and byte arrays.
 * 
 * <h2>AutoExpand</h2>
 * <p>
 * Writing variable-length data using NIO <tt>ByteBuffers</tt> is not really
 * easy, and it is because its size is fixed. {@link IoBuffer} introduces
 * <tt>autoExpand</tt> property. If <tt>autoExpand</tt> property is true, you
 * never get {@link BufferOverflowException} or
 * {@link IndexOutOfBoundsException} (except when index is negative). It
 * automatically expands its capacity and limit value. For example:
 * 
 * <pre>
 * String greeting = messageBundle.getMessage(&quot;hello&quot;);
 * IoBuffer buf = IoBuffer.allocate(16);
 * // Turn on autoExpand (it is off by default)
 * buf.setAutoExpand(true);
 * buf.putString(greeting, utf8encoder);
 * </pre>
 * 
 * The underlying {@link ByteBuffer} is reallocated by {@link IoBuffer} behind
 * the scene if the encoded data is larger than 16 bytes in the example above.
 * Its capacity will double, and its limit will increase to the last position
 * the string is written.
 * </p>
 * 
 * <h2>AutoShrink</h2>
 * <p>
 * You might also want to decrease the capacity of the buffer when most of the
 * allocated memory area is not being used. {@link IoBuffer} provides
 * <tt>autoShrink</tt> property to take care of this issue. If
 * <tt>autoShrink</tt> is turned on, {@link IoBuffer} halves the capacity of the
 * buffer when {@link #compact()} is invoked and only 1/4 or less of the current
 * capacity is being used.
 * <p>
 * You can also {@link #shrink()} method manually to shrink the capacity of the
 * buffer.
 * <p>
 * The underlying {@link ByteBuffer} is reallocated by {@link IoBuffer} behind
 * the scene, and therefore {@link #buf()} will return a different
 * {@link ByteBuffer} instance once capacity changes. Please also note
 * {@link #compact()} or {@link #shrink()} will not decrease the capacity if the
 * new capacity is less than the {@link #minimumCapacity()} of the buffer.
 * 
 * <h2>Derived Buffers</h2>
 * <p>
 * Derived buffers are the buffers which were created by {@link #duplicate()},
 * {@link #slice()}, or {@link #asReadOnlyBuffer()}. They are useful especially
 * when you broadcast the same messages to multiple {@link IoSession}s. Please
 * note that the buffer derived from and its derived buffers are not both
 * auto-expandable neither auto-shrinkable. Trying to call
 * {@link #setAutoExpand(boolean)} or {@link #setAutoShrink(boolean)} with
 * <tt>true</tt> parameter will raise an {@link IllegalStateException}.
 * </p>
 * 
 * <h2>Changing Buffer Allocation Policy</h2>
 * <p>
 * {@link IoBufferAllocator} interface lets you override the default buffer
 * management behavior. There are two allocators provided out-of-the-box:
 * <ul>
 * <li>{@link SimpleBufferAllocator} (default)</li>
 * <li>{@link CachedBufferAllocator}</li>
 * </ul>
 * You can implement your own allocator and use it by calling
 * {@link #setAllocator(IoBufferAllocator)}.
 * </p>
 * 
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public abstract class IoBuffer implements Comparable<IoBuffer> {

}
