package org.apache.mina.core.session;

/**
 * @author 昨夜不是我
 * @date 2015年4月25日
 */
public interface IoSession {

	void close();

	void close(boolean b);

}
