
package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.wsdl.GetQuote;
import hello.wsdl.GetClientResponse;

public class WsClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(WsClient.class);

	public GetClientResponse get(String name) {

		GetMessage request = new GetMessage();
		request.setSymbol(ticker);

		log.info("Requesting quote for " + ticker);

		GetClientResponse response = (GetClientResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://endpoint/",
						request,
						new SoapActionCallback("http://myweservicecallback"));

		return response;
	}

}
