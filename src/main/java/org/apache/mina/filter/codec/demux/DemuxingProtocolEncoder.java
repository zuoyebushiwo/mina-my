package org.apache.mina.filter.codec.demux;

import java.util.Map;

import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.util.CopyOnWriteMap;

public class DemuxingProtocolEncoder implements ProtocolEncoder {
	
	private final AttributeKey STATE = new AttributeKey(getClass(), "state");
	
	@SuppressWarnings("rawtypes")
	private final Map<Class<?>, MessageEncoderFactory> type2encoderFactory = new CopyOnWriteMap<Class<?>, MessageEncoderFactory>();
	
	private static final Class<?>[] EMPTY_PARAMS = new Class[0];
	
	public DemuxingProtocolEncoder() {
        // Do nothing
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
    public void addMessageEncoder(Class<?> messageType, Class<? extends MessageEncoder> encoderClass) {
        if (encoderClass == null) {
            throw new IllegalArgumentException("encoderClass");
        }

        try {
            encoderClass.getConstructor(EMPTY_PARAMS);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("The specified class doesn't have a public default constructor.");
        }

        boolean registered = false;
        if (MessageEncoder.class.isAssignableFrom(encoderClass)) {
            addMessageEncoder(messageType, new DefaultConstructorMessageEncoderFactory(encoderClass));
            registered = true;
        }

        if (!registered) {
            throw new IllegalArgumentException("Unregisterable type: " + encoderClass);
        }
    }

	private void addMessageEncoder(
			Class<?> messageType,
			DefaultConstructorMessageEncoderFactory defaultConstructorMessageEncoderFactory) {
		// TODO Auto-generated method stub
		
	}

	public void encode(IoSession session, Object message,
			ProtocolEncoderOutput out) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void dispose(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	private static class DefaultConstructorMessageEncoderFactory<T> implements MessageEncoderFactory<T> {
		
		private final Class<MessageEncoder<T>> encoderClass;
		
		private DefaultConstructorMessageEncoderFactory(Class<MessageEncoder<T>> encoderClass) {
            if (encoderClass == null) {
                throw new IllegalArgumentException("encoderClass");
            }

            if (!MessageEncoder.class.isAssignableFrom(encoderClass)) {
                throw new IllegalArgumentException("encoderClass is not assignable to MessageEncoder");
            }
            this.encoderClass = encoderClass;
        }

		public MessageEncoder<T> getEncoder() throws Exception {
			return encoderClass.newInstance();
		}
		
	}

}
