package org.radrso.plugins.requests.entity.exceptions.impl;

import org.radrso.plugins.requests.entity.ResponseCode;
import org.radrso.plugins.requests.entity.exceptions.BaseException;

/**
 * Created by raomengnan on 16-12-9.
 */

public class RequestException extends BaseException {
    public RequestException() {
        super();
    }

    public RequestException(ResponseCode code) {
        super(code);
    }

    public RequestException(String msg, ResponseCode code) {
        super(msg, code);
    }

    public RequestException(String msg, ResponseCode code, Throwable cause) {
        super(msg, code, cause);
    }

    public RequestException(ResponseCode code, Throwable cause) {
        super(code, cause);
    }
}
