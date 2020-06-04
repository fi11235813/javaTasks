package telran.lessons._38_TcpJava.net.server;

import telran.lessons._38_TcpJava.net.RequestJava;
import telran.lessons._38_TcpJava.net.ResponseJava;

public interface ProtocolJava {

	ResponseJava getResponse(RequestJava request);

}
