package telran.lessons._38_TcpJava.bullsCowsGameTcpServer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.function.Function;
import static telran.lessons._38_TcpJava.bullsCowsGameTcpServer.GuessGameApi.*;

import telran.lessons._38_TcpJava.net.RequestJava;
import telran.lessons._38_TcpJava.net.ResponseJava;
import telran.lessons._38_TcpJava.net.TcpResponseCode;
import telran.lessons._38_TcpJava.net.server.ProtocolJava;

public class ProtocolJavaImpl implements ProtocolJava {

	private GuessGame game;
	private HashMap<String, Function<Serializable, ResponseJava>> funMap;

	public ProtocolJavaImpl(GuessGame game) {
		this.game = game;
		fillFunMap();
	}

	private void fillFunMap() {
		funMap = new HashMap<>();
		funMap.put(START, this::startGame);
		funMap.put(PROMPT, this::prompt);
		funMap.put(MOVE, this::move);
		funMap.put(IS_FINISHED, this::isFinished);
	}

	@Override
	public ResponseJava getResponse(RequestJava request) {
		Function<Serializable, ResponseJava> response = funMap.getOrDefault(request.requestType, this::wrongRequest);
		return response.apply(request.requestData);
	}

	private ResponseJava startGame(Serializable requestData) {
		try {
			String res = game.startGame();
			ResponseJava response = new ResponseJava(TcpResponseCode.OK, res);
			return response;
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.UNKNOWN, e.getMessage());
		}
	}

	private ResponseJava prompt(Serializable requestData) {
		try {
			String res = game.prompt();
			ResponseJava response = new ResponseJava(TcpResponseCode.OK, res);
			return response;
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.UNKNOWN, e.getMessage());
		}
	}

	private ResponseJava move(Serializable requestData) {
		try {
			String res = game.move((String) requestData);
			ResponseJava response = new ResponseJava(TcpResponseCode.OK, res);
			return response;
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.UNKNOWN, e.getMessage());
		}
	}

	private ResponseJava isFinished(Serializable requestData) {
		try {
			boolean res = game.isFinished();
			ResponseJava response = new ResponseJava(TcpResponseCode.OK, res);
			return response;
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.UNKNOWN, e.getMessage());
		}
	}

	private ResponseJava wrongRequest(Serializable requestData) {
		return new ResponseJava(TcpResponseCode.WRONG_REQUEST, "Type of request not found");
	}
}
