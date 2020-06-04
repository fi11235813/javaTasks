package telran.lessons._38_TcpJava.bullsCowsGameTcpServer;

import telran.lessons._38_TcpJava.net.RequestJava;
import telran.lessons._38_TcpJava.net.ResponseJava;
import telran.lessons._38_TcpJava.net.TcpResponseCode;
import telran.lessons._38_TcpJava.net.server.ProtocolJava;

public class ProtocolJavaImpl implements ProtocolJava {

	private GuessGame game;

	public ProtocolJavaImpl(GuessGame game) {
		this.game = game;
	}

	@Override
	public ResponseJava getResponse(RequestJava request) {

		switch (request.requestType) {

		case "start":
			return new ResponseJava(TcpResponseCode.OK, game.startGame());
		case "prompt":
			return new ResponseJava(TcpResponseCode.OK, game.prompt());
		case "move":
			return new ResponseJava(TcpResponseCode.OK, game.move((String) request.requestData));
		case "is_finished":
			return new ResponseJava(TcpResponseCode.OK, game.isFinished());
		default:
			return new ResponseJava(TcpResponseCode.UNKNOWN, "");
		}
	}
}
