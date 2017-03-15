package org.restcomm.connect.rvd.model.steps.dial;

import java.util.HashMap;
import java.util.Map;

import org.restcomm.connect.rvd.utils.RvdUtils;
import org.restcomm.connect.rvd.exceptions.InterpreterException;
import org.restcomm.connect.rvd.interpreter.Interpreter;

/**
 * @author Orestis Tsakiridis - otsakir@gmail.com
 */
public class NumberDialNoun extends DialNoun {

    private String destination;
    private String beforeConnectModule;
    private String sendDigits;
    private String statusCallback;


    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getBeforeConnectModule() {
        return beforeConnectModule;
    }
    public void setBeforeConnectModule(String beforeConnectModule) {
        this.beforeConnectModule = beforeConnectModule;
    }
    public String getSendDigits() {
        return sendDigits;
    }
    public void setSendDigits(String sendDigits) {
        this.sendDigits = sendDigits;
    }


    @Override
    public RcmlNoun render(Interpreter interpreter) throws InterpreterException {
        RcmlNumberNoun rcmlNoun = new RcmlNumberNoun();

        if ( ! RvdUtils.isEmpty(getBeforeConnectModule()) ) {
            Map<String, String> pairs = new HashMap<String, String>();
            pairs.put("target", getBeforeConnectModule());
            rcmlNoun.setUrl( interpreter.buildAction(pairs) );
        }

        rcmlNoun.setSendDigits( getSendDigits() );
        rcmlNoun.setDestination( interpreter.populateVariables( getDestination() ));
        if (!RvdUtils.isEmpty(statusCallback))
            rcmlNoun.statusCallback = statusCallback;

        return rcmlNoun;
    }
}
