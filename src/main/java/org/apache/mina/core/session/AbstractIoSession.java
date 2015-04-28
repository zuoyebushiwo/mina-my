package org.apache.mina.core.session;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoService;

public abstract class AbstractIoSession implements IoSession {

	private final IoHandler handler;
	
	protected IoSessionConfig config;
	
	private final IoService service;
	
}
