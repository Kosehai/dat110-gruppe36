package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class RPCUtils {

	public static byte[] encapsulate(byte rpcid, byte[] payload) {

		byte[] rpcmsg = new byte[payload.length + 1];

		rpcmsg[0] = rpcid;
		for (int i = 0; i < payload.length; i++) {
			rpcmsg[i + 1] = payload[i];
		}

		return rpcmsg;
	}

	public static byte[] decapsulate(byte[] rpcmsg) {

		byte[] payload = new byte[rpcmsg.length - 1];

		for (int i = 0; i < payload.length; i++) {
			payload[i] = rpcmsg[i + 1];
		}

		return payload;
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {

		byte[] encoded = new byte[str.length()];
		char[] chars = str.toCharArray();

		for (int i = 0; i < encoded.length; i++) {
			encoded[i] = (byte) chars[i];
		}

		return encoded;
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		return new String(data, Charset.defaultCharset());
	}

	public static byte[] marshallVoid() {

		byte[] encoded = new byte[]{
			0
		};

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {

		byte[] encoded = new byte[1];

		if (b) {
			encoded[0] = 1;
		} else {
			encoded[0] = 0;
		}

		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {

		return (data[0] > 0);

	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		byte[] encoded = new byte[4];
		ByteBuffer bytes = ByteBuffer.wrap(encoded);
		bytes.putInt(x);

		return encoded;
	}

	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {

		ByteBuffer bytes = ByteBuffer.wrap(data);
		int decoded = bytes.getInt();

		return decoded;

	}
}
