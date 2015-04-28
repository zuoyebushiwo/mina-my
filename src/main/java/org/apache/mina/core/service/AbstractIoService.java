package org.apache.mina.core.service;

import java.util.Map;
import java.util.Set;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilterChainBuilder;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.core.session.IoSessionDataStructureFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractIoService implements IoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractIoService.class);
	
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
