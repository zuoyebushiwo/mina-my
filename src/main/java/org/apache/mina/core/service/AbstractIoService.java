package org.apache.mina.core.service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilterChainBuilder;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.session.DefaultIoSessionDataStructureFactory;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.core.session.IoSessionDataStructureFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractIoService implements IoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractIoService.class);
	
	private static final AtomicInteger id = new AtomicInteger();
	
	private final String threadName;
	
	private final Executor executor;
	
	private final boolean createdExecutor;
	
	private IoHandler handler;
	
	protected final IoSessionConfig sessionConfig;
	
	private final IoServiceListener serviceActivationListener = new IoServiceListener() {
		
		public void serviceActivated(IoService service) throws Exception {
			// Update lastIoTime.
			AbstractIoService s = (AbstractIoService) service;
			IoServiceStatistics _stats = s.getStatistics();
			_stats.setLastReadTime(s.getActivationTime());
            _stats.setLastWriteTime(s.getActivationTime());
            _stats.setLastThroughputCalculationTime(s.getActivationTime());

		}
		
		public void serviceDeactivated(IoService service) throws Exception {
            // Empty handler
        }

        public void serviceIdle(IoService service, IdleStatus idleStatus) throws Exception {
            // Empty handler
        }

        public void sessionCreated(IoSession session) throws Exception {
            // Empty handler
        }

        public void sessionClosed(IoSession session) throws Exception {
            // Empty handler
        }

        public void sessionDestroyed(IoSession session) throws Exception {
            // Empty handler
        }
        
	};
	
	private IoFilterChainBuilder filterChainBuilder = new DefaultIoFilterChainBuilder();
	
	private IoSessionDataStructureFactory sessionDataStructureFactory = new DefaultIoSessionDataStructureFactory();
	
	private final IoServiceListenerSupport listeners;
	
	protected final Object disposalLock = new Object();
	
	private volatile boolean disposing;
	
	private volatile boolean disposed;
	
	public TransportMetadata getTransportMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addListener(IoServiceListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void removeListener(IoServiceListener listener) {
		// TODO Auto-generated method stub
		
	}

	public boolean isDisposing() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isDisposed() {
		// TODO Auto-generated method stub
		return false;
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void dispose(boolean awaitTermination) {
		// TODO Auto-generated method stub
		
	}

	public IoHandler getHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setHandler(IoHandler handler) {
		// TODO Auto-generated method stub
		
	}

	public Map<Long, IoSession> getManagedSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getManagedSessionCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public IoSessionConfig getSessionConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public IoFilterChainBuilder getFilterChainBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFilterChainBuilder(IoFilterChainBuilder builder) {
		// TODO Auto-generated method stub
		
	}

	public DefaultIoFilterChainBuilder getFilterChain() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	public long getActivationTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Set<WriteFuture> broadcast(Object message) {
		// TODO Auto-generated method stub
		return null;
	}

	public IoSessionDataStructureFactory getSessionDataStructureFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSessionDataStructureFactory(
			IoSessionDataStructureFactory sessionDataStructureFactory) {
		// TODO Auto-generated method stub
		
	}

	public int getScheduledWriteBytes() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getScheduledWriteMessages() {
		// TODO Auto-generated method stub
		return 0;
	}

	public IoServiceStatistics getStatistics() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
