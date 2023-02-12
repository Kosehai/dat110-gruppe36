package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class DisplayStub extends RPCLocalStub {

	public DisplayStub(RPCClient rpcclient) {
		super(rpcclient);
	}
	
	public void write (String message) {
		
		// TODO - START
		
		// implement marshalling, call and unmarshalling for write RPC method
		byte[] msgdata = RPCUtils.marshallString(message);
		byte[] resp = rpcclient.call((byte) Common.WRITE_RPCID, msgdata);
		String unmarsh = RPCUtils.unmarshallString(resp);
		
		// TODO - END
		
	}
}
